public class kokoBananEating {

    public int minEatingSpeed(int[] piles, int h) {
        long left = 1, right = (long)1e9;

        while(left<right){
            long mid = (left+right)/2;
            boolean val = canEatBanan(piles, h, (int) mid);
            if(val){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int) left;
    }

    public boolean canEatBanan(int[] piles, int availableHours, int speedEating) {
        int tookHours = 0;

        for (int pile : piles) {
            int hours = pile/speedEating;
            if(pile%speedEating != 0) hours++;
            tookHours += hours;
        }
        return tookHours <= availableHours;
    }
}
