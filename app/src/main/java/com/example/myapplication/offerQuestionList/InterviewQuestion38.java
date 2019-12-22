package com.example.myapplication.offerQuestionList;

import android.text.TextUtils;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion38 extends BaseActivity {
    private StringBuilder result;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion39.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //把字符串分成两个部分,第一个字符和后面的所有字符.然后就可以递归求解
        if (!parameter.contains("#")) {
            return "请输入正确的参数";
        }
        result = null;
        List<String> paraList = getParaLinkedListForString(parameter);
        permutation(paraList);
        return result + "";
    }

    @Override
    protected String setDescription() {
        return "输入一个字符串,打印出该字符串中字符的所有排列,例如输入a#b#c," +
                "则打印出abc,acb,bca,bac,cab,cba";
    }

    @Override
    protected String setDefaultTestCase() {
        return "a#b#c";
    }

    private void permutation(List<String> paraList) {
        result = new StringBuilder();
        permutation(paraList, 0);
    }

    private void permutation(List<String> paraList, int begin) {
        if (begin >= paraList.size()) {
            result.append(paraList.toString());
        } else {
            for (int i = begin; i < paraList.size(); i++) {
                String temp = paraList.get(i);
                paraList.set(i, paraList.get(begin));
                paraList.set(begin, temp);
                permutation(paraList, begin + 1);
                temp = paraList.get(i);
                paraList.set(i, paraList.get(begin));
                paraList.set(begin, temp);
            }
        }
    }
}
