public class test {

    public static void main(String[] args) {
        String s = "vaibhav \n is \n vaibhav";
        String temp = s;
        
        if(temp.contains("hello")){
            temp = temp.replaceAll("test", "may");
            System.out.println("HELLO HAI ISME");
        }
            
        if(temp.contains("vaibhav")){
            temp = temp.replaceAll("vaibhav", "asdfasd");
            System.out.println("Vaibhav HAI ISME");
        }

        System.out.println(temp);
    }
}
