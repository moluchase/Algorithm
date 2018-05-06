import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author pengsong
 * @date 18/1/8 上午9:19
 */
/*
序列化与反序列化
这个我在牛客网上之前做过，但是放到leetcode上超时了，这里使用先序遍历做的
 */
public class LC297SerializeandDeserializeBinaryTree {
    private static final String spliter=",";
    private static final String NN="X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
