package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion33 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion34.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请输入正确的参数";
        }
        String[] paraList = parameter.split("#");
        int[] sequence = new int[paraList.length];
        int i = 0;
        for (String string : paraList) {
            sequence[i] = Integer.parseInt(string);
            i++;
        }
        if(varifySequenceOfBST(sequence, sequence.length)){
            return "是二叉搜索树的后序遍历结果";
        }else {
            return "不是二叉搜索树的后序遍历结果";
        }
    }

    @Override
    protected String setDescription() {
        return "输入一个整数数组,判断该数组是不是某二叉树搜索树的后序遍历结果,假设数组任意两个数字都互不相同." +
                "例如输入数组5#7#5#9#11#10#8,则返回true";
    }

    @Override
    protected String setDefaultTestCase() {
        return "5#7#5#9#11#10#8";
    }

    private boolean varifySequenceOfBST(int[] sequence, int length) {
        //后序遍历的根节点就是最后一个节点
        int root = sequence[length - 1];
        int i = 0;
        //找到BST中左子树节点的值小于根节点的值
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //此时i前面的是左子树,后面的是右子树
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //这样就递归判断左子树和右子树是不是BST
        boolean left = true;
        if (i > 0) {
            left = varifySequenceOfBST(sequence, i);
        }
        boolean right = true;
        if (i < length - 1) {
            int[] subSequence = new int[length - i -1];
            sequence[0] = sequence[i];
            for(int point = 1; point < subSequence.length; point++){
                subSequence[point] = sequence[i + point];
            }
            right = varifySequenceOfBST(sequence , length - i -1);
        }
        return left && right;
    }
}
