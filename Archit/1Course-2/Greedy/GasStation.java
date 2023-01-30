
public class GasStation {
    
    public int canCompleteCircuitBrute(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0; i<n; i++){
            int fuel = 0;
            boolean ans = true;

            for(int j=0; j<n; j++){
                int currIdx = (i+j)%n;
                fuel+=gas[currIdx];
                if(fuel < cost[currIdx]){
                    ans = false;
                }
                fuel-=cost[currIdx];
            }
            if(ans){
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit= 0, start=0, fuel=0;

        for(int idx=0; idx<gas.length; idx++){
            fuel+= gas[idx] - cost[idx];
            if(fuel<0){
                start=idx+1;
                deficit+=-fuel;
                fuel=0;
            }
        }
        if(deficit<fuel){
            return start;
        }
        return -1;
    }


    public static void main(String[] args) {
        
    }
}
