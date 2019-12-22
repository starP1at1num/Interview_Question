package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.Comparator;
import java.util.List;

public class InterviewQuestion45 extends BaseActivity {
    private StringBuilder result = null;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion46.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请正确输入参数";
        }
        List<String> paraList = getParaLinkedListForString(parameter);
        result = new StringBuilder();
        printMinNumber(paraList);
        return result + "";
    }

    @Override
    protected String setDescription() {
        return "输入一个正整数数组,把数组里所有的数字拼接起来排成一个整数,打印能拼接出的所有数字中最小的一个." +
                "例如输入输入数组3#32#321,则打印出这三个数字能排成的最小数字321323,数组各数字直接请以#隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "3#32#321";
    }

    private void printMinNumber(List<String> paraList) {
        //例如compareTo方法比较字符串数字的大小,最小的放前面,最大的放后面,然后拼接就是结果
        paraList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String strCombine1 = o1;
                strCombine1 += o2;
                String strCombine2 = o2;
                strCombine1 += o1;
                return 1 - strCombine1.compareTo(strCombine2);
            }
        });
        for (String i : paraList) {
            result.append(i);
        }
    }
}
