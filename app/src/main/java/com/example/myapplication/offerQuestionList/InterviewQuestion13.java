package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion13 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion14.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")) {
            return "请正确输入参数";
        }
        String[] paraList = parameter.split("#");
        int m = Integer.parseInt(paraList[0]);
        int n = Integer.parseInt(paraList[1]);
        int k = Integer.parseInt(paraList[2]);
        return movingCount(k, m, n) + "";
    }

    @Override
    protected String setDescription() {
        return "地图上有一个m行n列的方格.一个机器人从坐标(0,0)的格子开始移动,它每次可以" +
                "向上/下/左/右移动一格,但不能进入行坐标和列坐标的数位之和大于k的格子." +
                "例如k为18时,机器人能够进入方格(35,37)因为3+5+3+7=18.但他不能进入方格(35,38)." +
                "请问该机器人能够到达多少个格子?请按以下格式输入参数m#n#k";
    }

    @Override
    protected String setDefaultTestCase() {
        return "100#100#18";
    }

    private int movingCount(int k, int m, int n) {
        if (k < 0 || m <= 0 || n <= 0) {
            return -1;
        }
        //防止进入两次
        boolean[] visited = new boolean[n * m];
        for (boolean isVisit : visited) {
            isVisit = false;
        }
        //机器人从(0,0)开始移动
        int count = movingCountCore(k, m, n, 0, 0, visited);
        visited = null;
        return count;
    }

    private int movingCountCore(int k, int m, int n, int row, int col, boolean[] visited) {
        int count = 0;
        //判断是否能够进入
        if (check(k, m, n, row, col, visited)) {
            visited[row * n + col] = true;
            //能够进入再判断上下左右能不能进入
            //上下左右移动
            //全部的加起来就是能够到达的格子
            count = 1 + movingCountCore(k, m, n, row - 1, col, visited) +
                    movingCountCore(k, m, n, row, col - 1, visited) +
                    movingCountCore(k, m, n, row + 1, col, visited) +
                    movingCountCore(k, m, n, row, col + 1, visited);
        }
        return count;
    }

    private boolean check(int k, int m, int n, int row, int col, boolean[] visited) {
        if (row >= 0 && row < m && col >= 0 && col < n
                && getDigitSum(row) + getDigitSum(col) <= k && !visited[row * n + col]) {
            return true;
        }
        return false;
    }

    //求数位相加的方法
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number /= 10;
        }
        return sum;
    }
}
