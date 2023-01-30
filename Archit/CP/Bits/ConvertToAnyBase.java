package CP.Bits;

public class ConvertToAnyBase {
    
    static char get(int n){
        if(n<10) return (char)(n+'0');
        if(n==10) return 'A';
        if(n==11) return 'B';
        if(n==12) return 'C';
        if(n==13) return 'D';
        if(n==14) return 'E';
        return 'F';
    }

    static String getNumber(int B, int N){
        StringBuilder sb = new StringBuilder();

        while(N != 0){
            char rem = get(N%B);
            sb.append(rem);
            N = N/B;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        
    }
}   
