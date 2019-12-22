package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion7 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion8.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains(",")) {
            return "请正确输入参数";
        }
        String[] paraList = parameter.split(",");
        String[] preOrder = paraList[0].split("#");
        String[] inOrder = paraList[1].split("#");
        if (preOrder.length != inOrder.length) {
            return "前序遍历和中序遍历的长度不一致";
        }
        BinaryTree resultTree = construct(preOrder, inOrder, 0,
                preOrder.length - 1, 0, inOrder.length - 1);
        if (resultTree == null) {
            return "解析失败,请确认输入是否正确";
        }else {
            StringBuilder mResult = new StringBuilder();
            printBinaryTree(resultTree, mResult);
            return "头结点是:" + preOrder[0] + "  后序遍历序列是:" + mResult + "";
        }
    }

    @Override
    protected String setDescription() {
        return "输入某二叉树的前序遍历和中序遍历的结果,请重建该二叉树," +
                "例如输入1#2#4#7#3#5#6#8,4#7#2#1#5#3#8#6则重建二叉树并输出它的头结点和后序遍历.";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#4#7#3#5#6#8,4#7#2#1#5#3#8#6";
    }

    private BinaryTree construct(String[] preOrder, String[] inOrder, int startPreOrder,
                                 int endPreOrder, int startInOrder, int endInOrder) {
        //做法是通过递归把大的遍历序列变成很多小的遍历序列
        //然后前序遍历序列的第一个数字是根节点的值
        // 而对应中序遍历序列的值的左边是左子树,右边是右子树
        String root = preOrder[startPreOrder];
        BinaryTree treeRoot = new BinaryTree(root);
        if (preOrder[startPreOrder] == preOrder[endPreOrder]) {
            if (inOrder[startInOrder] == inOrder[endInOrder]) {
                return treeRoot;
            } else {
                return null;
            }
        }
        //在中序遍历中找到根节点的值
        int inOrderRootLocation = startInOrder;
        while (inOrderRootLocation <= endInOrder && !root.equals(inOrder[inOrderRootLocation])) {
            inOrderRootLocation++;
        }
        //中序遍历中没有根节点,用户输入了错误的参数
        if (inOrderRootLocation == endInOrder && !root.equals(inOrder[inOrderRootLocation])) {
            return null;
        }
        //左子树节点个数
        int leftLength = inOrderRootLocation - startInOrder;
        //先序遍历中左子树的最后一个节点的位置
        int leftPreOrderEnd = startPreOrder + leftLength;
        if (leftLength > 0) {
            //构建左子树
            treeRoot.left = construct(preOrder, inOrder, startPreOrder + 1,
                    leftPreOrderEnd, startInOrder, inOrderRootLocation - 1);
        }
        if (leftLength < endPreOrder - startPreOrder) {
            //构建右子树
            treeRoot.right = construct(preOrder, inOrder, leftPreOrderEnd + 1,
                    endPreOrder, inOrderRootLocation + 1, endInOrder);
        }
        return treeRoot;
    }

    private void printBinaryTree(BinaryTree root, StringBuilder mResult){
        if(root!=null){
            printBinaryTree(root.left, mResult);
            printBinaryTree(root.right, mResult);
            mResult.append(root.data);
        }
    }
}
