package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-17.
 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null&&q!=null){
            if (p.val!=q.val){
                return false;
            }else {
                boolean leftflag = isSameTree(p.left,q.left);
                boolean rightflag = isSameTree(p.right,q.right);
                if (leftflag&&rightflag)
                    return true;
                else
                    return false;
            }
        }else if (p==null&&q==null)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}
