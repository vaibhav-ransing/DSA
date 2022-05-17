import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
    int[] ngeri=solve(a);
    int gewi=0;

   //gewi-----> greater element window index
   //ngeri---> next greater element to the right index

    for(int i=0;i<a.length-k;i++){ 
       //bringing gewi to the right position
       if(gewi<i){gewi=i;}
       
       //shifting gewi
       while(ngeri[gewi]<i+k){
         gewi=ngeri[gewi];
       }

      //printing final gewi
       System.out.println(a[gewi]);    

   }

 }


public static int[] solve(int[] arr){
 
 //creating the array to store next greater element index to the right

 Stack<Integer> st=new Stack<>();

 int[] nge=new int[arr.length];

 for(int i=arr.length-1;i>=0;i--){

  //keep popping smaller elements in the stack
  while(st.size()>0 && arr[st.peek()]<=arr[i]){
     st.pop();
  }

  //putting next greater for current element
  if(st.size()==0){nge[i]=arr.length;}
  else{nge[i]=st.peek();}

  //pushing value of current element in stack
  st.push(i);
 
 }

 return nge;
 
}

}