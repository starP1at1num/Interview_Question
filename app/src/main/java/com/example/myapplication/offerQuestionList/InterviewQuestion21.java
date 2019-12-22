package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion21 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion22.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if(!parameter.contains("#")){
            return "请输入正确的参数";
        }
        List mParaList = getParaArrayList(parameter);
        mParaList = reorder(mParaList);
        return mParaList.toString();
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#4#5";
    }

    @Override
    protected String setDescription() {
        return "输入一个整数数组,实现一个函数来调整该数组中数字的顺序," +
                "使得所有奇数位于数组的前半部分,所有偶数位于数组的后半部分." +
                "数组各元素请用#隔开";
    }

    private List reorder(List mParaList){
        int end = mParaList.size() - 1;
        int start = 0;
        while (start < end){
            while (start < end && ((int)mParaList.get(start) & 0x1) != 0){
                start++;
            }
            while (start < end && ((int)mParaList.get(end) & 0x1) == 0){
                end--;
            }
            if(start < end){
                int temp = (int)mParaList.get(start);
                mParaList.set(start, (int)mParaList.get(end));
                mParaList.set(end, temp);
            }
        }
        return mParaList;
    }
}
