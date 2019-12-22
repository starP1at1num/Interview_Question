package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion50 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion51.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return super.calculateAnswer(parameter);
    }

    @Override
    protected String setDefaultTestCase() {
        return "用哈希表可以实现";
    }

    @Override
    protected String setDescription() {
        return "请实现一个函数,用来找出字符流中第一个只出现一次的字符";
    }
}
