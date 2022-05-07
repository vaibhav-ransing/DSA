public class combination {
    
    public static void combinations(int cb, int tb, int asfLen, int totalItems, String asf){
        
        if(asfLen == tb){
            if(cb==totalItems+1){
                System.out.println(asf);
            }
            return;
        }

        combinations(cb+1, tb, asfLen+1, totalItems, asf+cb);
        combinations(cb, tb, asfLen+1, totalItems, asf+'-');
    }

    public static void combinations2(int[] boxes, int ci, int totalItems, int lb){
        // write your code here new int[nboxes], 1, ritems, -1
        if(lb>=boxes.length-1 || ci> totalItems){
            if(ci>totalItems){
                for(int val: boxes){
                    if(val!=0)
                        System.out.print('i');
                    else
                        System.out.print('-');
                }
                System.out.println();
            }
            return;
        }

        for(int i=lb+1; i<boxes.length; i++){
            boxes[i] = ci;
            combinations2(boxes, ci+1, totalItems, i);                               
            boxes[i] = 0;
        }
    }

    public static void main(String[] args) {
        int nboxes = 3;
        int totalItems = 2;
        // combinations(1, 5, 0, totalItems, "");
        combinations2(new int[nboxes] , 1, totalItems, -1);
        
    }
}
