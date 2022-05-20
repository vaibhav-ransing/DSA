public class boolParanthesis {
    
    static void solution(boolean arr[], Character operator[]){
        int dpTrue[][] = new int[arr.length][arr.length];
        int dpFalse[][] = new int[arr.length][arr.length];

        for(int gap = 0; gap<arr.length; gap++){
            for(int i=0, j=gap; j<arr.length; j++, i++){
                if(gap==0){
                    dpTrue[i][j]= (arr[i]==true? 1:0);
                    dpFalse[i][j]= (arr[i]==true? 0:1);
                }else{
                    for(int k=i; k<j; k++){
                        char op = operator[k];
                        if(op=='&'){
                            dpTrue[i][j]+=dpTrue[i][k]*dpTrue[k+1][j];

                            dpFalse[i][j]+=dpFalse[i][k]*dpFalse[k+1][j];
                            dpFalse[i][j]+=dpTrue[i][k]*dpFalse[k+1][j];
                            dpFalse[i][j]+=dpFalse[i][k]*dpTrue[k+1][j];

                        }else if(op=='|'){
                            dpFalse[i][j]+=dpFalse[i][k]*dpFalse[k+1][j];

                            dpTrue[i][j]+=dpTrue[i][k]*dpFalse[k+1][j];
                            dpTrue[i][j]+=dpFalse[i][k]*dpTrue[k+1][j];
                            dpTrue[i][j]+=dpTrue[i][k]*dpTrue[k+1][j];
                            if(i==0 && j==2){
                                System.out.println(k+ " "+i+" -> "+dpTrue[i][k]*dpFalse[k+1][j]+" "+dpFalse[i][k]*dpTrue[k+1][j]+" "+dpTrue[i][k]*dpTrue[k+1][j]);
                            }
                        }else if(op=='^'){
                            dpFalse[i][j]+=dpTrue[i][k]*dpTrue[k+1][j];
                            dpFalse[i][j]+=dpFalse[i][k]*dpFalse[k+1][j];
                            
                            dpTrue[i][j]+= dpFalse[i][k]*dpTrue[k+1][j];
                            dpTrue[i][j]+= dpTrue[i][k]*dpFalse[k+1][j];

                        }   
                    }
                }
            }
        }
        for(int d[]: dpTrue){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
        System.out.println("---------");
        for(int d[]: dpFalse){
            for(int val: d){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s2 = "&|^";
        String s1 = "TFTF";
        boolean[] arr = new boolean[s1.length()];
        for(int i=0; i<s1.length(); i++){
            arr[i]=s1.charAt(i)=='T';
        }
        Character[] operator = new Character[s2.length()];
        for(int i=0; i<s2.length(); i++){
            operator[i] = s2.charAt(i);
        }

        solution(arr, operator);
    }
}
