package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion5 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion6.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return parameter.replaceAll(" " , "%20");
    }

    @Override
    protected String setDescription() {
        return "把字符串中的每个空格替换成%20";
    }

    @Override
    protected String setDefaultTestCase() {
        return "We are happy.";
    }
}
