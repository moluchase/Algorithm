public class NKmirror {
    public void Mirror(TreeNode root) {
        if (root !=  null && (root.left != null || root.right != null)) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }
}
