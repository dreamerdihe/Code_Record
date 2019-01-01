public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        return String.valueOf(root.val) + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        
        String[] nodesString = data.split(",");
        int[] nodes = new int[nodesString.length];
        for(int i = 0; i < nodesString.length; i ++) {
            nodes[i] = Integer.parseInt(nodesString[i]);
        }
        
        return helper(nodes, 0, nodes.length);
    }
    
    private TreeNode helper(int[] nodes, int start, int end) {
        if(start >= end) {
            return null;
        }
        
        TreeNode root = new TreeNode(nodes[start]);
        int index = start + 1;
        while(index < end) {
            if(nodes[index] > nodes[start]) {
                break;
            }
            index ++;
        }
        
        root.left = helper(nodes, start + 1, index);
        root.right = helper(nodes, index, end);
        
        return root;
    }
  
}
