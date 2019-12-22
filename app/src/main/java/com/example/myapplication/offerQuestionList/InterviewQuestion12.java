package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion12 extends BaseActivity {

    private int pathLength = 0;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion13.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("_")) {
            return "请把参数用_分隔并放在输入值的末尾";
        }
        if (!parameter.contains("#") || !parameter.contains(",")) {
            return "请规范输入参数";
        }
        //先用_把待查找的数取出
        String[] paraList = parameter.split("_");
        String[] pathList = paraList[1].split("#");
        String[] lineList = paraList[0].split(",");
        int rowSize = lineList.length;
        int columnSize = lineList[0].split("#").length;
        String[][] data = new String[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            //每一行的数据
            String[] singleDataList = lineList[i].split("#");
            for (int j = 0; j < columnSize; j++) {
                data[i][j] = singleDataList[j];
            }
        }
        if (hasPath(data, pathList)) {
            return "矩阵中有该路径";
        } else {
            return "矩阵中无该路径";
        }
    }

    @Override
    protected String setDefaultTestCase() {
        return "a#b#t#g,c#f#c#s, j#d#e#h_b#f#c#e";
    }

    @Override
    protected String setDescription() {
        return "请设计一个函数用来判断是否存在一条包含某字符串所有字符的路径." +
                "路径可以从矩阵中的任意一格开始,每一步可以中矩阵中向上/下/左/右移动一格." +
                "如果一条路径经过了矩阵的某一格,那么该路径不能再次进入该格子." +
                "矩阵请用#和,隔开,路径和矩阵请用_隔开,路径内部请用#隔开,矩阵内字符允许相同";
    }

    private boolean hasPath(String[][] data, String[] pathList) {
        //构建一个长度为矩阵节点数的布尔数组记录是否访问过该节点
        boolean[] visited = new boolean[data[0].length * data.length];
        for (boolean isVisit : visited) {
            isVisit = false;
        }
        //遍历整个矩阵
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                if (hasPathCore(data, row, col, pathList, pathLength, visited)) {
                    return true;
                }
            }
        }
        //用完要释放
        visited = null;
        return false;
    }

    //核心算法
    private boolean hasPathCore(String[][] data, int row, int col, String[] pathList, int pathLength, boolean[] visited) {
        boolean hasPath = false;
        //匹配完毕就退出
        if (pathLength > pathList.length - 1) {
            return true;
        }

        //如果矩阵中该行该列的值等于参数列表第pathLength个值,说明参数列表第pathLength个值已经匹配成功
        //需要去匹配下一个了
        if (row >= 0 && row < data.length && col >= 0 && col < data[0].length
                && data[row][col].equals(pathList[pathLength]) && !visited[row * data[0].length + col]) {
            pathLength++;
            visited[row * data[0].length + col] = true;
            //匹配上下左右是否相等
            hasPath = hasPathCore(data, row, col - 1, pathList, pathLength, visited)
                    || hasPathCore(data, row - 1, col, pathList, pathLength, visited)
                    || hasPathCore(data, row, col + 1, pathList, pathLength, visited)
                    || hasPathCore(data, row + 1, col, pathList, pathLength, visited);
            //不相等则返回匹配上一个,同时把visit的该节点置false
            if (!hasPath) {
                --pathLength;
                visited[row * data[0].length + col] = false;
            }
        }
        return hasPath;
    }
}
