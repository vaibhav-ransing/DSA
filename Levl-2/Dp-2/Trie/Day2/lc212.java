package Trie.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc212 {
    
    class Node {
        boolean eno;
        Node arr[] = new Node[26];
    }
    Node root;
    ArrayList<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        ans = new ArrayList<>();
        for(String word: words){
            Node node = root;
            for(char ch: word.toCharArray()){
                node.arr[ch-'a'] = new Node();
                node = node.arr[ch-'a'];
            }
            node.eno = true;
        }
        boolean visited[][] = new boolean[board.length][board[0].length];
    }
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void helper(boolean visited[][], int i, int j, Node node,char[][] board, StringBuilder sb){
        
        visited[i][j] = true;

        sb.append(board[i][j]);
        for(int d=0; d<dir.length; d++){
            int ii = dir[d][0]+i;
            int jj = dir[d][1]+j;
            if(ii>=0 && jj>=0 && ii<visited.length && jj<visited[0].length && visited[ii][jj]==false){
                helper(visited, ii, jj, node);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        visited[i][j] = false;
    }


    public static void main(String[] args) {
        
    }
}
