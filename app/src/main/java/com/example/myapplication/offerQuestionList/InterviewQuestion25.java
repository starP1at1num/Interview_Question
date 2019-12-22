package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestion25 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion26.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains("_")) {
            return "请输入正确的参数";
        }
        List<Integer> list1 = getParaArrayList(parameter.split("_")[0]);
        List<Integer> list2 = getParaArrayList(parameter.split("_")[1]);
        List<Integer> result = new ArrayList();
        for (int i = 0, j = 0; i < list1.size() || j < list2.size(); ) {
            if(i >= list1.size()){
                result.add(list2.get(j));
                j++;
                continue;
            }else if(j >= list2.size()){
                result.add(list1.get(i));
                i++;
                continue;
            }
            if(list1.get(i) < list2.get(j)){
                result.add(list1.get(i));
                i++;
            }else {
                result.add(list2.get(j));
                j++;
            }
        }
        return result.toString();
    }

    @Override
    protected String setDescription() {
        return "输入两个递增排序的链表, 合并这两个链表并使新链表中的节点仍是递增排序的," +
                "链表内请用#隔开,链表之间请用_隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#3#5#7_2#4#6#8";
    }
}
