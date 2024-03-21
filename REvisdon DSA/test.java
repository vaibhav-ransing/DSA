

public class test{

    public static String getOriginalString(String input1){
        String input1WithoutI = getStringWithoutI(input1);
        int len = input1WithoutI.length();
        String firstHalf = input1WithoutI.substring(0, len/2);
        String secndHalf = input1WithoutI.substring(len/2);
       
        if((len%2) != 0 || firstHalf.equals(secndHalf) == false){
            return "notpossible";
        }
        return input1.substring(0, (input1.length() - (len)/2) );
    }

    public static String getStringWithoutI(String input1){
        StringBuilder sb = new StringBuilder();
        for(char ch: input1.toCharArray()){
            if(ch!='i'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello");

    }
}