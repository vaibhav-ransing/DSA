import java.util.ArrayList;

public class test{

    static void solution(int n,int fn, int k, ArrayList<ArrayList<Integer>> ans){
        if(n> fn){
            if(k==0){
                System.out.println(ans);
            }
            return;
        }

        for(int i=0;i<ans.size();i++){
            ArrayList<Integer> temp = ans.get(i);
            if(temp.size()>0){
                temp.add(n);
                solution(n+1,fn, k, ans);
                temp.remove(temp.size()-1);
            }else{
                temp.add(n);
                solution(n+1,fn, k-1, ans);
                temp.remove(temp.size()-1);
                break;
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        solution(1, 3, 2, ans);
    }
}