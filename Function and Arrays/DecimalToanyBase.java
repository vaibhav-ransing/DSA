public class DecimalToanyBase {
    


    public static void main(String[] args) {
        int num =634;
        int tobase = 8;

        double retNum=0;
        int count=0;

        // System.out.println(num/8);

        while(num!=0){
            int nextNum = num/tobase;
            int remainder = num-(nextNum*tobase);
            retNum = retNum + remainder*Math.pow(10, count);
            count++;
            num= nextNum;
        }
        
        int value = (int)retNum;
        System.out.println(Math.round(value));

    }   
}
