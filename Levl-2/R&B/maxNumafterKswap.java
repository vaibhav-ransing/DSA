public class maxNumafterKswap {
    

    static int max = Integer.MIN_VALUE;
    static void solution(String s, int k, int index){

        int currVal = Integer.parseInt(s);
        if(currVal>max){
            max = currVal;
        }
        if(k==0)
            return;

        for(int i=index;i<s.length(); i++){
            String temp = swap(s, index, i);
            solution(temp, k-1, index+1);
        }
    }
    static String swap(String s, int i, int j){
        char ch[] = s.toCharArray();
        char ci = ch[i];
        ch[i] = ch[j];
        ch[j] = ci;
        return String.valueOf(ch);
    }



    public static void main(String[] args) {
        solution("1234567", 4, 0);
        System.out.println(max);
    }
}
