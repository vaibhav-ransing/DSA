import java.util.*;
import java.util.stream.Collectors;

enum TransactionType {
    CREDIT, DEBIT
}

enum PaymentMethod {
    CREDIT_CARD, DEBIT_CARD, UPI, WALLET
}

enum Source {
    USER, FD, TOPUP, WALLET
}


class MoneySource {
    String name;
    Source source;

    public MoneySource(String name, Source source) {
        this.name = name;
        this.source = source;
    }


    public String getName() {
        return name;
    }

    public Source getSource() {
        return source;
    }
}

class User {
    private final int userId;
    private final String name;
    private final Wallet wallet;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

class Wallet {
    private double balance;
    private final Map<PaymentMethod, List<Transaction>> transactionHistory;
    private FixedDeposit fixedDeposit;

    public Wallet() {
        this.balance = 0;
        this.transactionHistory = new HashMap<>();
        this.fixedDeposit = null;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(PaymentMethod method, Transaction transaction) {
        transactionHistory.putIfAbsent(method, new ArrayList<>());
        transactionHistory.get(method).add(transaction);
    }

    public List<Transaction> getTransactionHistory(TransactionType type) {
        return transactionHistory.values().stream()
                .flatMap(Collection::stream)
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());
    }

    public int getTransactionCount(PaymentMethod method) {
        return transactionHistory.getOrDefault(method, Collections.emptyList()).size();
    }

    public void adjustBalance(double amount) {
        this.balance += amount;
    }

    public FixedDeposit getFixedDeposit() {
        return fixedDeposit;
    }

    public void setFixedDeposit(FixedDeposit fixedDeposit) {
        this.fixedDeposit = fixedDeposit;
    }
}

class Transaction {
    private final double amount;
    private final Date date;
    private final TransactionType type;
    private final MoneySource from;
    private final MoneySource to;

    public Transaction(double amount, TransactionType type, MoneySource from, MoneySource to) {
        this.amount = amount;
        this.type = type;
        this.date = new Date();
        this.from = from;
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public String toString(){
        return "From " + this.from.getName() + " to " + this.to.getName() + " amount " + this.amount + " type " + this.type + " date " + this.date;
    }
}

class FixedDeposit {
    private final double amount;
    private final Date startDate;

    public FixedDeposit(double amount) {
        this.amount = amount;
        this.startDate = new Date();
    }

    public double getAmount() {
        return amount;
    }

    public Date getStartDate() {
        return startDate;
    }
}

class WalletService {
    private final Map<Integer, User> users = new HashMap<>();
    private int userIdCounter = 1;

    public int registerUser(String name) {
        User user = new User(userIdCounter++, name);
        users.put(user.getUserId(), user);
        return user.getUserId();
    }

    public void topUpWallet(int userId, PaymentMethod method, double amount) throws Exception {
        User user = getUser(userId);
        Wallet wallet = user.getWallet();

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }

        PaymentMethodStrategy strategy = PaymentMethodStrategyFactory.getStrategy(method);
        strategy.validate(wallet, amount);

        wallet.adjustBalance(amount);
        wallet.addTransaction(method, new Transaction(amount, TransactionType.CREDIT, new MoneySource("TopUp",Source.TOPUP), new MoneySource(user.getName(),Source.USER)));
        System.out.println("Wallet topped up successfully.");
    }

    public double fetchBalance(int userId) throws Exception {
        User user = getUser(userId);
        Wallet wallet = user.getWallet();
        return wallet.getBalance();
    }

    public void sendMoney(int fromUserId, int toUserId, double amount) throws Exception {
        User fromUser = getUser(fromUserId);
        User toUser = getUser(toUserId);

        Wallet senderWallet = fromUser.getWallet();
        Wallet receiverWallet = toUser.getWallet();

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }

        if (senderWallet.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        senderWallet.adjustBalance(-amount);
        receiverWallet.adjustBalance(amount);
        senderWallet.addTransaction(PaymentMethod.WALLET, new Transaction(-amount, TransactionType.DEBIT, new MoneySource(fromUser.getName(),Source.USER), new MoneySource(toUser.getName(),Source.USER)));
        receiverWallet.addTransaction(PaymentMethod.WALLET, new Transaction(amount, TransactionType.CREDIT, new MoneySource(fromUser.getName(),Source.USER),  new MoneySource(toUser.getName(),Source.USER)));

        System.out.println("Money sent successfully.");
    }

