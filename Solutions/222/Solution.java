
class Solution {
    public int countNodes(TreeNode root) {
        int leftHeight = getLeft(root);
        int rightHeight = getRight(root);
        if(leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getLeft(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.left;
            height ++;
        }
        
        return height;
    }
    
    private int getRight(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.right;
            height ++;
        }
        
        return height;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int height = getHeight(root);
        if(height == 1) {
            return 1;
        }
        
        int result = (1 << (height - 1)) - 1;
        return result + getLastLevel(root, height);
    }
    
    private int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height ++;
        }
        
        return height;
    }
    
    private int getLastLevel(TreeNode root, int height) {
        if(height == 2) {
            if(root.left == null) {
                return 0;
            }
            if(root.right == null) {
                return 1;    
            } 
            
            return 2;
        }
        
        if(getMid(root, height) == null) {
            return getLastLevel(root.left, height - 1);
        } 
        
        return (1 << (height - 2)) + getLastLevel(root.right, height - 1);
    }
    
    private TreeNode getMid(TreeNode root, int height) {
        TreeNode mid = root.left;
        for(int i = 1; i < height - 1; i ++) {
            mid = mid.right;
        }
        return mid;
    }
}