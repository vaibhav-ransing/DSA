import java.io.*;
import java.util.*;

public class temp {
    

    static int peterNo(int n , int sum){
        int maxNum = maxNum(1, n);
        boolean ans = false;
        while(lenOfInt(maxNum)==n){
            if(sum(maxNum)==sum){
                ans = true;
                break;
            }
            maxNum--;
        }
        if(ans)
            return maxNum;
        else
            return -1;
    }
    
    static int lenOfInt(int val){
        if(val==0)
            return 0;
        return 1+lenOfInt(val/10);
    }
    static int maxNum(int nStop , int n){
        if(nStop>=n)
            return 9;
        int v = 9* (int)Math.pow(10, nStop); 
        return v+maxNum(nStop+1, n);
    }
    static int sum(int number){
        if(number==0)
            return 0;
        int val = number%10;
        return val+sum(number/10);
    }
    public static void main(String[] args) {
        System.out.println(peterNo(3, 15));
    }
}
