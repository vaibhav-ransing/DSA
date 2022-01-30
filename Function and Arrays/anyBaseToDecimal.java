import java.util.*;
  
   class Main2{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
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
  }