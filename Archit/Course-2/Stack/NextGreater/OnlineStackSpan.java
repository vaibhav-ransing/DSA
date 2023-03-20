import java.util.ArrayList;
import java.util.Stack;

public class OnlineStackSpan {
    
    class StockSpanner {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>(); 

        public int next(int price) {
            arr.add(price);
            while(stack.size()>0 && arr.get(stack.peek()) < price ){
                stack.pop();
            }
            int span = 0;
            if(stack.size()==0){
                span = arr.size();
            }else{
                span = arr.size() - stack.peek()-1;
            }
            stack.push(arr.size()-1);
            return span;
        }
    }

    public static void main(String[] args) {
        
    }
}


