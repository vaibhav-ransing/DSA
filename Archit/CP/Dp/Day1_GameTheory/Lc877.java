package CP.Dp.Day1_GameTheory;

public class Lc877 {

    public boolean stoneGame(int[] piles) {
        int odd = 0;
        int even = 0;
        for(int i=0; i<piles.length; i++){
            if(i%2==0){
                even+=piles[i];
            }else{
                odd+=piles[i];
            }
        }
        return (odd>even || even>odd);
    }
}