    public void createDeposit(int userId, double amount) throws Exception {
        User user = getUser(userId);
        Wallet wallet = user.getWallet();

        if (wallet.getFixedDeposit() != null) {
            throw new IllegalStateException("Fixed deposit already exists.");
        }

        if (wallet.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        wallet.adjustBalance(-amount);
        wallet.setFixedDeposit(new FixedDeposit(amount));
        wallet.addTransaction(PaymentMethod.WALLET, new Transaction(-amount, TransactionType.DEBIT, new MoneySource("Wallet",Source.WALLET), new MoneySource("FD",Source.FD)));
        System.out.println("Fixed deposit created successfully.");
    }

    public void dissolveDeposit(int userId) throws Exception {
        User user = getUser(userId);
        Wallet wallet = user.getWallet();
        FixedDeposit fd = wallet.getFixedDeposit();

        if (fd == null) {
            throw new IllegalStateException("No fixed deposit exists.");
        }

        wallet.adjustBalance(fd.getAmount());
        wallet.setFixedDeposit(null);
        wallet.addTransaction(PaymentMethod.WALLET, new Transaction(fd.getAmount(), TransactionType.CREDIT, new MoneySource("FD",Source.FD), new MoneySource("WALLET",Source.WALLET)));
        System.out.println("Fixed deposit dissolved successfully.");
    }

    public List<Transaction> getTransactions(int userId, TransactionType type, Comparator<Transaction> sorter) throws Exception {
        User user = getUser(userId);
        Wallet wallet = user.getWallet();

        return wallet.getTransactionHistory(type).stream()
                .sorted(sorter)
                .collect(Collectors.toList());
    }

    private User getUser(int userId) throws Exception {
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("User not registered.");
        }
        return users.get(userId);
    }
}

// --------------------------------------------------------------------------------
interface PaymentMethodStrategy {
    void validate(Wallet wallet, double amount) throws Exception;
}

class CreditCardStrategy implements PaymentMethodStrategy {
    @Override
    public void validate(Wallet wallet, double amount) throws Exception {
        if (wallet.getTransactionCount(PaymentMethod.CREDIT_CARD) >= 3) {
            throw new IllegalArgumentException("Credit card transaction limit reached.");
        }
    }
}

class UpiStrategy implements PaymentMethodStrategy {
    @Override
    public void validate(Wallet wallet, double amount) throws Exception {
        if (amount > 1000) {
            throw new IllegalArgumentException("UPI transaction limit exceeded.");
        }
    }
}

class DebitCardStrategy implements PaymentMethodStrategy {
    @Override
    public void validate(Wallet wallet, double amount) throws Exception {
        if (wallet.getTransactionCount(PaymentMethod.DEBIT_CARD) >= 3) {
            wallet.adjustBalance(-1);
        }
    }
}

class PaymentMethodStrategyFactory {
    public static PaymentMethodStrategy getStrategy(PaymentMethod method) {
        switch (method) {
            case CREDIT_CARD:
                return new CreditCardStrategy();
            case UPI:
                return new UpiStrategy();
            case DEBIT_CARD:
                return new DebitCardStrategy();
            default:
                throw new IllegalArgumentException("Unknown Payment method.");
        }
    }
}

// --------------------------------------------------------------------------------
public class FlipkartWallet {
    public static void main(String[] args) {
        try {
            WalletService service = new WalletService();

            // Test cases
            System.out.println("Fetching balance for non-registered user Bob");
            try {
                service.fetchBalance(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Registering user Bob");
            int bobId = service.registerUser("Bob");
            System.out.println("Bob's ID: " + bobId);

            System.out.println("Registering user Jack");
            int jackId = service.registerUser("Jack");
            System.out.println("Jack's ID: " + jackId);

            System.out.println("Topping up Bob's wallet with Credit Card");
            service.topUpWallet(bobId, PaymentMethod.CREDIT_CARD, 1000);

            System.out.println("Topping up Bob's wallet with UPI");
            service.topUpWallet(bobId, PaymentMethod.UPI, 100);

            System.out.println("Fetching Bob's balance");
            System.out.println("Balance: " + service.fetchBalance(bobId));

            System.out.println("Attempting to top up Bob's wallet with UPI over the limit");
            try {
                service.topUpWallet(bobId, PaymentMethod.UPI, 2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Registering user Alice");
            int aliceId = service.registerUser("Alice");
            System.out.println("Alice's ID: " + aliceId);

            System .out.println("Topping up Alice's wallet with Credit Card");
            service.topUpWallet(aliceId, PaymentMethod.CREDIT_CARD, 100);

            System.out.println("Fetching Alice's balance");
            System.out.println("Balance: " + service.fetchBalance(aliceId));

            System.out.println("Topping up Alice's wallet with Credit Card again");
            service.topUpWallet(aliceId, PaymentMethod.CREDIT_CARD, 200);

            System.out.println("Topping up Alice's wallet with Credit Card for the third time");
            service.topUpWallet(aliceId, PaymentMethod.CREDIT_CARD, 100);

            System.out.println("Attempting to top up Alice's wallet with Credit Card over the transaction limit");
            try {
                service.topUpWallet(aliceId, PaymentMethod.CREDIT_CARD, 100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Attempting to send more money than Bob's balance to Alice");
            try {
                service.sendMoney(bobId, aliceId, 1250);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Sending money from Bob to Alice");
            service.sendMoney(bobId, aliceId, 250);

            System.out.println("Sending money from Alice to Bob");
            service.sendMoney(aliceId, bobId, 50);

            System.out.println("Sending money from Bob to Jack");
            service.sendMoney(bobId, jackId, 100);

            System.out.println("Fetching Bob's balance");
            System.out.println("Balance: " + service.fetchBalance(bobId));

            System.out.println("Creating a fixed deposit for Bob");
            service.createDeposit(bobId, 500);

            System.out.println("Fetching Alice's balance");
            System.out.println("Balance: " + service.fetchBalance(aliceId));

            System.out.println("Fetching Bob's balance");
            System.out.println("Balance: " + service.fetchBalance(bobId));

            System.out.println("Fetching Jack's balance");
            System.out.println("Balance: " + service.fetchBalance(jackId));

            // Get transactions sorted by amount
            System.out.println("Bob's transactions sorted by amount:");
            List<Transaction> transactions = service.getTransactions(bobId, TransactionType.CREDIT, Comparator.comparing(Transaction::getAmount));
            for (Transaction transaction : transactions) {
//                System.out.println(transaction.getAmount() + " " + transaction.getDate() + " " + transaction.getType() + " from " + transaction.getFromUser() + " to " + transaction.getToUser());
                System.out.println(transaction);
            }

            // Get transactions sorted by date time
            System.out.println("Bob's transactions sorted by date time:");
            transactions = service.getTransactions(bobId, TransactionType.CREDIT, Comparator.comparing(Transaction::getDate));
            for (Transaction transaction : transactions) {
//                System.out.println(transaction.getAmount() + " " + transaction.getDate() + " " + transaction.getType() + " from " + transaction.getFromUser() + " to " + transaction.getToUser());
                System.out.println(transaction);
            }

            // Get debit transactions sorted by time
            System.out.println("Bob's debit transactions sorted by time:");
            transactions = service.getTransactions(bobId, TransactionType.DEBIT, Comparator.comparing(Transaction::getDate));
            for (Transaction transaction : transactions) {
//                System.out.println(transaction.getAmount() + " " + transaction.getDate() + " " + transaction.getType() + " from " + transaction.getFromUser() + " to " + transaction.getToUser());
                System.out.println(transaction);
            }

            // Book fixed deposit
            System.out.println("Booking Bob's fixed deposit");
            service.dissolveDeposit(bobId);
            System.out.println("Fetching Bob's balance");
            System.out.println("Balance: " + service.fetchBalance(bobId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
