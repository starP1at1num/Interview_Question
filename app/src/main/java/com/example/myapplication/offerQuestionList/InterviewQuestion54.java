package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion54 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion55.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return super.calculateAnswer(parameter);
    }

    @Override
    protected String setDescription() {
        return "如果中序遍历二叉搜索树,那么得到的结果就是递增排序的";
    }

    @Override
    protected String setDefaultTestCase() {
        return "给定一棵二叉搜索树,请找出其中第k大的节点";
    }
}
