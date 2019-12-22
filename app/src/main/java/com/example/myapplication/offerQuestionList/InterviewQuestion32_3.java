package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InterviewQuestion32_3 extends BaseActivity {
    private Stack<BinaryTree>[] stack;
    private List<String> result;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion33.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        stack = null;
        result = null;
        if (!parameter.contains("#")) {
            return "请输入正确的参数";
        }
        BinaryTree treeA = new BinaryTree();
        treeA.parameter = parameter;
        treeA.CreateByExtended(treeA);
        treeA.fresh(treeA);
        print(treeA);
        return result.toString();
    }

    @Override
    protected String setDefaultTestCase() {
        return "ABD##E##CF##G##";
    }

    @Override
    protected String setDescription() {
        return "请按照之字形顺序打印二叉树,即第一行从左到右下一行从右到左,第三行从左到右,以此类推" +
                "请输入扩展二叉树, 例如输入ABD##E##CF##G##";
    }

    private void print(BinaryTree root) {
        //需要两个栈,打印某一层的节点时,把下一层的节点保存到相应的栈里
        stack = new Stack[2];
        //建立Stack数组时需要为每一个Stack元素初始化一个对象
        for(int i = 0; i < 2; i++){
            stack[i] = new Stack<BinaryTree>();
        }
        result = new LinkedList<>();
        //奇数还是偶数
        int current = 0;
        int next = 1;
        stack[current].push(root);
        while (!stack[0].empty() || !stack[1].empty()) {
            BinaryTree node = stack[current].peek();
            stack[current].pop();
            result.add((String)node.data);
            if(current == 0){
                //奇数从左到右
                if(node.left != null){
                    stack[next].push(node.left);
                }
                if(node.right != null){
                    stack[next].push(node.right);
                }
            }else {
                //偶数从右到左
                if(node.right != null){
                    stack[next].push(node.right);
                }
                if(node.left != null) {
                    stack[next].push(node.left);
                }
            }
            if(stack[current].empty()){
                result.add("\n");
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}
