import java.util.ArrayList;
import java.util.Stack;


public class gt {
    static class tree{
        int data;
        ArrayList<tree> child=new ArrayList<>();
    }

    static tree constructor(int arr[]){

        tree root=null;
        Stack<tree> st=new Stack<>();

        for(int i=0;i<arr.length;i++){

            if(arr[i]==-1) {
                st.pop();
                continue;
            }
            
            tree t=new tree();
            t.data=arr[i];
        
            if(st.size()==0) root=t;
            else st.peek().child.add(t);

            st.push(t);
        }
        return root;
    }
 
    static void display(tree p){
        System.out.println(p.data);
        for(tree c:p.child){
            display(c);
        } 
    }

    public static void main(String[] args) {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        // display(constructor(arr));
        tree root = constructor(arr);
        display(root);

        
    }
}