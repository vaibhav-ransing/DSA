public class Main {
    

    public static void main(String[] args) {
        UserManagement um = new UserManagement();
        um.addUser(new User("vaibhav"));
        um.addUser(new User("PP"));

        while (um.getIterator().hasNext()) {
            System.out.println("Hello");
        }
    }
}
