package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion55 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion58.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return super.calculateAnswer(parameter);
    }

    @Override
    protected String setDefaultTestCase() {
        return "可以从另外一个角度理解二叉树的深度就是左右子树深度的较大者+1,然后可以用递归实现";
    }

    @Override
    protected String setDescription() {
        return "输入一棵二叉树的根节点,求二叉树的深度";
    }
}
