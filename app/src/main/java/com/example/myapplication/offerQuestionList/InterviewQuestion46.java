package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion46 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion47.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //我们可以自上而下解决问题,也可以自下而上解决问题,自下而上可以消除重复的子问题.
        //也就是说,我们从数字的末尾开始,然后从右到左翻译并计算不同翻译的数目
        return getTranslationCount(parameter) + "";
    }

    @Override
    protected String setDefaultTestCase() {
        return "12258";
    }

    @Override
    protected String setDescription() {
        return "给定一个数字,我们按照如下规则八它翻译为字符串:0翻译成a,1翻译成b," +
                "...11翻译成l, 25翻译成z,一个数字可能有多个翻译.请编程实现一个函数," +
                "用来计算一个数字有多少种翻译方法.例如12258有5种不同的翻译";
    }

    private int getTranslationCount(String parameter) {
        int length = parameter.length();
        int[] counts = new int[length];
        int count;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                //等于上一位的count
                count = counts[i + 1];
            } else {
                count = 1;
            }
            //不是最后一个数字的情况
            if (i < length - 1) {
                int digit1 = parameter.charAt(i) - '0';
                int digit2 = parameter.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count++;
                    }
                }
            }
            //最后一个数字的情况
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
}
