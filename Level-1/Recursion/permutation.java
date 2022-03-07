public class permutation{


        static void print(StringBuilder s, int index){

            if(index==s.length()){
                System.out.println(s);
                return;
            }
            
            for(int i=index;i<s.length();i++){
                swap(s, i, index);
                print(s, index+1);
                swap(s, i, index);
            }
            return;
        }
    static void swap(StringBuilder s , int start, int end){
        char startChar = s.charAt(start);
        s.setCharAt(start, s.charAt(end));
        s.setCharAt(end, startChar);

    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("abc");
        print(s, 0);
    }
}