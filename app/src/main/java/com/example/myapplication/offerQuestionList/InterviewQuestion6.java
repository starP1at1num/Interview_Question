package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;
import java.util.Stack;

public class InterviewQuestion6 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion7.class);
    }

    @Override
    protected String setDefaultTestCase() {
        return "7#8#6#4#2#5";
    }

    @Override
    protected String setDescription() {
        return "输入一个链表,从尾到头反过来打印出每个节点的值";
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if(!parameter.contains("#")){
            return "请按照#分隔输入的值";
        }
        List<Integer> mLinkedList = getParaLinkedList(parameter);
        Stack<Integer> mStack = new Stack<>();
        for(int i: mLinkedList){
            mStack.push(i);
        }
        StringBuilder mStringBuilder = new StringBuilder();
        while (!mStack.empty()){
            mStringBuilder.append(mStack.pop());
        }
        return mStringBuilder + "";
    }
}
