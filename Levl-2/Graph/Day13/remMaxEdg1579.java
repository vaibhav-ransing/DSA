import java.util.Arrays;

public class remMaxEdg1579 {
    // edges[i] = [typei, ui, vi]
    // static class edges{
    //     int i;
    //     int ui;
    //     int vi;
    // }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Arrays.sort(edges, new java.util.Comparator<int[]>() {
            public int compare(double[] a, double[] b) {
                return Double.compare(a[0], b[0]);
            }
        });
    }


    public static void main(String[] args) {
        
    }
}
