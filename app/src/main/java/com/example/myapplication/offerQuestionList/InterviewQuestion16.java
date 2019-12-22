package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion16 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion17.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return power(Double.parseDouble(parameter.split("#")[0]), Integer.parseInt(parameter.split("#")[1])) + "";
    }

    @Override
    protected String setDefaultTestCase() {
        return "2#3";
    }

    @Override
    protected String setDescription() {
        return "实现函数double power(double base , int exponent), " +
                "求base的exponent次方,不得使用库函数, 同时不需要考虑大数问题.(输入:base#exponent)";
    }

    private double power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            return 0;
        }
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }
        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent <= 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithUnsignedExponent(double base, int absExponent) {
        double result = 1.0;
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }
        return result;
    }
}
