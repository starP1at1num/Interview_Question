package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InterviewQuestion32_2 extends BaseActivity {
    private Deque<BinaryTree> deque;
    private List<String> result;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion32_3.class);
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
        print(treeA);
        return result.toString();
    }

    @Override
    protected String setDefaultTestCase() {
        return "ABD##E##CF##G##";
    }

    @Override
    protected String setDescription() {
        return "从上到下按层打印二叉树,同一层的节点按照从左到右的顺序打印,每一层打印到一行" +
                "请输入扩展二叉树, 例如输入ABD##E##CF##G##";
    }

    private void print(BinaryTree root) {
        //addFirst(E)	向队列头部插入一个元素,失败时抛出异常
        //addLast(E)	向队列尾部插入一个元素,失败时抛出异常
        //removeFirst()	弹出队列头部元素,队列为空时抛出异常
        //removeLast()	弹出队列尾部元素,队列为空时抛出异常
        //getFirst()	获取队列头部元素,队列为空时抛出异常
        //getLast()	获取队列尾部元素,队列为空时抛出异常
        deque = new LinkedList<>();
        result = new LinkedList<>();
        deque.push(root);
        //下一层节点的数目
        int nextLevel = 0;
        //当前层还没有打印的节点数
        int toBePrinted = 1;
        while (deque.size() != 0) {
            BinaryTree node = deque.getLast();
            result.add((String) node.data);
            if (node.left != null) {
                deque.push(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                deque.push(node.right);
                nextLevel++;
            }
            deque.removeLast();
            toBePrinted--;
            if(toBePrinted == 0){
                //当这一层的已经全部计算完毕
                //把计算好的下一层的节点总数设为待打印的节点数,然后进入下一层的下一层
                result.add("\n");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
            //先把下一层的数量全部计算完,然后再把这一层的一个一个pop,
            //pop完了再把下一层的数量设为还没打印的节点数
        }
    }
}
