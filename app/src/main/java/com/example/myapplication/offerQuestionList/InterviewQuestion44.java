package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion44 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion45.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        int key = Integer.parseInt(parameter);
        if (key <= 0) {
            return "请正确输入参数";
        }
        return digitAtIndex(key) + "";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1001";
    }

    @Override
    protected String setDescription() {
        return "数字以0123456789101112131415...的格式序列化到一个字符序列中." +
                "在这个序列中,第5位(从0开始计数)是5,第13位是1,第19位是4," +
                "请写一个函数,求任意第n位对应的数字";
    }

    private int digitAtIndex(int index) {
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            //判断区间:一位数,两位数,三位数...
            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }
            index -= digits * numbers;
            digits++;
        }
    }

    //得到m位的数字总共有多少个,例如输入2,得到90(10-99);输入3,得到900(100-999)
    private int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    //index是这个区间的第几个数字,digits是位数
    private int digitAtIndex(int index, int digits) {
        //确定包含这位字符的数字是多少
        int number = beginNumber(digits) + index / digits;
        //是digits位数从右往左数的第几个
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            //每次从后面去一位
            number /= 10;
        }
        return number % 10;
    }

    //得到digits位数的第一个数字是多少,例如第一个三位数是100
    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits - 1);
    }
}
