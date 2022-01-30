import java.util.*;
  
  public class anyBaseToanyBase{
    public static int getValueIndecimal(int n, int b){

        double ans=0;
        int count=0;
        
        while(n>0){
            int digit = n%10;
            ans = ans + digit*(Math.pow(b, count));
            n= n/10;
            count++;
        }
        int value = (int)ans;
        return value;
   }
   public static int toBase(int num , int tobase){
    int count=0;
    double retNum=0;
    while(num!=0){
        int nextNum = num/tobase;
        int remainder = num-(nextNum*tobase);
        retNum = retNum + remainder*Math.pow(10, count);
        count++;
        num= nextNum;
    }
    
    int value = (int)retNum;
    return value;
    // System.out.println(Math.round(value));
   }
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int tb = getValueIndecimal(n, sourceBase);
     int ans = toBase(tb, destBase);
     
     System.out.println(ans);
     
   }   
  }