package DP.Day8;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeIndia {
    
    static List<Integer> minPartition(int amt){
        List<Integer> change = new ArrayList<>();
        int[] coins = {2000,500,200,100,50,20,10,5,2,1};
        int idx = 0;
        while(amt > 0){
            while(amt > coins[idx]){
                change.add(coins[idx]);
                amt -= coins[idx];
            }
            idx++;
        }
        return change;
    }
}
