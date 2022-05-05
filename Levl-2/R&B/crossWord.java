import java.util.*;

public class crossWord {

  public static void solution(char[][] arr, String[] words, int vidx) {
    //write your code here
    if(vidx==words.length){
        print(arr);
        return;
    }
    String word = words[vidx];
    for(int i=0; i<arr.length;i++){
        for(int j=0; j<arr[0].length; j++){
            if(canVerticalPlace(arr, word, i, j)){
                placeVertically(arr, word, i, j);
                solution(arr, words, vidx+1);
                removeVertically(arr, word, i, j);
            }
            if(canHorizontalPlace(arr, word, i, j)){
                placeHorizontally(arr, word, i, j);
                solution(arr, words, vidx+1);
                placeHorizontally(arr, word, i, j);
            }
        }   
    }   

  } 
  static boolean canVerticalPlace(char arr[][], String word, int i, int j){
    for(int w=0; w<word.length(); w++){
        char ch = word.charAt(w);
        if(i+w<arr.length && (arr[i+w][j]=='-' || arr[i+w][j]==ch)){
          continue;
        }else{
          return false;
        }
    }
    if(i-1>=0 && arr[i-1][j]=='-')
        return false;
    if(i+word.length()+1<arr.length && arr[i+word.length()+1][j]=='-')
        return false;
    return true;
  }
  static void placeVertically(char arr[][], String word, int i, int j){
    for(int w=0; w<word.length(); w++){
        char ch = word.charAt(w);
        arr[i+w][j]=ch;
    }
  }
  static void removeVertically(char arr[][], String word, int i, int j){
    for(int w=0; w<word.length(); w++){
        char ch = word.charAt(w);
        if(j-1>=0 && (arr[i][j-1]!='-' || arr[i][j-1]!='+')){
            continue;
        }else if(j+1<arr.length && (arr[i][j+1]!='-' || arr[i][j+1]!='+')){
            continue;
        }
        else{
            arr[i+w][j] = '-';
        }
    }
  }

  static boolean canHorizontalPlace(char arr[][], String word, int i, int j){
    for(int w=0; w<word.length(); w++){
        char ch = word.charAt(w);
        if( j+w<arr.length && (arr[i][j+w]=='-' || arr[i][j+w]==ch )){
            continue;
        }else{
          return false;
        }
    }
    if(j-1>=0 && arr[i][j-1]=='-' )
        return false;
    if(j+word.length()+1<arr.length && arr[i][j+word.length()+1]=='-')
        return false;
    return true;
  }
  static void placeHorizontally(char arr[][], String word, int i, int j){
    for(int w=0; w<word.length(); w++){
        char ch = word.charAt(w);
        arr[i][j+w]=ch;
    }
  }
  static void removeHorizontally(char arr[][], String word, int i, int j){
    for(int w=0; w<word.length(); w++){
        char ch = word.charAt(w);
        if(i-1>=0 && (arr[i-1][j]!='-' || arr[i-1][j]!='+')){
            continue;
        }else if(i+1<arr.length && (arr[i+1][j]!='-' || arr[i+1][j]!='+')){
            continue;
        }
        else{
            arr[i][j+w] = '-';
        }
    }
  }

  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}