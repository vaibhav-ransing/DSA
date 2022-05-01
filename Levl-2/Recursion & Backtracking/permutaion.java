public class permutaion{

    public static void permutations1(int[] boxes, int ci, int ti){
        // write your code here
        if(ci>ti){
            for(int val:boxes){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i] = ci;
                permutations1(boxes, ci+1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void combinations(int cb, int tb, int index, int ritems, String asf){
        // write your code here
        if(cb > ritems){
          while(asf.length()!=tb){
            asf+="_";
          }
          System.out.println(asf);
          return;
    
        }
        if(index >= tb){
          return;
        }
        combinations(cb+1, tb, index+1, ritems, asf+cb);
        combinations(cb, tb, index+1, ritems, asf+"_");
      }
    
      
    
    public static void main(String[] args) {
        
    }
}