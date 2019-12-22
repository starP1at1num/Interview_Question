package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion37 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion38.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "序列化就是先序遍历,碰到空的打印#,否则打印值,反序列化就是顺序读取序列化的值," +
                "碰到空就把这个节点置空,否则就左右递归";
    }

    @Override
    protected String setDefaultTestCase() {
        return "用扩展二叉树来进行序列化和反序列化即可";
    }

    @Override
    protected String setDescription() {
        return "请实现两个函数,分别用来序列化和反序列化二叉树";
    }
}
