package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;
import java.util.Stack;

public class InterviewQuestion30 extends BaseActivity {

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion31.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //我们把每次的最小元素都保存起来放到另外一个辅助栈里
        List<Integer> mParaList = getParaArrayList(parameter);
        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i : mParaList) {
            dataStack.push(i);
            if (minStack.size() == 0 || i < minStack.peek()) {
                minStack.push(i);
            } else {
                minStack.push(minStack.peek());
            }
        }
        return "最小值:" + minStack.peek() + "栈:" + dataStack.toString();
    }

    @Override
    protected String setDefaultTestCase() {
        return "3#4#2#1";
    }

    @Override
    protected String setDescription() {
        return "定义一个栈的数据结构,在该类型中实现一个能够得到栈中最小元素的min函数," +
                "在该栈中,调用min, push, pop的时间复杂度都是o(1)," +
                "栈内各元素之间请用#隔开, 点击计算将返回栈中的最小值, 以及栈的数据";
    }
}
