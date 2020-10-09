/*
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

 

Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //Converting the BST to Non-recursive preorder traversal and storing in the string
         if (root == null) {
        return null;
    }
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}

private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
        return;
    }
    sb.append(root.val).append(" ");
    serialize(root.left, sb);
    serialize(root.right, sb);
}


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //Converting preorder traversal to BST
      if (data == null || data.length() == 0) {
        return null;
    }
    String[] nodes = data.split(" ");
    int[] index = new int[] {0};
    return deserialize(nodes, index, Integer.MAX_VALUE);
}

private TreeNode deserialize(String[] nodes, int[] index, int max) {
    if (index[0] >= nodes.length || Integer.valueOf(nodes[index[0]]) >= max) {
        return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(nodes[index[0]++]));
    root.left = deserialize(nodes, index, root.val);
    root.right = deserialize(nodes, index, max);
    return root;
}
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
