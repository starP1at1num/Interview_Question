package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion22 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion23.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains("_")) {
            return "请输入正确的参数";
        }
        List mParaList = getParaArrayList(parameter.split("_")[0]);
        int key = Integer.parseInt(parameter.split("_")[1]);
        return findKthToTail(mParaList, key) + "";
    }

    @Override
    protected String setDescription() {
        return "输入一个链表,输出该链表中倒数第k个节点,本题从1开始计数," +
                "例如1#2#3#4#5#6的倒数第三个节点的值为4.链表内节点请用#隔开, 链表和参数请用_隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#4#5#6_3";
    }

    private int findKthToTail(List<Integer> mParaList, int key) {
        int ahead = 0;
        int behead = 0;
        for (int i = 0; i < key - 1; ++i) {
            ahead++;
        }
        while (mParaList.size() - 1 > ahead) {
            ahead++;
            behead++;
        }
        return mParaList.get(behead);
    }
}
