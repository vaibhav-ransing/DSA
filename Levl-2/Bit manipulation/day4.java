import java.util.ArrayList;
import java.util.HashMap;

public class day4 {
    
    static ArrayList<Integer> sol = new ArrayList<>();
    static void minSoftwareDevelopers(int[] people, int nskills, int index, ArrayList<Integer> onesol, int skills){
        if(index==nskills){
            int ans = (1<<nskills)-1;
            if(skills==ans){
                if(sol.size()==0 || sol.size()>onesol.size()){
                    sol = onesol;
                }
            }
        }


        minSoftwareDevelopers(people, nskills, index+1, onesol, skills);
        onesol.add(people[index]);
        skills^=people[index];
        minSoftwareDevelopers(people, nskills, index+1, onesol, skills);
        onesol.remove(people[index]);
    }


    public static void main(String[] args) {
        String arr[] = {"a","b","c","d","e"};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }                        

    }
}
