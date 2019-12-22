package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.List;

public class InterviewQuestion11 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion12.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        //这里我们注意到旋转之后的数着呢实际上可以划分为两个排序的子数组,前面子数组的元素都
        //大于或等于后面子数组中的元素,还有就是最小的元素刚好是这两个子数组的分界线
        //我们用两个指针分别指向第一个和最后一个元素, 如果中间的元素大于第一个指针指向的元素
        //那么最小元素应该在中间元素的后面,这样我们把第一个指针指向中间元素,
        //反之同理,这样就缩小了一半的范围了
        if (!parameter.contains("#")) {
            return "数组请用#隔开";
        }
        List<Integer> mParaList = getParaArrayList(parameter);

        return min(mParaList) + "";
    }

    @Override
    protected String setDescription() {
        return "把一个数组中的若干个元素搬到数组的末尾,我们称之为数组的旋转.输入一个递增排序的数组的" +
                "一个旋转,输出旋转数组的最小元素,例如输入3#4#5#1#2, 输出1, 数组请用#隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "5#6#7#8#9#1#2#3#4";
    }

    private int min(List<Integer> mParaList) {
        int index1 = 0;
        int index2 = mParaList.size() - 1;
        int indexMid = index1;
        while (mParaList.get(index1) >= mParaList.get(index2)) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;

            if (mParaList.get(index1) == mParaList.get(index2) && mParaList.get(index1) == mParaList.get(indexMid)) {
                return minInOrder(mParaList, index1, index2);
            }
            if (mParaList.get(indexMid) >= mParaList.get(index1)) {
                index1 = indexMid;
            } else if (mParaList.get(indexMid) <= mParaList.get(index2)) {
                index2 = indexMid;
            }
        }
        return mParaList.get(indexMid);
    }

    private int minInOrder(List<Integer> mParaList, int index1, int index2) {
        int result = mParaList.get(index1);
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > mParaList.get(i)) {
                result = mParaList.get(i);
            }
        }
        return result;
    }
}
