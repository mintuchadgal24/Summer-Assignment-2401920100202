public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();

        for (String s : arr) {
            q.offer(s);
        }

        return build(q);
    }

    private TreeNode build(Queue<String> q) {
        String val = q.poll();

        if (val.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = build(q);
        root.right = build(q);

        return root;
    }
}
