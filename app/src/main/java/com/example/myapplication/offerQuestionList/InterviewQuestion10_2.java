package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion10_2 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion11.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "n>2时,第一次跳有2种不同的选择,只跳1级:此时跳法数目等于后面剩下的n-1级级台阶" +
                "的跳法数目,只跳2级:次数跳法数目等于后面剩下的n-2级的跳法数目,不难看出,这就是斐波那契数列了";
    }

    @Override
    protected String setDefaultTestCase() {
        return "同10_1";
    }

    @Override
    protected String setDescription() {
        return "一个青蛙一次可以跳上1级台阶,也可以跳上2级台阶,求该青蛙跳上n级的台阶总共有多少种跳法";
    }
}
