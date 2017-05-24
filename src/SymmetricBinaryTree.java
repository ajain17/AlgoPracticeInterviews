/**
 * Created by ayushij on 12/29/16.
 */
public class SymmetricBinaryTree {
    public int isSymmetric(Node a) {
        if(a==null)
            return 1;
        return(isSymm(a.left, a.right));

    }

    int isSymm(Node left, Node right) {
        if(left == null && right == null)
            return 1;
        if((left == null && right!=null) || (left!=null & right == null))
            return 0;

        if(left.data != right.data)
            return 0;

        if(isSymm(left.left, right.right) != 1)
            return 0;
        if(isSymm(left.right, right.left) != 1)
            return 0;
        return 1;
    }
}

