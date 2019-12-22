package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion42 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion43.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请正确输入参数";
        }
        List<Integer> paraList = getParaArrayList(parameter);
        return findGreatestSumOfSubArray(paraList) + "";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#-2#3#10#-4#7#2#-5";
    }

    @Override
    protected String setDescription() {
        return "输入一个整形数组,数组里有正数也有负数.数组中的一个或连续多个整数组成 一个子数组." +
                "求所有子数组的和的最大值.例如输入的数组为1#-2#3#10#-4#7#2#-5.将输出18";
    }

    private int findGreatestSumOfSubArray(List<Integer> paraList) {
        //试着从头到尾累加,如果此前累加的<0,就把之前的舍弃,然后重新开始累加
        int mCurrentSum = 0;
        int greatestSum = 0x80000000;//最小的数
        for (int i = 0; i < paraList.size(); i++) {
            if (mCurrentSum <= 0) {
                mCurrentSum = paraList.get(i);
            } else {
                mCurrentSum += paraList.get(i);
            }
            if (mCurrentSum > greatestSum) {
                greatestSum = mCurrentSum;
            }
        }
        return greatestSum;
    }
}
