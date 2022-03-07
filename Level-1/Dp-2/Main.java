import java.util.Scanner;

public class Main {

    
    static void knapF(int val[], int wt[], double w){
        double frc[] = new double[wt.length];
        for(int i=0;i<val.length;i++){
            double diviser = wt[i];
            double n = val[i]/diviser;
            double roundOff = Math.round(n* 100.0) / 100.0;
            // System.out.print(roundOff+" ");
            
            frc[i]= roundOff;
        }
        double value=0;

        for(int i=0;i<val.length;i++){
            int index = getMax(frc);

            if(w>= wt[index]){
                // System.out.println("weight "+w+" reduced wt "+wt[index]+" value "+val[index]);
                value+= val[index];
                w-=wt[index];
            }else{
                double frctionValue= ((double)val[index]/(double)wt[index])*(double)w;
                double roundOff = Math.round(frctionValue* 100.0) / 100.0;
                value+=frctionValue;
                break;

            }
        }
        System.out.println(value);
    }

    static int getMax(double frc[]){
        int index=0;
        for(int i=1; i<frc.length;i++){
            if(frc[index]<frc[i])
                index=i;
        }
        frc[index]=0;
        return index;
    }
    
    
    public static void main(String[] args) {
        // int val[]= {33,14,50,9 ,8 ,11,6 ,40 ,2 ,15};
        // int wt[] = {7 ,2 ,5 ,9 ,3 ,2 ,1 ,10 ,3 ,3};
        // int w=10;
        // // 5 50
        // // 2 50+14+21
        // // 3 
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int val[]= new int[n];
        int wt[]= new int[n];
        for(int i=0;i<n;i++)
            val[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            wt[i]=sc.nextInt();
        int w= sc.nextInt();
        knapF(val, wt, w);

        

    }
} 