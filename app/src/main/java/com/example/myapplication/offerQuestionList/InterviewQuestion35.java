package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion35 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion36.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "java和c++还是有点相差的,不想写这个,大概说一下思路:" +
                "3种方法,一种是双重遍历,第二种是哈希表, 重点讲第三种:" +
                "第一步,为每个节点N创建对应的N', 我们把N'链接在N的后面," +
                "然后N'的sibling就是N的sibling的next." +
                "第三步是把长链表拆分成两个链表,把奇数位置的节点用next链接就是原表," +
                "偶数用next链接就是新表";
    }

    @Override
    protected String setDefaultTestCase() {
        return super.setDefaultTestCase();
    }

    @Override
    protected String setDescription() {
        return "请实现函数复制一个复杂链表,复杂链表除了有next指针指向下一个节点," +
                "还有sibling指针指向链表任意节点或者null";
    }
}