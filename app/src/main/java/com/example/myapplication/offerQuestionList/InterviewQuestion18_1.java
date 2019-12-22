package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.LinkedList;
import java.util.List;

public class InterviewQuestion18_1 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion18_2.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains("_")) {
            return "请正确输入参数";
        }
        String key = parameter.split("_")[1];
        LinkedList<String> mLinkedList = (LinkedList<String>) getParaLinkedListForString(parameter.split("_")[0]);
        mLinkedList = (LinkedList<String>) deleteNode(mLinkedList, key);
        return mLinkedList.toString();
    }

    @Override
    protected String setDefaultTestCase() {
        return "a#b#h#i#j_i";
    }

    @Override
    protected String setDescription() {
        return "给定单向链表的头指针和一个节点指针,定义一个函数则0(1)时间内删除该节点." +
                "链表之间请用#隔开,链表和待删节点之间请用_隔开";
    }

    private List<String> deleteNode(LinkedList mLinkedList, String key){
        //这里可以不用遍历整个链表
        //把待删除节点的下一个节点的内容复制到这个节点,
        //然后把待删除节点的next指向下一个节点的next,
        //然后把下一个节点删除
        //需要考虑头结点,中间节点,尾节点3种情况,
        //注意尾节点的情况需要遍历一遍链表
        //java没有指针,所以不做具体编写
        mLinkedList.remove(mLinkedList.indexOf(key));
        return mLinkedList;
    }
}
