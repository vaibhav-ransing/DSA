package StackQueue.Day2;

import java.util.Stack;

public class lc_735 {
    
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int val: asteroids){

            System.out.println(val);
            if(val<0){
                boolean eqCheck = false;
                val = -val;
                if(stack.size()!=0){
                    while(stack.size()>0){
                        int opp = stack.peek();
                        if(opp==val){
                            eqCheck = true;
                            stack.pop();
                        }else if(opp<val && opp>0){
                            stack.pop();
                        }else{
                            break;
                        }
                    }
                    if((stack.size()==0 || stack.peek()<0) && eqCheck==false){
                        stack.push(-val);
                    }
                }else{
                    stack.push(-val);
                }
             
            }else{
                stack.push(val);
            }
        }
        int ans[] = new int[stack.size()];
        int i=stack.size()-1;
        while(stack.size()>0){
            ans[i--]= stack.pop();
        }
        return ans;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int val: asteroids){
        
        // [-2,-1,1,2]
        // op [1,2]
        // expop  [-2,-1,1,2]
        
            if(val<0){
                boolean eqCheck = false;
                val = -val;
                if(stack.size()!=0){
                    while(stack.size()>0){
                        int opp = stack.peek();
                        if(opp==val){
                            eqCheck = true; //got it equal wala
                            stack.pop(); 
                        }else if(opp<val && opp>0){  // top pe +ve hai and smaller than val hai to pop and continue
                            stack.pop();
                        }else{
                            break;
                        }
                    }
                }
                
               if((stack.size()==0 || stack.peek()<0) && eqCheck==false){ 
                      stack.push(-val);
               }	
              
            }else{
                stack.push(val);
            }
        }
        int ans[] = new int[stack.size()];
        int i=stack.size()-1;
        while(stack.size()>0){
            ans[i--]= stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
