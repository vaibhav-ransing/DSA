public class Daily {

    public int passThePillow(int n, int time) {
        boolean leftSide = (time / (n-1)) % 2 == 0;
        if(leftSide){
            return (time % (n-1));
        }else{
            return n - (time % (n-1));
        }
    }
}
