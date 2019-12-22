package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class InterviewQuestion32_1 extends BaseActivity {
    private Deque<BinaryTree> deque;
    private List<String> result;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion32_2.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        deque = null;
        result = null;
        if (!parameter.contains("#")) {
            return "请输入正确的参数";
        }
        BinaryTree treeA = new BinaryTree();
        treeA.parameter = parameter;
        treeA.CreateByExtended(treeA);
        treeA.fresh(treeA);
        printFromTopToBottom(treeA);
        return result.toString();
    }

    @Override
    protected String setDefaultTestCase() {
        return "ABD##E##CF##G##";
    }

    @Override
    protected String setDescription() {
        return "从上到下打印二叉树的每个节点,同一层的节点按照从左到右的顺序打印," +
                "请输入扩展二叉树, 例如输入ABD##E##CF##G##, 从上到下按层打印的顺序为ABCDEFG";
    }

    private void printFromTopToBottom(BinaryTree root) {
        //addFirst(E)	向队列头部插入一个元素,失败时抛出异常
        //addLast(E)	向队列尾部插入一个元素,失败时抛出异常
        //removeFirst()	弹出队列头部元素,队列为空时抛出异常
        //removeLast()	弹出队列尾部元素,队列为空时抛出异常
        //getFirst()	获取队列头部元素,队列为空时抛出异常
        //getLast()	获取队列尾部元素,队列为空时抛出异常
        deque = new LinkedList<>();
        result = new LinkedList<>();
        deque.addLast(root);
        while (deque.size() != 0) {
            BinaryTree node = deque.getFirst();
            deque.removeFirst();
            result.add((String) node.data);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
    }
}
