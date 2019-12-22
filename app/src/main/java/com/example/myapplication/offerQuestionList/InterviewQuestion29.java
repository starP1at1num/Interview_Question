package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion29 extends BaseActivity {
    StringBuilder stringBuilder;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion30.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        stringBuilder = new StringBuilder();
        if (!parameter.contains("#") || !parameter.contains(",")) {
            return "请规范输入参数";
        }
        //把用户的输-入转换为二维数组
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
        printMatrixColckwisely(data);
        return stringBuilder + "";
    }

    @Override
    protected String setDescription() {
        return "输入一个矩阵,按照从外向里以顺时针的顺序依次打印出每一个数字," +
                "矩阵同一行请按#隔开,不同行请按_隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "1#2#3#4,5#6#7#8,9#10#11#12,13#14#15#16";
    }

    private void printMatrixColckwisely(int[][] data) {
        int start = 0;
        while (data[0].length > start * 2 && data.length > start * 2) {
            printMatrixIncircle(data, start);
            start++;
        }
    }

    private void printMatrixIncircle(int[][] data, int start) {
        int endX = data[0].length - 1 - start;
        int endY = data.length - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            stringBuilder.append(data[start][i]);
            stringBuilder.append(",");
        }
        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                stringBuilder.append(data[i][endX]);
                stringBuilder.append(",");
            }
        }
        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                stringBuilder.append(data[endY][i]);
                stringBuilder.append(",");
            }
        }
        //从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                stringBuilder.append(data[i][start]);
                stringBuilder.append(",");
            }
        }
    }
}
