package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion15 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion16.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "解法1:" + numberOf1function1(Integer.parseInt(parameter))
                + "解法2:" + numberOf1function2(Integer.parseInt(parameter));
    }

    @Override
    protected String setDescription() {
        return "请实现一个函数,输入一个整数,输出该数二进制表示中1的个数," +
                "例如把9表示成二进制是1001, 则该函数输出2";
    }

    @Override
    protected String setDefaultTestCase() {
        return "9";
    }

    private int numberOf1function1(int n) {
        //解法1:把n和1做与运算,如果是1就count+1
        //接着把1左移一位得到2,再和n做与运算,就可以判断次低位
        //这样反复左移就可以得到1的个数
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    private int numberOf1function2(int n) {
        //解法2:把n减1,再和原整数做与运算,就会把该整数最右边的1变成0,那么n有多少1就可以进行多少次这样的操作
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
