package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion10_1 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion10_2.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return fibonacci(Integer.parseInt(parameter)) + "";
    }

    @Override
    protected String setDescription() {
        return "写一个函数,输入n,求斐波那契数列的第n项";
    }

    @Override
    protected String setDefaultTestCase() {
        return "20";
    }

    private long fibonacci(int n) {
        //递归解法
//        if(n <= 0){
//            return 0;
//        }
//
//        if (n == 1) {
//            return 1;
//        }
//        return fibonacci(n - 1) + fibonacci(n - 2);
        //循环解法
        int[] result = {0,1};
        if(n < 2){
            return result[n];
        }
        long fibMinusOne = 1;
        long fibMinusTwo = 0;
        long fibN = 0;
        for(int i = 2; i <= n; i++){
            fibN = fibMinusOne + fibMinusTwo;
            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibN;
        }
        return fibN;
    }
}
