package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion26 extends BaseActivity {
    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion27.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {

        if (!parameter.contains("#") || !parameter.contains("_")) {
            return "请输入正确的参数";
        }
        BinaryTree treeA = new BinaryTree();
        treeA.parameter = parameter.split("_")[0];
        BinaryTree treeB = new BinaryTree();
        treeB.parameter = parameter.split("_")[1];
        treeA.CreateByExtended(treeA);
        treeA.fresh(treeA);
        treeB.CreateByExtended(treeB);
        treeB.fresh(treeB);
        if(hasSubTree(treeA, treeB)){
            return "B是A的子结构";
        }else {
            return "B不是A的子结构";
        }
    }

    @Override
    protected String setDefaultTestCase() {
        return "889##24##7##7##_89##2##";
    }

    @Override
    protected String setDescription() {
        return "输入两棵树A和B,判断B是不是A的子结构,两棵树之间请用_隔开,树请用扩展二叉树给出";
    }

    private boolean hasSubTree(BinaryTree treeA, BinaryTree treeB) {
        //第一步A中找到和B的根节点一样的节点R,第二步,判断A中以R为根节点的子树是不是包含和树B一样的结构
        boolean result = false;
        if (treeA != null && treeB != null) {
            //先找到和B根节点一样值的节点(可能有很多个)
            if (treeA.data.equals(treeB.data)) {
                //知道了就判断子树
                result = doesTree1haveTree2(treeA, treeB);
            }
            //找不到A就向左右遍历
            if (!result) {
                result = hasSubTree(treeA.left, treeB);
            }
            if (!result) {
                result = hasSubTree(treeA.right, treeB);
            }
            return result;
        }
        return false;
    }

    private boolean doesTree1haveTree2(BinaryTree tree1, BinaryTree tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (!tree1.data.equals(tree2.data)) {
            return false;
        }
        //直到结束为止只有自己的值相等,且左右子树的值也相等时才返回true
        return doesTree1haveTree2(tree1.left, tree2.left) && doesTree1haveTree2(tree1.right, tree2.right);
    }
}
