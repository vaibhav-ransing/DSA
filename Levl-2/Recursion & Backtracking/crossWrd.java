// import java.io.*;
// import java.util.*;

// public class Main {

//   public static void solution(char[][] arr, String[] words, int vidx) {
//    if(vidx == words.length){
//         print(arr);
//         return;    
//    }
   
//    String word = words[vidx];
//    for(int i = 0; i < arr.length; i++){
//        for(int j = 0; j < arr.length; j++){
//            if(canPlaceVertically(arr, word, i, j) == true){
//                 boolean[] placed = new boolean[word.length()];
//                 placeVertically(arr, i, j, word, placed);
//                 solution(arr, words, vidx + 1);
//                 unplaceVertically(arr, i, j, placed);
//            }
           
//            if(canPlaceHorizontally(arr, i, j, word) == true){
//                 boolean[] placed = new boolean[word.length()];
//                 placeHorizontally(arr, i, j, word, placed);
//                 solution(arr, words, vidx + 1);
//                 unplaceHorizontally(arr, i, j, placed);
//            }
//        }
//    }
//   }
  
//   static boolean canPlaceVertically(char arr[][], String word, int i, int j){
//     for(int w=0; w<word.length(); w++){
//         char ch = word.charAt(w);
//         if(i+w<arr.length && (arr[i+w][j]!='-' || arr[i+w][j]!=ch)){
//           System.out.println(ch+" "+ '-'+" "+arr[i+w][j] );
//             return false;
//         }
//     }
//     if(i-1>=0 && arr[i-1][j]=='-')
//         return false;
//     if(i+word.length()+1<arr.length && arr[i+word.length()+1][j]=='-')
//         return false;
//     return true;
//   }


//   static void placeVertically(char[][] arr, int i, int j, String word, boolean[] placed){
//       for(int k = 0; k < word.length(); k++){
//           if(arr[i + k][j] == '-'){
//             arr[i + k][j] = word.charAt(k);
//             placed[k] = true;
//           } else {
//               placed[k] = false;
//           }
//       }
//   }
  
//   static void unplaceVertically(char[][] arr, int i, int j, boolean[] placed){
//       for(int k = 0; k < placed.length; k++){
//           if(placed[k] == true){
//               arr[i + k][j] = '-';
//           }
//       }
//   }
  
//   static void placeHorizontally(char[][] arr, int i, int j, String word, boolean[] placed){
//       for(int k = 0; k < word.length(); k++){
//           if(arr[i][j + k] == '-'){
//             arr[i][j + k] = word.charAt(k);
//             placed[k] = true;
//           } else {
//               placed[k] = false;
//           }
//       }
//   }
  
//   static void unplaceHorizontally(char[][] arr, int i, int j, boolean[] placed){
//       for(int k = 0; k < placed.length; k++){
//           if(placed[k] == true){
//               arr[i][j + k] = '-';
//           }
//       }
//   }


//   public static void print(char[][] arr) {
//     for (int i = 0 ; i < arr.length; i++) {
//       for (int j = 0 ; j < arr.length; j++) {
//         System.out.print(arr[i][j]);
//       }
//       System.out.println();
//     }

//   }
//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//     char[][] arr = new char[10][10];
//     for (int i = 0 ; i < arr.length; i++) {
//       String str = scn.next();
//       arr[i] = str.toCharArray();
//     }
//     int n = scn.nextInt();
//     String[] words = new String[n];
//     for (int i = 0 ; i  < words.length; i++) {
//       words[i] = scn.next();
//     }
//     solution(arr, words, 0);
//   }
// }