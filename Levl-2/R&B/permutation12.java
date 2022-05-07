import java.util.HashMap;

public class permutation12 {

    public static void permutations(int[] boxes, int ci, int n){
        // write your code here
        if(ci>n){
            for(int val: boxes)
                System.out.print(val+" ");
            System.out.println();
            return;
        }
        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i] = ci;
                permutations(boxes, ci+1, n);
                boxes[i] = 0;
            }
        }
    }

    static void permutation2(int ritems, int[] pickedItems, int ansLen, String asf, int tb){

        if(ansLen==tb){
            boolean allSelected = true;
            for(int val: pickedItems){
                if(val==0){
                    allSelected=false;
                    break;
                }
            }
            if(allSelected){
                System.out.println(asf);
            }
            return;
        }

        for(int i=1; i<ritems+1; i++){
            if(pickedItems[i-1]==0){
                pickedItems[i-1]= 1;
                permutation2(ritems, pickedItems, ansLen+1, asf+i+"", tb);
                pickedItems[i-1]= 0;
            }
        }
        permutation2(ritems, pickedItems, ansLen+1, asf+"0", tb);
    }


    static void permutationOfString(String str, HashMap<Character, Integer> map, String asf){
        if(asf.length() == str.length()){
            System.out.println(asf);
            return;
        }

        for(char ch: map.keySet()){
            int freq = map.get(ch);
            if(freq>0){
                map.put(ch, freq-1);
                permutationOfString(str, map, asf+ch);
                map.put(ch, freq);
            }
        }
        
    }

    static void permuWord2(String str, int index, String[] asf){
        if(str.length()==0){
            for(String val: asf){
                System.out.print(val);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<str.length();i++){
            if(asf[i]==null){
                char ch = str.charAt(i);
                asf[i] = ch+"";
                String left = str.substring(0, i);
                String right = str.substring(i+1);
                permuWord2(left+right, index-1, asf);
                asf[i]=null;
            }
        }
    }

    static void permutationWord2(String str, char prevChar, int prevIndex, String[] asf, int idx){
        if(idx==str.length()){
            for(String val: asf){
                System.out.print(val);
            }
            System.out.println();
            return;
        }

        char ch = str.charAt(idx);
        for(int i=(prevChar==ch)? prevIndex+1:0; i<str.length(); i++){
            if(asf[i]==null){
                asf[i] = ch+"";
                permutationWord2(str, ch, i, asf,  idx+1);
                asf[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        // permutations(new int[5], 1, 3);
        // permutation2(2, new int[2], 0,"", 3);
        // HashMap<Character, Integer> map = new HashMap<>();
        // map.put('a', 2);
        // map.put('b', 2);
        // permutationOfString("aabb",map, "");

        // permuWord2("aab", 3, new String[3]);
        permutationWord2("aba", '\0', -1, new String[3], 0);
    }
}
