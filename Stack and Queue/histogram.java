import java.util.Stack;

public class histogram {
    
    public static void histogramSoln(int arr[]){

        int[] left  = new int[arr.length];
        Stack<Integer> ls = new Stack<>();
        ls.push(0);
        left[0]=1;
        for(int i=1;i<arr.length;i++){
            while(ls.size()>0 && arr[i] <= arr[ls.peek()]){
                ls.pop();
            }
            if(ls.size()==0){
                left[i] = i+1;
            }else{
                left[i] = i-ls.peek();
            }
            ls.push(i);
        }   
        
        int[] right = new int[arr.length];
        Stack<Integer> rs = new Stack<>();
        rs.push(arr.length-1);
        right[arr.length-1]=1;
        for(int i=arr.length-2;i>=0;i--){
            while(rs.size()>0 && arr[i] <=arr[rs.peek()]){
                rs.pop();
            }
            if(rs.size()==0){
                right[i] = arr.length - i;
            }else{
                right[i] = rs.peek() - i;
            }
            rs.push(i);
        }

        String l ="";
        String r ="";
        for(int i=0;i<arr.length;i++){
            l+=left[i]+" ";
            r+=right[i]+" ";
        }
        System.out.println(l);
        System.out.println(r);

        int area = 0;
        for(int i=0;i<arr.length;i++){
            int val = arr[i]*(left[i]+ right[i]-1);
            if(val>area)
                area= val;
        }
        System.out.println(area);

    }




    public static void main(String[] args) {
        int arr[] = {6,2,5,4,5,1,6};
        histogramSoln(arr);
    }
}
