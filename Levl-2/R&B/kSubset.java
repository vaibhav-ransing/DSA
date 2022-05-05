import java.util.ArrayList;

public class kSubset {
    
    public static void solution(int i, int n, int k, ArrayList<ArrayList<Integer>> ans) {
		if(i>n){
            if(k==0){
                System.out.println(ans);
            }
            return;
        }

        for(int j=0; j<ans.size(); j++){
            ArrayList<Integer> al = ans.get(j);
            if(al.size() >0){
                al.add(i);
                solution(i+1, n, k, ans);
                al.remove(al.size()-1);
            }else{
                
                al.add(i);
                solution(i+1, n, k-1, ans);
                al.remove(al.size()-1);
                break;
            }
        }
	} 
    

    public static void main(String[] args) {
        int n=3;
        int k=2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(new ArrayList<Integer>());
        }
        solution(1, n, k, ans);
    }
}
