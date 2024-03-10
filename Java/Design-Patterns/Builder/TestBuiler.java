public class TestBuiler {
    


    public static void main(String[] args) {
        
        User user = User.builder()
                    .setId("1")
                    .setEmail("vaibnhav@gmailc.omc")
                    .setName("vaibhav")
                    .build();

        System.out.println(user.getName());

    }
}
