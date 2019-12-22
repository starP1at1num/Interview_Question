package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion28 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion29.class);
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
        if(isSymmetrical(treeA)){
            return "该树是对称的";
        }else {
            return  "该树不是对称的";
        }

    }

    @Override
    protected String setDefaultTestCase() {
        return "ABC##D##BD##C##";
    }

    @Override
    protected String setDescription() {
        return "请实现一个函数,用于判断一棵二叉树是不是对称的." +
                "如果一棵二叉树和它的镜像一样,那么它是对称的.(请输入扩展二叉树)";
    }

    private boolean isSymmetrical(BinaryTree root){
        //我们同时做先序遍历和对称先序遍历,然后比较得到的节点的值, 主要子节点为空的情况
        return isSymmetrical(root, root);
    }

    private boolean isSymmetrical(BinaryTree root1, BinaryTree root2){
        //值都为空表示遍历完毕
        if(root1 == null && root2 == null){
            return true;
        }
        //一个为空一个不为空肯定不对称
        if(root1 == null || root2 == null){
            return false;
        }
        //值不相等不对称
        if(!((String)root1.data).equals((String)root2.data)){
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left) ;
    }
}
