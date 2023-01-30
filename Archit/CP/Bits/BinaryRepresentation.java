package CP.Bits;

public class BinaryRepresentation {
    

    static String getBinaryRep(int N){
        // code here
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<30; i++){
            sb.append(N&1);
            N = N>>1;
        }
        return sb.reverse().toString();
    }


}
