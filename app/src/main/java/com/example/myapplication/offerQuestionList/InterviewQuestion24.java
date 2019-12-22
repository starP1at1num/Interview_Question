package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.LinkedList;
import java.util.List;

public class InterviewQuestion24 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion25.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "吐了,链表不好搞,讲一下算法,我们需要3个指针,分别保存当前节点,前一个节点,以及后一个节点" +
                "前一个节点用于反转,后一个节点用于保存指针,防止链表断裂";
    }

    @Override
    protected String setDescription() {
        return "定义一个函数,输入一个链表的头结点,反转该链表并输出反转后的头结点(链表各节点请用#隔开)";
    }

    @Override
    protected String setDefaultTestCase() {
        return "A#B#C#D#E";
    }
}
