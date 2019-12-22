package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestion8 extends BaseActivity {
    private BinaryTreeHasParentPoint keyNode = null;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion9.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains("_")) {
            return "请正确输入参数";
        }
        String key = (parameter.split("_"))[1];
        String extendedBinaryList = (parameter.split("_"))[0];
        BinaryTreeHasParentPoint mBinaryTree = new BinaryTreeHasParentPoint();
        mBinaryTree.parameter = extendedBinaryList;
        mBinaryTree.CreateByExtendedWithParent(mBinaryTree);
        fresh(mBinaryTree);
        //从右子节点出发,一直沿着指向左节点的指针,就能找到下一个节点
        //当没有右子树时,下一个节点时它的父节点
        //没有右子树,它还是父节点的右子树时,
        //需要一直向上遍历,直到找到一个时它父节点的左子节点的节点
        findKey(mBinaryTree, key);
        if (keyNode != null) {
            return getNext(keyNode);
        } else {
            return "树中没有此键";
        }

    }

    @Override
    protected String setDescription() {
        return "给定一棵二叉树和其中的一个节点, " +
                "找出中序遍历的下一个节点, 树中的节点除了有两个分别指向左右子节点的指针," +
                "还有一个指向父节点的指针," + "注意二叉树是通过拓展二叉树的方式构建" +
                "其中节点则需要通过_隔开并放在参数的末尾";
    }

    @Override
    protected String setDefaultTestCase() {
        return "ABD##EH##I##CF##G##_I";
    }

    private class BinaryTreeHasParentPoint extends BinaryTree {
        private BinaryTreeHasParentPoint parent;

        private BinaryTreeHasParentPoint left;

        private BinaryTreeHasParentPoint right;

        public BinaryTreeHasParentPoint() {
            this.parent = null;
        }

        public void CreateByExtendedWithParent(BinaryTreeHasParentPoint root) {
            //以扩展二叉树方式创建二叉树
            char ch = parameter.charAt(i);
            i++;
            if (ch == '#') {
                root.data = null;
            } else {
                root.data = String.valueOf(ch);
                root.left = new BinaryTreeHasParentPoint();
                root.left.parent = root;
                root.right = new BinaryTreeHasParentPoint();
                root.right.parent = root;
                CreateByExtendedWithParent(root.left);
                CreateByExtendedWithParent(root.right);
            }
        }
    }

    private String getNext(BinaryTreeHasParentPoint mBinaryTree) {
        BinaryTreeHasParentPoint nextNode = new BinaryTreeHasParentPoint();
        if (mBinaryTree.right != null) {
            BinaryTreeHasParentPoint rightNode = mBinaryTree.right;
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            nextNode = rightNode;
        } else if (mBinaryTree.parent != null) {
            BinaryTreeHasParentPoint currentNode = mBinaryTree;
            BinaryTreeHasParentPoint parentNode = mBinaryTree.parent;
            while (parentNode != null && currentNode == parentNode.right) {
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            nextNode = parentNode;
        }
        return (String) nextNode.data;
    }

    public void fresh(BinaryTreeHasParentPoint root) {
        if (root != null) {
            if (root.left.data == null) {
                root.left = null;
            }
            if (root.right.data == null) {
                root.right = null;
            }
            fresh(root.left);
            fresh(root.right);
        }
    }

    private void findKey(BinaryTreeHasParentPoint root, String key) {
        if (root != null) {
            if (!key.equals((String) root.data)) {
                findKey(root.left, key);
                findKey(root.right, key);
            } else {
                keyNode = root;
            }
        }
    }
}
