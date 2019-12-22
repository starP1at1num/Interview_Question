package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion47 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion48.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains(",")) {
            return "请规范输入参数";
        }
        //再把用户的输-入转换为二维数组
        String[] lineList = parameter.split(",");
        int rowSize = lineList.length;
        int columnSize = lineList[0].split("#").length;
        int[][] data = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            //每一行的数据
            String[] singleDataList = lineList[i].split("#");
            for (int j = 0; j < columnSize; j++) {
                data[i][j] = Integer.parseInt(singleDataList[j]);
            }
        }
        return "" + getMaxValue(data);
    }

    @Override
    protected String setDescription() {
        return "在一个m*n的棋盘上的每一格都放有一个礼物,每个礼物都有一定的价值(价值大于0)," +
                "你可以从棋盘的左上角开始拿格子里的礼物,并每次向右或向下移动一格,直到到达棋盘的右下角." +
                "给定一个棋盘以及上面的礼物,请计算你最多能拿到多少价值的礼物.棋盘横向请以#隔开,纵向请以_隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#10#3#8,12#2#9#6,5#7#4#11,3#7#16#5";
    }

    private int getMaxValue(int[][] dataList) {
        //这是一个典型的能用动态规划解决的问题
        //递归不是最优的,基于循环的代码效率要高很多
        //我们需要一个辅助的二维数组.每个元素表示到达该格子时能拿到的礼物价值总和的最大值
        //还能进一步优化,就是用一维数组保存,保存f(a) = g(a,a)...f(n) = g(n,n), f(n+1) = g(n,n+1)...
        //f(m) = g(n,m);
        int[][] maxValues = new int[dataList[0].length][dataList.length];
        for (int i = 0; i < dataList.length; i++) {
            for (int j = 0; j < dataList[0].length; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValues[i - 1][j];
                }
                if (j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(up, left) + dataList[i][j];
            }
        }
        return maxValues[dataList[0].length - 1][dataList.length - 1];
    }
}
