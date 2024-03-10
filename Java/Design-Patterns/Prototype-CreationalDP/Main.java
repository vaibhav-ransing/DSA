public class Main {
    


    public static void main(String[] args) {
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp("1924.14.22.19");
        networkConnection.loadImpData();

        
        NetworkConnection networkConnection2 = null;
        try {
            networkConnection2 = (NetworkConnection) networkConnection.clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(networkConnection);
        networkConnection.setList(1, "Rahul");
        System.out.println(networkConnection);
        System.out.println(networkConnection2);
    }
}
