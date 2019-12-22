package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion23 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion24.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "第一步,设一个走得快的指针一个走得慢的指针,快的走两步,慢的走一步." +
                "快的到了末尾都没追上慢的就说明不包含,否则包含." +
                "第二步是定义两个指针,第一个先走长度等于环中节点个数的步数,然后两个指针以相同速度向前移动." +
                "然后两个节点会汇集在入口节点." +
                "所以关键是得到环中节点数目,当一快一慢指针相遇后,从这个节点出发," +
                "一边移动一边计数,再次回到相遇节点时,就可以得到环中节点个数了";
    }

    @Override
    protected String setDefaultTestCase() {
        return "说下原理了";
    }

    @Override
    protected String setDescription() {
        return "环的不好实现,不做了";
    }
}
