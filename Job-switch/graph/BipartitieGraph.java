import java.util.ArrayDeque;

public class BipartitieGraph {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visisted = new int[n];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        

        for(int i=0; i<visisted.length; i++){
            if(visisted[i] == 0){
                queue.add(new int[] { i, 1 });
                while (queue.size() > 0) {
                    int[] peek = queue.remove();
                    int src = peek[0];
                    int color = peek[1];
        
                    visisted[src] = color;
        
                    int toggledColor = color == 1 ? 2 : 1;
                    for (int nbr : graph[src]) {
                        if (visisted[nbr] == 0) {
                            queue.add(new int[] { nbr, toggledColor });
                        } else {
                            if (visisted[nbr] != toggledColor)
                                return false;
                        }
                    }
                }

            }
        }

        return true;
    }
}
