import java.util.HashMap;

public class day6 {
    
    static class pair{
        int start;
        int freq;
        int end;
    }
    static void SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement(String s){
        // simple approcah find max occuring char and then find start and end index of that char
        // abcdaddadefdga d is max op daddaefd
        // fre> , freq= but len<, freq= len= then first occurance   abadd op- dd,  abadxd op- a
        HashMap<Character, pair> map = new HashMap<>();
        int maxFreq = 0;
        char ans = '\0';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                pair tempPair = map.get(ch);
                tempPair.end = i;
                // adda
                tempPair.freq+=1;
                if(tempPair.freq == maxFreq){
                    pair efp = map.get(ans);
                    if((tempPair.end - tempPair.start)< (efp.end - efp.start) ){
                        ans = ch;
                        maxFreq = tempPair.freq;
                    }
                    // System.out.println("-----------");
                }else if(tempPair.freq>maxFreq ){
                    ans = ch;
                    maxFreq = tempPair.freq;
                    
                }
                
                map.put(ch, tempPair);
            }else{
                pair p = new pair();
                p.start = i;
                map.put(ch, p);
            }
        }
        pair ansPair = map.get(ans);
        System.out.println(ans);
        System.out.println(s.substring(ansPair.start, ansPair.end+1));
    }

    static class pair2{
        int count;
        int start;
    }
    static int indexOfFirstCharThatNeverRepeats(String s){
        // fill freq hashmap and then second traversal return first  ch with only 1 freq 
        // use 26 size [-1] array and loop in for first occ put value in arr 0 and if repeats put -2    
        int arr[] = new int[26];
        for(int i=0;i<arr.length;i++)
            arr[i] = -1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int index = ch-'a';
            if(arr[index]==-1)
                arr[index]=0;
            else if(arr[index]==0)
                arr[index] = -2;
        }

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int index = ch-'a';
            if(arr[index]==0){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement("abadd");
        System.out.println('b'-'a');
    }
}
