import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> sol = new ArrayList<>();

	static void solution(int[] people, int nskills, int index, ArrayList<Integer> onesol, int skills){
        if(index==people.length){
            int ans = (1<<nskills)-1;
            if(skills==ans){
                if(sol.size()==0 || sol.size()>onesol.size()){
                    // sol = onesol;
                    sol = new ArrayList<>(onesol);
                }
            }
            return;
        }
        solution(people, nskills, index+1, onesol, skills);
        onesol.add(index);
        skills^=people[index];
        solution(people, nskills, index+1, onesol, skills);
        onesol.remove(onesol.size()-1);
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		}
		
		int np = scn.nextInt();
		int[] people = new int[np];
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt();
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
				people[i] = people[i] | (1 << snum);
			}
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);
		
	}
}