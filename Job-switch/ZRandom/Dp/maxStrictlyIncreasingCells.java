class Node {
    int val, max;
    HashSet<Node> neighbors;

    public Node(int val){
        this.val = val;
        this.max = 1;
        this.neighbors = new HashSet<>();
    }
}
class Solution {
    Node[][] nodeMat;

    public int maxIncreasingCells(int[][] mat) {
        nodeMat = new Node[mat.length][mat[0].length];

        // build graph
        for(int i=0; i<mat.length; i++){
            buildRow(mat[i], i);
        }
        for(int i=0; i<mat[0].length; i++){
            buildCol(mat, i);
        }

        int maxResult = 1;
        HashSet<Node> visited = new HashSet<>();
        for(Node[] row : nodeMat){
            for(Node n : row){
                maxResult = Math.max(processNode(n, visited), maxResult);
            }
        }
        
        return maxResult;
    }

    // get Max traversal from node n
    private int processNode(Node n, HashSet<Node> visited){
        if(n==null) return 0;
        if(visited.contains(n)) return n.max;
        for(Node neigh : n.neighbors){
            n.max = Math.max(n.max, processNode(neigh, visited)+1);
        }
        visited.add(n);
        return n.max;
    }

    // for each element in the row, add smallest element larger than current
    // Note: smallest element can be multiple duplicates - we would need to add all to the neighbors
    private void buildRow(int[] row, int r){
        TreeMap<Integer, Node> map = new TreeMap<>();
        HashMap<Integer, List<Node>> duplicates = new HashMap<>();
        for(int i=0; i<row.length; i++){
            Node n = new Node(row[i]);
            nodeMat[r][i] = n;
            if(map.containsKey(row[i])){
                List<Node> dupList = duplicates.getOrDefault(row[i], new ArrayList<>());
                dupList.add(n);
                duplicates.put(row[i], dupList);
            }
            else
                map.put(row[i], n);
        }
        for(Node curr : nodeMat[r]){
            addNeighbors(curr, map, duplicates);
        }
    }

    // similar to building row but for columns
    private void buildCol(int[][] mat, int col){
        TreeMap<Integer, Node> map = new TreeMap<>();
        HashMap<Integer, List<Node>> duplicates = new HashMap<>();
        for(int i=0; i<mat.length; i++){
            Node n = nodeMat[i][col];
            if(map.containsKey(mat[i][col])){
                List<Node> dupList = duplicates.getOrDefault(mat[i][col], new ArrayList<>());
                dupList.add(n);
                duplicates.put(mat[i][col], dupList);
            }
            else 
                map.put(mat[i][col], n);
        }
        for(int i=0; i<mat.length; i++){
            addNeighbors(nodeMat[i][col], map, duplicates);
        }   
    }

    // helper function to add neighbors for node n given the row/col's treemap and duplicates
    private void addNeighbors(Node n, TreeMap<Integer,Node> map,HashMap<Integer, List<Node>> duplicates) {
        int num = n.val;
        Integer higherNum  = map.ceilingKey(num+1);
        if(higherNum != null){
            n.neighbors.add(map.get(higherNum));
            if(duplicates.containsKey(higherNum)){
                for(Node neigh : duplicates.get(higherNum)){
                    if(n!=neigh)
                        n.neighbors.add(neigh);
                }
            }
        }
    }

}