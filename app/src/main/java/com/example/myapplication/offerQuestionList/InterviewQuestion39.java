package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion39 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion40.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请输入正确的参数";
        }
        List<Integer> paraList = getParaArrayList(parameter);
        int result = moreThanHalfNum(paraList);
        if (result == 0) {
            return "数组中没有出现次数超过数组长度一半的数字";
        } else {
            return result + "";
        }
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#2#2#2#5#4#2";
    }

    @Override
    protected String setDescription() {
        return "数组中有个数字出现的次数超过数组长度的一半,请找出这个数字.数组各元素之间请以#间隔" +
                "例如输入1#2#3#2#2#2#5#4#2,将输出2";
    }

    private int moreThanHalfNum(List<Integer> paraList) {
        //遍历一遍数组,记录次数和值,如果下一个数字和之前保存的数字不同,就次数--,否则次数++
        //由于超过一半,次数肯定>0,所以数字就是最后一次把次数设为1对应的数字
        int result = paraList.get(0);
        int times = 1;
        for (int i = 0; i < paraList.size(); i++) {
            if (times == 0) {
                result = paraList.get(i);
                times = 1;
            } else if (paraList.get(i) == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkMoreThanHalf(paraList, result)) {
            result = 0;
        }
        return result;
    }

    private boolean checkMoreThanHalf(List<Integer> paraList, int result) {
        int times = 0;
        for (int i = 0; i < paraList.size(); i++) {
            if (paraList.get(i) == result) {
                times++;
            }
        }
        return (times * 2) > paraList.size();
    }
}
