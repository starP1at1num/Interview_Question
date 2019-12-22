package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.offerQuestionList.InterviewQuestion10_1;
import com.example.myapplication.offerQuestionList.InterviewQuestion10_2;
import com.example.myapplication.offerQuestionList.InterviewQuestion11;
import com.example.myapplication.offerQuestionList.InterviewQuestion12;
import com.example.myapplication.offerQuestionList.InterviewQuestion13;
import com.example.myapplication.offerQuestionList.InterviewQuestion14;
import com.example.myapplication.offerQuestionList.InterviewQuestion15;
import com.example.myapplication.offerQuestionList.InterviewQuestion16;
import com.example.myapplication.offerQuestionList.InterviewQuestion17;
import com.example.myapplication.offerQuestionList.InterviewQuestion18_1;
import com.example.myapplication.offerQuestionList.InterviewQuestion18_2;
import com.example.myapplication.offerQuestionList.InterviewQuestion19;
import com.example.myapplication.offerQuestionList.InterviewQuestion20;
import com.example.myapplication.offerQuestionList.InterviewQuestion21;
import com.example.myapplication.offerQuestionList.InterviewQuestion22;
import com.example.myapplication.offerQuestionList.InterviewQuestion23;
import com.example.myapplication.offerQuestionList.InterviewQuestion24;
import com.example.myapplication.offerQuestionList.InterviewQuestion25;
import com.example.myapplication.offerQuestionList.InterviewQuestion26;
import com.example.myapplication.offerQuestionList.InterviewQuestion27;
import com.example.myapplication.offerQuestionList.InterviewQuestion28;
import com.example.myapplication.offerQuestionList.InterviewQuestion29;
import com.example.myapplication.offerQuestionList.InterviewQuestion30;
import com.example.myapplication.offerQuestionList.InterviewQuestion31;
import com.example.myapplication.offerQuestionList.InterviewQuestion32_1;
import com.example.myapplication.offerQuestionList.InterviewQuestion32_2;
import com.example.myapplication.offerQuestionList.InterviewQuestion32_3;
import com.example.myapplication.offerQuestionList.InterviewQuestion33;
import com.example.myapplication.offerQuestionList.InterviewQuestion34;
import com.example.myapplication.offerQuestionList.InterviewQuestion35;
import com.example.myapplication.offerQuestionList.InterviewQuestion36;
import com.example.myapplication.offerQuestionList.InterviewQuestion37;
import com.example.myapplication.offerQuestionList.InterviewQuestion38;
import com.example.myapplication.offerQuestionList.InterviewQuestion39;
import com.example.myapplication.offerQuestionList.InterviewQuestion3_1;
import com.example.myapplication.offerQuestionList.InterviewQuestion3_2;
import com.example.myapplication.offerQuestionList.InterviewQuestion4;
import com.example.myapplication.offerQuestionList.InterviewQuestion40;
import com.example.myapplication.offerQuestionList.InterviewQuestion41;
import com.example.myapplication.offerQuestionList.InterviewQuestion42;
import com.example.myapplication.offerQuestionList.InterviewQuestion43;
import com.example.myapplication.offerQuestionList.InterviewQuestion44;
import com.example.myapplication.offerQuestionList.InterviewQuestion45;
import com.example.myapplication.offerQuestionList.InterviewQuestion46;
import com.example.myapplication.offerQuestionList.InterviewQuestion47;
import com.example.myapplication.offerQuestionList.InterviewQuestion48;
import com.example.myapplication.offerQuestionList.InterviewQuestion49;
import com.example.myapplication.offerQuestionList.InterviewQuestion5;
import com.example.myapplication.offerQuestionList.InterviewQuestion50;
import com.example.myapplication.offerQuestionList.InterviewQuestion51;
import com.example.myapplication.offerQuestionList.InterviewQuestion52;
import com.example.myapplication.offerQuestionList.InterviewQuestion54;
import com.example.myapplication.offerQuestionList.InterviewQuestion55;
import com.example.myapplication.offerQuestionList.InterviewQuestion58;
import com.example.myapplication.offerQuestionList.InterviewQuestion59;
import com.example.myapplication.offerQuestionList.InterviewQuestion6;
import com.example.myapplication.offerQuestionList.InterviewQuestion7;
import com.example.myapplication.offerQuestionList.InterviewQuestion8;
import com.example.myapplication.offerQuestionList.InterviewQuestion9;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<ButtonVO> buttonVOList = new ArrayList<ButtonVO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        InitList();
        listView = (ListView) findViewById(R.id.main_list_view);
        ButtonListAdapter adapter = new ButtonListAdapter(MainActivity.this,
                R.layout.button_list_item, buttonVOList);
        listView.setAdapter(adapter);
    }

    private void InitList() {
        buttonVOList.add(new ButtonVO("面试题三题目一", "找出数组中重复的数字", InterviewQuestion3_1.class));
        buttonVOList.add(new ButtonVO("面试题三题目二", "不修改数组找出数组中重复的数字", InterviewQuestion3_2.class));
        buttonVOList.add(new ButtonVO("面试题四", "二维数组中的查找", InterviewQuestion4.class));
        buttonVOList.add(new ButtonVO("面试题五", "替换空格", InterviewQuestion5.class));
        buttonVOList.add(new ButtonVO("面试题六", "从尾到头打印链表", InterviewQuestion6.class));
        buttonVOList.add(new ButtonVO("面试题7", "重建二叉树", InterviewQuestion7.class));
        buttonVOList.add(new ButtonVO("面试题八", "二叉树的下一个节点", InterviewQuestion8.class));
        buttonVOList.add(new ButtonVO("面试题九", "用两个栈实现队列", InterviewQuestion9.class));
        buttonVOList.add(new ButtonVO("面试题十题目一", "求斐波那契数列的第n项", InterviewQuestion10_1.class));
        buttonVOList.add(new ButtonVO("面试题十题目二", "青蛙跳台阶问题", InterviewQuestion10_2.class));
        buttonVOList.add(new ButtonVO("面试题十一", "旋转数组中的最小数字", InterviewQuestion11.class));
        buttonVOList.add(new ButtonVO("面试题十二", "矩阵中的路径", InterviewQuestion12.class));
        buttonVOList.add(new ButtonVO("面试题十三", "机器人的运动范围", InterviewQuestion13.class));
        buttonVOList.add(new ButtonVO("面试题十四", "剪绳子", InterviewQuestion14.class));
        buttonVOList.add(new ButtonVO("面试题十五", "二进制中1的个数", InterviewQuestion15.class));
        buttonVOList.add(new ButtonVO("面试题十六", "数值的整数次方", InterviewQuestion16.class));
        buttonVOList.add(new ButtonVO("面试题十七", "打印从1到最大的n位数", InterviewQuestion17.class));
        buttonVOList.add(new ButtonVO("面试题十八题目一", "删除链表的节点", InterviewQuestion18_1.class));
        buttonVOList.add(new ButtonVO("面试题十八题目二", "删除链表中重复的节点", InterviewQuestion18_2.class));
        buttonVOList.add(new ButtonVO("面试题十九", "正则表达式匹配", InterviewQuestion19.class));
        buttonVOList.add(new ButtonVO("面试题二十", "表示数值的字符串", InterviewQuestion20.class));
        buttonVOList.add(new ButtonVO("面试题二十一", "调整数组顺序使奇数位于偶数前面", InterviewQuestion21.class));
        buttonVOList.add(new ButtonVO("面试题二十二", "链表中倒数第k个节点", InterviewQuestion22.class));
        buttonVOList.add(new ButtonVO("面试题二十三", "链表中环的入口节点", InterviewQuestion23.class));
        buttonVOList.add(new ButtonVO("面试题二十四", "反转链表", InterviewQuestion24.class));
        buttonVOList.add(new ButtonVO("面试题二十五", "合并两个排序的链表", InterviewQuestion25.class));
        buttonVOList.add(new ButtonVO("面试题二十六", "树的子结构", InterviewQuestion26.class));
        buttonVOList.add(new ButtonVO("面试题二十七", "二叉树的镜像", InterviewQuestion27.class));
        buttonVOList.add(new ButtonVO("面试题二十八", "对称的二叉树", InterviewQuestion28.class));
        buttonVOList.add(new ButtonVO("面试题二十九", "顺时针打印矩阵", InterviewQuestion29.class));
        buttonVOList.add(new ButtonVO("面试题三十", "包含min函数的栈", InterviewQuestion30.class));
        buttonVOList.add(new ButtonVO("面试题三十一", "栈的压入,弹出序列", InterviewQuestion31.class));
        buttonVOList.add(new ButtonVO("面试题三十二题目一", "不分行从上到下打印二叉树", InterviewQuestion32_1.class));
        buttonVOList.add(new ButtonVO("面试题三十二题目二", "分行从上到下打印二叉树", InterviewQuestion32_2.class));
        buttonVOList.add(new ButtonVO("面试题三十二题目三", "之字形打印二叉树", InterviewQuestion32_3.class));
        buttonVOList.add(new ButtonVO("面试题三十三", "二叉搜索树的后序遍历序列", InterviewQuestion33.class));
        buttonVOList.add(new ButtonVO("面试题三十四", "二叉索树中和为某一值的路径", InterviewQuestion34.class));
        buttonVOList.add(new ButtonVO("面试题三十五", "复杂链表的复制", InterviewQuestion35.class));
        buttonVOList.add(new ButtonVO("面试题三十六", "二叉搜索树与双向链表", InterviewQuestion36.class));
        buttonVOList.add(new ButtonVO("面试题三十七", "序列化二叉树", InterviewQuestion37.class));
        buttonVOList.add(new ButtonVO("面试题三十八", "字符串的排列", InterviewQuestion38.class));
        buttonVOList.add(new ButtonVO("面试题三十九", "数组中出现次数超过一半的数字", InterviewQuestion39.class));
        buttonVOList.add(new ButtonVO("面试题四十", "最小的k个数", InterviewQuestion40.class));
        buttonVOList.add(new ButtonVO("面试题四十一", "数据流中的中位数", InterviewQuestion41.class));
        buttonVOList.add(new ButtonVO("面试题四十二", "连续子数组的最大和", InterviewQuestion42.class));
        buttonVOList.add(new ButtonVO("面试题四十三", "1~n整数中1出现的次数", InterviewQuestion43.class));
        buttonVOList.add(new ButtonVO("面试题四十四", "数字序列中某一位的数字", InterviewQuestion44.class));
        buttonVOList.add(new ButtonVO("面试题四十五", "把数组排成最小的数", InterviewQuestion45.class));
        buttonVOList.add(new ButtonVO("面试题四十六", "把数字翻译成字符串", InterviewQuestion46.class));
        buttonVOList.add(new ButtonVO("面试题四十七", "礼物的最大价值", InterviewQuestion47.class));
        buttonVOList.add(new ButtonVO("面试题四十八", "最长不含重复字符的子字符串", InterviewQuestion48.class));
        buttonVOList.add(new ButtonVO("面试题四十九", "丑数", InterviewQuestion49.class));
        buttonVOList.add(new ButtonVO("面试题五十", "第一个只出现一次的字符", InterviewQuestion50.class));
        buttonVOList.add(new ButtonVO("面试题五十一", "数组中的逆序对", InterviewQuestion51.class));
        buttonVOList.add(new ButtonVO("面试题五十二", "两个链表的第一个公共节点", InterviewQuestion52.class));
        buttonVOList.add(new ButtonVO("面试题五十四", "二叉搜索树的第k大节点", InterviewQuestion54.class));
        buttonVOList.add(new ButtonVO("面试题五十五", "二叉树的深度", InterviewQuestion55.class));
        buttonVOList.add(new ButtonVO("面试题五十八", "翻转字符串", InterviewQuestion58.class));
        buttonVOList.add(new ButtonVO("面试题五十九", "队列的最大值", InterviewQuestion59.class));

    }

    @Override
    protected void onDestroy() {
        this.finish();
        super.onDestroy();
    }

    public class ButtonVO {
        private final String buttonDescription;
        private final Class aClass;
        private final String buttonName;

        public ButtonVO(String buttonName, String buttonDescription, Class aClass) {
            this.aClass = aClass;
            this.buttonDescription = buttonDescription;
            this.buttonName = buttonName;
        }

        public String getButtonDescription() {
            return buttonDescription;
        }

        public Class getaClass() {
            return aClass;
        }

        public String getButtonName() {
            return buttonName;
        }
    }
}
