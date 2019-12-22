package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion18_2 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion19.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //加一个pre标记,如果后面的和当前相同,pre不动遍历指针一直走到和pre的值不同,把之间的都删除
        List mParaList = getParaLinkedList(parameter);
        mParaList = deleteDuplication(mParaList);
        return mParaList.toString();
    }

    @Override
    protected String setDescription() {
        return "在一个排序的链表中删除重复的节点,节点之间请用#隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#3#4#4#5";
    }

    private List<String> deleteDuplication(List<String> mParaList) {
        int pre = 0;
        boolean needDelete = false;
        for (int i = 0; i < mParaList.size() - 1; i++) {
            if (mParaList.get(i) == mParaList.get(i + 1)) {
                needDelete = true;
            }
            if(!needDelete){
                pre++;
            }else {
                mParaList.remove(i);
            }
        }
        return mParaList;
    }
}
