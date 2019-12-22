package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;
import java.util.Stack;

public class InterviewQuestion31 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion32_1.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //压入顺序
        List<Integer> dataList = getParaArrayList(parameter.split(",")[0]);
        //可能的压栈序列
        List<Integer> judgeList = getParaArrayList(parameter.split(",")[1]);
        if (isPopOrder(dataList, judgeList)) {
            return "是该栈对应的一个弹出序列";
        } else {
            return "不是该栈对应的一个弹出序列";
        }
    }

    @Override
    protected String setDescription() {
        return "输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否是栈的弹出序列." +
                "假设压入栈的所有数字均不相等.例如序列1#2#3#4#5是某栈的压栈序列," +
                "序列4#5#3#2#1是该栈压栈序列对应的一个弹出序列,但4#3#5#1#2就不可能四该压栈序列的弹出序列." +
                "两个栈之前请用,隔开,栈之间请用#隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#4#5,4#5#3#2#1";
    }

    private boolean isPopOrder(List<Integer> dataList, List<Integer> judgeList) {
        //如果下一个弹出的数字刚好是栈顶数字,那么直接弹出,如果不是,则把压栈序列中还没有入栈的
        //数字压入辅助栈,直到把下一个需要弹出的数字压入栈为止,如果所有数字都压入栈后仍然没有找到
        //下一个弹出的数字,那么该序列不可能四一个弹出序列,可以理解为倒着来一遍
        boolean possible = false;
        int nextData = 0;
        int nextJudge = 0;
        Stack<Integer> stack = new Stack<>();
        while (nextData - nextJudge < dataList.size()) {
            while (stack.empty() || stack.peek() != judgeList.get(nextJudge)) {
                if (nextData == dataList.size()) {
                    break;
                }
                stack.push(dataList.get(nextData));
                nextData++;
            }
            if (nextJudge == dataList.size() || stack.peek() != judgeList.get(nextJudge)) {
                break;
            }
            stack.pop();
            nextJudge++;
        }
        if (stack.empty() && nextJudge == dataList.size()) {
            possible = true;
        }
        return possible;
    }
}
