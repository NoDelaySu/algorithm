package tencent;

/**
 * @ClassName: tencent.Tencent1
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/10 21:32
 * @Version: 1.0
 */
public class Tencent1 {
    public static int countPaths(TreeNode root) {
        return countPathsHelper(root, 0, 0);
    }

    private static int countPathsHelper(TreeNode node, int count0, int count1) {
        if (node == null) {
            return 0;
        }

        // 更新当前节点的权值计数
        if (node.val == 0) {
            count0++;
        } else {
            count1++;
        }

        // 如果是叶子节点，检查条件是否满足
        if (node.left == null && node.right == null) {
            if (count1 == count0 + 1) {
                return 1;
            } else {
                return 0;
            }
        }

        // 递归计算左子树和右子树的路径数量
        int leftPaths = countPathsHelper(node.left, count0, count1);
        int rightPaths = countPathsHelper(node.right, count0, count1);

        return leftPaths + rightPaths;
    }

    public static void main(String[] args) {
        // 创建二叉树示例
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);

        int count = countPaths(root);
        System.out.println("节点权值1的个数比权值0的个数多1的路径数量为: " + count);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


