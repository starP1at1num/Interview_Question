package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion48 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion49.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        return longestSubStringWithoutDuplication(parameter) + "";
    }

    @Override
    protected String setDefaultTestCase() {
        return "arabcacfr";
    }

    @Override
    protected String setDescription() {
        return "请从字符串中找出一个最长的不含重复字符的子字符串,计算该最长子字符串的长度." +
                "假设字符串中只包含a-z的字符.例如在字符串arabcacfr中,最长的不含重复字符的子字符串是acfr," +
                "长度为4";
    }

    private int longestSubStringWithoutDuplication(String parameter){
        int curLength = 0;
        int maxLength = 0;
        //position保存的是这个字符上次出现的位置,如果没出现就是-1
        int[] position = new int[26];
        for(int i = 0; i < 26; i++){
            position[i] = -1;
        }
        for(int i = 0; i < parameter.length(); i++){
            int prevIndex = position[parameter.charAt(i) - 'a'];
            //如果字符没重复,或者离得比较远,就是比最大长度还远,就不会影响
            if(prevIndex < 0 || i - prevIndex > curLength){
                curLength++;
            }else {
                //重复并且离得很近的情况
                //max先保存当前的最大长度,防止被覆盖
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                //然后根据当前和上一个重复字符之间的距离重置当前最大长度
                curLength = i - prevIndex;
            }
            //把位置记在position中
            position[parameter.charAt(i) - 'a'] = i;
        }
        if(curLength > maxLength){
            //比较已保存的和当前的最大长度,返回其中的较大者
            maxLength = curLength;
        }
        return maxLength;
    }
}
