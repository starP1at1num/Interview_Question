package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class InterviewQuestion34 extends BaseActivity {
    private StringBuilder result = null;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion35.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#") || !parameter.contains("_") || !parameter.contains(",")) {
            return "请输入正确的参数";
        }
        result = new StringBuilder();
        String treeParameter = parameter.split("_")[0];
        int key = Integer.parseInt(parameter.split("_")[1]);
        BinaryTree treeA = new BinaryTree();
        treeA.parameter = treeParameter;
        treeA.CreateByExtendedWithInt(treeA);
        treeA.fresh(treeA);
        findPath(treeA, key);
        if(result.length() == 0){
            return "未找到此路径";
        }
        {
            return result + "";
        }
    }

    @Override
    protected String setDescription() {
        return "输入一棵二叉树和一个整数,打印出二叉树中节点值的和为输入整数的所有路径." +
                "从树的根节点开始往下一直到叶节点所经过的节点形成一条路径.二叉树请提交扩展二叉树序列," +
                "各节点值以,隔开, 整数请以_隔开放在参数末尾";
    }

    @Override
    protected String setDefaultTestCase() {
        return "10,5,4,#,#,7,#,#,12,#,#_22";
    }

    private void findPath(BinaryTree root, int key) {
        Vector<Integer> path = new Vector<>();
        int currentSum = 0;
        findPath(root, key, path, currentSum);
    }

    void findPath(BinaryTree root, int key, Vector<Integer> path, int currentSum) {
        currentSum = currentSum + (int) root.data;
        //vector插入的应是对象而不是数值，所以插入数值时要注意将数组转换成相应的对象
        path.addElement(new Integer((int) (root.data)));
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == key && isLeaf) {
            if(result.length() != 0) {
                result.append('\n');
            }
            result.append("找到路径:");
            Iterator it = path.iterator();
            while (it.hasNext()) {
                result.append((int) it.next());
                result.append(",");
            }
        }
        if (root.left != null) {
            findPath(root.left, key, path, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, key, path, currentSum);
        }
        path.removeElementAt(path.size() - 1);
    }
}
