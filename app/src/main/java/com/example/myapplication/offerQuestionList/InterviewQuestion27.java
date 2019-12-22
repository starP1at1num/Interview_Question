package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion27 extends BaseActivity {
    private StringBuilder printTree = new StringBuilder();

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion28.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请输入正确的参数";
        }
        BinaryTree treeA = new BinaryTree();
        treeA.parameter = parameter;
        treeA.CreateByExtended(treeA);
        treeA.fresh(treeA);
        mirrorRecursively(treeA);
        printTreeNode(treeA);
        return printTree + "";
    }

    @Override
    protected String setDescription() {
        return "请完成一个函数,输入一棵二叉树, 该函数输出它的镜像(左右子树互换)," +
                "请输入扩展二叉树,该函数将输出它的镜像的先序遍历";
    }

    @Override
    protected String setDefaultTestCase() {
        return "ABD##E##CF##G##";
    }

    private void mirrorRecursively(BinaryTree root){
        if(root != null){
            if(root.right == null && root.left == null){
                return;
            }
            //交换左右子树
            BinaryTree temp = root.left;
            root.left = root.right;
            root.right = temp;
            //进入右子树
            if(root.right != null){
                mirrorRecursively(root.right);
            }
            //进入左子树
            if(root.left != null){
                mirrorRecursively(root.left);
            }
        }
    }

    private void printTreeNode(BinaryTree root){
        if(root != null){
            printTree.append(root.data);
            if(root.left != null){
                printTreeNode(root.left);
            }
            if(root.right != null){
                printTreeNode(root.right);
            }
        }
    }
}
