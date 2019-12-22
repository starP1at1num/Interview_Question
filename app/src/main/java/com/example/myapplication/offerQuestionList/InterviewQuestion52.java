package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion52 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion54.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return super.calculateAnswer(parameter);
    }

    @Override
    protected String setDefaultTestCase() {
        return "先计算两个链表的长度,然后长的先走,使剩余需要遍历长度一样,然后同时前进," +
                "一旦找到值相同的节点就是公共节点";
    }

    @Override
    protected String setDescription() {
        return "输入两个链表,找出它们的第一个公共节点";
    }
}
