package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion20 extends BaseActivity {
    private int index;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion21.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        index = 0;
        if(isNumeric(parameter)){
            return "字符串表示数值";
        }else {
            return "字符串不表示数值";
        }
    }

    @Override
    protected String setDescription() {
        return "请实现一个字符串是否表示数值,例如:+100, 5e2, -123, 3,1416, -1E-16都表示数值" +
                "但12e, 1a3.14, 1.2.3, +-5, 12e+5.4都不是";
    }

    @Override
    protected String setDefaultTestCase() {
        return "-1E-16";
    }

    private boolean isNumeric(String parameter) {
        boolean numeric = scanInteger(parameter);
        //判断小数部分
        if (parameter.charAt(index) == '.') {
            index++;
            numeric = scanUnsignedInteger(parameter) || numeric;
        }
        //判断指数部分
        if (parameter.charAt(index) == 'e' || parameter.charAt(index) == 'E') {
            index++;
            numeric = scanInteger(parameter) || numeric;
        }

        return numeric && (index > parameter.length() - 1);
    }

    //判断带符号整数
    private boolean scanInteger(String parameter) {
        if (parameter.charAt(index) == '+' || parameter.charAt(index) == '-') {
            index++;
        }
        return scanUnsignedInteger(parameter);
    }

    //判断无符号整数
    private boolean scanUnsignedInteger(String parameter) {
        int before = index;
        if (parameter.length() - 1 >= index && parameter.charAt(index) >= '0'
                && parameter.charAt(index) <= '9') {
            index++;
        }
        return index > before;
    }
}
