package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion19 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion20.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请正确输入参数";
        }
        String paraString = parameter.split("#")[0];
        String expression = parameter.split("#")[1];
        if (match(paraString, expression, 0, 0)) {
            return "能成功匹配";
        } else {
            return "无法匹配";
        }
    }

    @Override
    protected String setDefaultTestCase() {
        return "aaa#ab*ac*a";
    }

    @Override
    protected String setDescription() {
        return "请实现一个函数用来匹配包含'.'和'*'的正则表达式." +
                "'.'表示匹配任意一个字符, '*'表示它前面的字符可以出现任意次(含0次)" +
                "本题的匹配是指字符串的所有字符匹配整个模式.例如字符串aaa与" +
                "模式a.a和ab*ac*a匹配,单与aa.a和ab*a均不匹配.字符串和表达式之间请用#隔开";
    }

    private boolean match(String parameter, String expression, int para, int exp) {
        //从第一个字符开始,如果都是字符且都能匹配,就可以匹配下一个
        //如果表达式是.,也可以匹配下一个
        //第二个及以后就要考虑*的情况了,有两种选择,一种是表达式向后移动两个,也可以保持不变
        //字符串继续向后走直到结束
        if ((parameter.length() - 1) < para && (expression.length() - 1) < exp) {
            return true;
        }
        if ((parameter.length() - 1) >= para && (expression.length() - 1) < exp) {
            return false;
        }
        //我吐了,书上的代码有问题,要先判断当前字符串是否与表达式的字符串或者.匹配,
        //否则会造成indexOutOfRangeException
        if (parameter.charAt(para) == expression.charAt(exp) ||
                (expression.charAt(exp) == '.' && (parameter.length() - 1) >= para)) {
            return match(parameter, expression, para + 1, exp + 1);
        }
        if (expression.charAt(exp + 1) == '*') {
            if (parameter.charAt(para) == expression.charAt(exp) ||
                    (expression.charAt(exp) == '.' && (parameter.length() - 1) >= para)) {
                //都向前走
                return match(parameter, expression, para + 1, exp + 2)
                        //表达式不走,字符串向前
                        || match(parameter, expression, para + 1, exp)
                        //*0次的情况
                        || match(parameter, expression, para, exp + 2);
            } else {
                //*0次的情况
                return match(parameter, expression, para, exp + 2);
            }
        }
        return false;
    }
}
