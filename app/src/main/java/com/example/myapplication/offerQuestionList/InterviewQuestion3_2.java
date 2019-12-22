package com.example.myapplication.offerQuestionList;

import android.content.Intent;

import com.example.myapplication.BaseActivity;

import java.util.Collections;
import java.util.List;

public class InterviewQuestion3_2 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion4.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if ("".equals(parameter) || !parameter.contains("#")) {
            return "请输入正确的参数";
        }
        List<Integer> mArrayList = getParaArrayList(parameter);
        int start = 1;
        int end = mArrayList.size() - 1;
        while (end >= start){
            int middle = ((end - start) >> 1) + start;
            int count = countRange(mArrayList, start, middle);
            if(end == start){
                if(count > 1){
                    return start + "";
                }else {
                    break;
                }
            }
            if(count > (middle - start + 1)){
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return "输入的参数中没有重复的数字";
    }

    private int countRange(List<Integer> list, int start, int end){
        int count = 0;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= start && list.get(i) <= end){
                count++;
            }

        }
        return count;
    }

    @Override
    protected String setDescription() {
        return "在一个长度为n+1的数组里的所有数字都在1-n的范围内,所以数组中至少有1个数字是充分的.找出数组中任意一个重复的数字,但不能修改输入的数组,例如输入2#3#1#0#2#5#3,那么对应的输出是2或者3";
    }

    @Override
    protected String setDefaultTestCase() {
        return "2#3#5#4#3#2#6#7";
    }
}
