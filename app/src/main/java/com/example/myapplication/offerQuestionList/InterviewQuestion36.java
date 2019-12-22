package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestion36 extends BaseActivity {

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion37.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        if (!parameter.contains("#")  || !parameter.contains(",")) {
            return "请输入正确的参数";
        }
        BinaryTree treeA = new BinaryTree();
        treeA.parameter = parameter;
        treeA.CreateByExtendedWithInt(treeA);
        treeA.fresh(treeA);
        Convert(treeA);
        List<String> printList = new ArrayList<>();
        while (head != null){
            printList.add(head.data + "");
            head = head.right;
        }
        return printList.toString();
    }

    @Override
    protected String setDescription() {
        return "输入一棵二叉搜索树,将该二叉搜索树转换成一个排序的双向链表.要求不能创建任何新的节点," +
                "只能调整树中节点的指向.请以扩展二叉树的方式输入二叉树,各元素请以,隔开";
    }

    @Override
    protected String setDefaultTestCase() {
        return "10,6,4,#,#,8,#,#,14,12,#,#,16,#,#";
    }

    //用于储存中序遍历当前的节点，作为中间变量，将双向指针链接起来
    private BinaryTree pre=null;
    //递归到最深层，返回双向链表的头
    private BinaryTree head=null;
    public BinaryTree Convert(BinaryTree pRootOfTree) {
        //这种中序遍历每次返回一个节点过于麻烦，所以定义一个函数每次返回为空
        inOrder(pRootOfTree);
        return head;
    }
    private void inOrder(BinaryTree node)
    {
        //遍历到最深处节点为空进行返回
        if(node==null)
        {
            return;
        }
        //左递归
        inOrder(node.left);
        //中序遍历在中间进行处理
        //利用pre将彼此互相指向
        node.left=pre;
        if(pre!=null)
        {
            pre.right=node;
        }
        //pre移位
        pre=node;
        //递归到最深处才将头赋值，也就是双向链表的头
        if(head==null)
        {
            head=node;
        }
        //右递归
        inOrder(node.right);
    }
}
