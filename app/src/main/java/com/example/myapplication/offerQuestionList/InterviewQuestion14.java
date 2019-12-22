package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion14 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion15.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //f(n) = max(f(i) * f(n - i))  其中(0 < i < n)
        //这是一个从上至下的递归公式,一个最好的方法四按照从下到上的顺序计算
        //也就是说我们先得到f(2),f(3), 再得到f(4), f(5),直到得到f(n)
        //易知f(2) = 1, f(3) = 2
        return "动态规划法:" + maxProductAfterCutting_solution1(Integer.parseInt(parameter)) + "贪婪算法:"
                + maxProductAfterCutting_solution2(Integer.parseInt(parameter));
    }

    @Override
    protected String setDefaultTestCase() {
        return "8";
    }

    @Override
    protected String setDescription() {
        return "给你一根长度为n的绳子,请把绳子剪成m段(m,n都是大于1的整数)" +
                "每段绳子的长度记为k[0], k[1], k[2]......k[m]." +
                "请问k[0] x k[1] x k[2] ...... x K[m]可能的最大乘积是多少" +
                "例如长度为8的绳子,我们把它剪成长度分别是2,3,3的三段,此时得到的最大乘积是18." +
                "(请输入长度)";
    }

    //动态规划法
    private int maxProductAfterCutting_solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        //这个3就很耐人寻味
        products[3] = 3;
        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        products = null;
        return max;
    }

    //贪婪算法
    //n>=5时,尽可能多剪长度为3的绳子,剩下的绳子长度为4时,剪成两段长度为2的绳子
    private int maxProductAfterCutting_solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}
