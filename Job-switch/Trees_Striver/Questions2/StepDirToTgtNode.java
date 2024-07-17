package Questions2;

public class StepDirToTgtNode {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    

    public String getDirections(TreeNode root, int startValue, int destValue) {
        ans = "";
        rootToNode(root, startValue);
        String startPath = ans;
        ans = "";
        rootToNode(root, destValue);
        String destPath = ans;
        int idx = 0;
        while (idx < Math.min(startPath.length(), destPath.length()) && startPath.charAt(idx) == destPath.charAt(idx)) {
            idx++;
        }
        if (idx == Math.min(startPath.length(), destPath.length())) {
            return "";
        }
        startPath = startPath.substring(idx);
        String revPath = "";
        for (int i = 0; i < startPath.length(); i++) {
            revPath += "U";
        }
        destPath = destPath.substring(idx);
        return revPath + destPath;
    }

    String ans = "";

    public boolean rootToNode(TreeNode node, int dest) {
        if (node == null)
            return false;

        if (node.val == dest) {
            return true;
        }

        if (rootToNode(node.left, dest)) {
            ans = "L" + ans;
        } else if (rootToNode(node.right, dest)) {
            ans = "R" + ans;
        } else {
            return false;
        }
        return true;
    }

}
