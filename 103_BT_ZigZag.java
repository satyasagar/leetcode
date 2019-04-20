/*103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
            return output;
        Queue<TreeNode> q = new LinkedList<>();
        boolean order = true;
        q.add(root);
        int size = 1;
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode n = q.poll();
                if(order){
                    temp.add(n.val);
                }
                else{
                    temp.add(0,n.val);
                }
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            output.add(temp);
            order = order ? false: true;
            size = q.size();
        }
    return output;
    }
}

