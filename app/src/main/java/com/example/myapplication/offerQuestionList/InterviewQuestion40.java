package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class InterviewQuestion40 extends BaseActivity {
    private StringBuilder result;
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion41.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains("_")) {
            return "请正确输入参数";
        }
        result = null;
        int k = Integer.parseInt(parameter.split("_")[1]);
        List<Integer> paraList = getParaArrayList(parameter.split("_")[0]);
        getLeastNumbers(paraList,k);
        if(result != null){
            return result + "";
        }else {
            return "请正确输入参数";
        }
    }

    @Override
    protected String setDescription() {
        return "输入n个整数,找出其中最小的k个数,例如输入4#5#1#6#2#7#3#8这8个数字,则最小的k个数是1,2,3,4," +
                "n个整数之间请以#隔开,k请以_隔开置于参数末尾";
    }

    @Override
    protected String setDefaultTestCase() {
        return "4#5#1#6#2#7#3#8_4";
    }

    private void getLeastNumbers(List<Integer> paraList, int k) {
        //我们先创建一个大小为k的数据容器来存储最小的k个数字,然后每次读入一个数,
        //容器未满时直接放入,满了就找出k中的最大值并与带插入的数对比,小就替换
        //我们可以直接用stl的数据容器
        //也可以把数组排序然后取最小的k个值
        if(k >= paraList.size()){
            return;
        }
        result = new StringBuilder();
        Collections.sort(paraList);
        for(int i = 0; i < k; i++){
            result.append(paraList.get(i));
            result.append(",");
        }
    }
}
