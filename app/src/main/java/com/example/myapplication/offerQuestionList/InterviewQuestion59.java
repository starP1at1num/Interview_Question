package com.example.myapplication.offerQuestionList;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.BaseActivity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class InterviewQuestion59 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        next.setVisibility(View.GONE);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("_") || !parameter.contains("#")) {
            return "请输入正确的参数";
        }
        String paraList = parameter.split("_")[0];
        List<Integer> dataList = getParaArrayList(paraList);
        int size = Integer.parseInt(parameter.split("_")[1]);
        maxInWindows(dataList,size);
        return maxInWindows(dataList,size).toString();
    }

    @Override
    protected String setDescription() {
        return "给定一个数组和滑道窗口的大小,请找出所有滑动窗口里的最大值";
    }

    @Override
    protected String setDefaultTestCase() {
        return "2#3#4#2#6#2#5#1_3";
    }

    private Deque<Integer> maxInWindows(List<Integer> dataList, int size) {
        Deque<Integer> index = new ArrayDeque<>();
        Deque<Integer> maxInWindows = new ArrayDeque<>();
        //先遍历窗口大小的数据,把队列中比当前小的剔除,从后往前遍历
        //第一个窗口的情况
        for (int i = 0; i < size; i++) {
            while (!index.isEmpty() && dataList.get(i) >= dataList.get(index.getLast())) {
                index.pollLast();
            }
            index.addLast(i);
        }
        for (int i = size; i < dataList.size(); i++) {
            //index.getFirst()就是当前窗口的最大值
            maxInWindows.addLast(dataList.get(index.getFirst()));
            //新进来的和当前的作比较,小的移除
            while (!index.isEmpty() && dataList.get(i) >= dataList.get(index.getLast())) {
                index.pollLast();
            }
            //把非窗口内的数字剔除
            if (!index.isEmpty() && index.peekFirst() <= i - size) {
                index.pollFirst();
            }
            index.addLast(i);
        }
        maxInWindows.addLast(dataList.get(index.peekFirst()));
        return maxInWindows;
    }
}
