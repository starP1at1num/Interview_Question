package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion49 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion50.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        int key = Integer.parseInt(parameter);
        return getUglyNumber(key) + "";
    }

    @Override
    protected String setDescription() {
        return "我们把只包含因子2,3,5的数称作丑数.请输入一个数字,求按从小到大顺序的那个丑数";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1500";
    }

    //这样的做法看似有点麻烦,其实是保持了良好的扩展性,如果丑数的因子不再是235,换成别的
    //这个算法在修改之后也能直接使用
    private int getUglyNumber(int index) {
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int[] multiply2 = uglyNumbers;
        int[] multiply3 = uglyNumbers;
        int[] multiply5 = uglyNumbers;
        int indexOf2 = 0;
        int indexOf3 = 0;
        int indexOf5 = 0;
        while (nextUglyIndex < index) {
            int min = min(multiply2[indexOf2] * 2, multiply3[indexOf3] * 3, multiply5[indexOf5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (multiply2[indexOf2] * 2 <= uglyNumbers[nextUglyIndex]) {
                indexOf2++;
            }
            while (multiply3[indexOf3] * 3 <= uglyNumbers[nextUglyIndex]) {
                indexOf3++;
            }
            while (multiply5[indexOf5] * 5 <= uglyNumbers[nextUglyIndex]) {
                indexOf5++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }

    //求3数最小值
    private int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        return (min < number3) ? min : number3;
    }
}
