package com.example.myapplication.offerQuestionList;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InterviewQuestion9 extends BaseActivity {

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion10_1.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "队列元素请用#隔开";
        }
        List<Integer> paraArrayList;
        if (!parameter.contains("_")) {
            paraArrayList = getParaArrayList(parameter);
            MyQueue myQueue = new MyQueue(paraArrayList);
            myQueue.deleteHead();
            return myQueue.toString();
        } else {
            String[] paraList = parameter.split("_")[0].split("#");
            int key = Integer.parseInt(parameter.split("_")[1]);
            paraArrayList = new ArrayList<>();
            for (String i : paraList) {
                paraArrayList.add(Integer.parseInt(i));
            }
            MyQueue myQueue = new MyQueue(paraArrayList);
            myQueue.appendTail(key);
            return myQueue.toString();
        }
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#4#5#6#7#8#9";
    }

    @Override
    protected String setDescription() {
        return "请实现队列的两个函数,appendTail(队尾插入节点)和deleteEnd(队头删除节点)," +
                "后面添加_隔开的元素则插入队尾,没有则删队头,队列元素请用#隔开";
    }

    private class MyQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        private List<Integer> paraArrayList;

        public List<Integer> getParaArrayList() {
            return paraArrayList;
        }

        public void setParaArrayList(List<Integer> paraArrayList) {
            this.paraArrayList = paraArrayList;
        }

        public MyQueue(List<Integer> paraArrayList) {
            this.paraArrayList = paraArrayList;
            for(int i: paraArrayList){
                stack1.push(i);
            }
        }

        public int deleteHead() {
            //先把所有元素压入栈1, 然后再把栈1的值全部pop到栈2,做完一遍栈2顶就是队列头元素
            if (stack2.size() <= 0) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
            stack2.pop();
            return 0;
        }

        public void appendTail(int key) {
            //栈1的顶就是队尾
            stack1.push(key);
        }

        @NonNull
        @Override
        public String toString() {
            //遍历输出的顺序是栈2陆续pop,pop完把栈1的值pop了push进栈2,结束之后pop栈2
            StringBuilder result = new StringBuilder();
            result.append("前面队头,后面队尾:");
            while (stack2.size() > 0) {
                result.append(stack2.pop());
            }
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
            while (stack2.size() > 0) {
                result.append(stack2.pop());
            }
            return result + "";
        }
    }

}
