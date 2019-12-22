package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion17 extends BaseActivity {
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion18_1.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        print1ToMaxOfNDigits(Integer.parseInt(parameter));
        return stringBuilder + "";
    }

    @Override
    protected String setDescription() {
        return "输入数字n,按顺序打印从1到最大的n位十进制数." +
                "比如输入2,则打印出1,2,3一直到最大的两位数99";
    }

    @Override
    protected String setDefaultTestCase() {
        return "2";
    }

    private void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            stringBuilder.append("请输入大于0的整数");
            return;
        }
        int number = 1;
        int i = 0;
        while (i++ < n){
            number*=10;
        }
        for(i = 1; i < number; ++i){
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
    }

}
