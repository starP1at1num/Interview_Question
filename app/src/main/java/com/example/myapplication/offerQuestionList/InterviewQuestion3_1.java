package com.example.myapplication.offerQuestionList;

import android.content.Intent;

import com.example.myapplication.BaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterviewQuestion3_1 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion3_2.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if ("".equals(parameter) || !parameter.contains("#")) {
            return "请输入正确的参数";
        }
        List<Integer> mArrayList = getParaArrayList(parameter);
        Collections.sort(mArrayList);
        for (int i = 0; i < mArrayList.size() - 1; i++) {
            if (mArrayList.get(i) == mArrayList.get(i + 1)) {
                return mArrayList.get(i) + "";
            }
        }
        return "输入的参数中没有重复的数字";
    }

    @Override
    protected String setDescription() {
        return "找出数组中任意一个重复的数字,例如输入2#3#1#0#2#5#3,那么对应的输出是2或者3";
    }

    @Override
    protected String setDefaultTestCase() {
        return "2#3#1#0#2#5#3";
    }
}
