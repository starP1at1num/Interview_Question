package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion4 extends BaseActivity {
    @Override
    protected String setDefaultTestCase() {
        return "1#2#8#9,2#4#9#12,4#7#10#13,6#8#11#15_7";
    }

    @Override
    protected String setDescription() {
        return "在一个二维数组中,每一行都按照从左至右递增的顺序排序,每一列都按照从上到下递增的顺序排序." +
                "请完成一个函数,输入这样的一个二维数组和一个整数,判断数组中是否含有这种该函数" +
                "(行之间请用#间隔,列之间请用,间隔), 要查找的数则用_间隔";
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("_")) {
            return "请把参数用_分隔并放在输入值的末尾";
        }
        if (!parameter.contains("#") || !parameter.contains(",")) {
            return "请规范输入参数";
        }
        //先用$把待查找的数取出
        String[] paraList = parameter.split("_");
        int key = Integer.parseInt(paraList[1]);
        //再把用户的输-入转换为二维数组
        String[] lineList = paraList[0].split(",");
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
        int row = 0;
        int column = columnSize - 1;
        while (row < rowSize && column >= 0) {
            if (data[row][column] == key) {
                return "二维数组中包含这个值";
            } else if (data[row][column] > key) {
                column--;
            } else {
                row++;
            }
        }
        return "二维数组中没有这个值";
    }

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion5.class);
    }
}
