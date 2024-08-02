// public class CountCompleteTreeNodes {

//     public int countNodes(TreeNode root) {

//     }

//     public int count(TreeNode node, int ht, int count) {

//         if (node.left == null && node.right == null)
//             return count;

//         if (node.right != null) {
//             return count(node.right, ht + 1, 2 * ht + 2);
//         } else {
//             return count(node.left, ht + 1, 2 * ht + 1);
//         }
//     }
// }
