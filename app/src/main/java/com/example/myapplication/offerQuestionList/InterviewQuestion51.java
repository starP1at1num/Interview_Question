package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion51 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion52.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //相当于统计归并排序移位的次数
        List<Integer> paraList = getParaArrayList(parameter);
        int[] data = new int[paraList.size()];
        for (int i = 0; i < paraList.size(); i++) {
            data[i] = paraList.get(i);
        }
        return inversePairs(data) + "";
    }

    @Override
    protected String setDescription() {
        return "在数组中的两个数字,如果前一个大于后面的,则这两个数组组成一个逆序对." +
                "输入一个数组,求出这个数组中逆序对的总数.数组各元素之间请按#隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "7#5#6#4";
    }

    private int inversePairs(int[] data) {
        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }
        int count = inversePairsCore(data, copy, 0, data.length - 1);
        return count;
    }

    private int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[end];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (; i >= start; --i) {
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = data[j];
        }
        return left + right + count;
    }
}
