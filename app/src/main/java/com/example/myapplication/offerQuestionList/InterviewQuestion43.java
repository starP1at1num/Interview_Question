package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion43 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion44.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        int key = Integer.parseInt(parameter);
        if (key <= 0) {
            return "请正确输入参数";
        }
        return numberOf1Between1AndN(parameter, 0) + "";
    }

    @Override
    protected String setDescription() {
        return "输入一个整数n,求1~n这n个整数的十进制表示中1出现的次数.例如输入12," +
                "这些整数中包含1的数字有1,10,11,12,一共5次,所以将返回5";
    }

    @Override
    protected String setDefaultTestCase() {
        return "12";
    }

    private int numberOf1Between1AndN(String key, int start) {
        //递归求解
        //例如21345可以分为1346-11345,11346-21345
        int first = key.charAt(start) - '0';
        int length = key.length() - start;
        if (length == 1 && first == 0) {
            return 0;
        }
        if (length == 1 && first > 1) {
            return 1;
        }
        int numFirstDigit = 0;//1246-21345中最高位1出现的次数
        if (first > 1) {
            //例如10000-19999共出现10的4次方次
            numFirstDigit = powerBase10(length - 1);
        }
        if (first == 1) {
            if (start + 1 == length - 1) {
                numFirstDigit = key.charAt(start + 1) - '0' + 1;
            }else {
                numFirstDigit = Integer.parseInt(key.substring(start + 1, length - 1)) + 1;
            }
        }
        //排列组合原则
        //1246-21345中剩余4位1出现的次数
        int numOfOtherDigits = first * (length - 1) * powerBase10(length - 2);
        //1-1345相当于去掉了最高位2之后剩下的,通过递归求得
        int numReceive = numberOf1Between1AndN(key, start + 1);
        return numFirstDigit + numOfOtherDigits + numReceive;
    }

    private int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}
