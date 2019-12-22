package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion41 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion42.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return "注意要保证最小堆的最小数据要比最大堆最大的数据大,因此在插入时,如果插入的数据是最小堆," +
                "但是比最大堆一些数据小,那么就要把最大堆最大的插入最小堆,然后把这个数字插入最大堆," +
                "反之亦然";
    }

    @Override
    protected String setDescription() {
        return "如何得到一个数据流中的中位数";
    }

    @Override
    protected String setDefaultTestCase() {
        return "可以组合使用最小堆和最大堆, 数据总数是偶数时放入最小堆,奇数时放入最大堆," +
                "两个堆中数据之差不能超过1";
    }
}
