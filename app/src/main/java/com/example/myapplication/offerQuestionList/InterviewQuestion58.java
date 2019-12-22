package com.example.myapplication.offerQuestionList;

import com.example.myapplication.BaseActivity;

public class InterviewQuestion58 extends BaseActivity {
    private char[] result;

    @Override
    protected void goToNext() {
        goToNext(InterviewQuestion59.class);
    }

    @Override
    protected String calculateAnswer(String parameter) {
        result = null;
        char[] paraList = parameter.toCharArray();
        return String.valueOf(reverseSentence(paraList));
    }

    @Override
    protected String setDescription() {
        return "输入一个英文句子,翻转句子中单词的顺序,但单词内字符的顺序不变,为简单起见,标点符号和普通字母一样处理." +
                "例如输入I am a student.则输出student. a am I";
    }

    @Override
    protected String setDefaultTestCase() {
        return "I am a student.";
    }

    private void reverse(int start, int end) {
        while (start < end) {
            char temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }
    }

    private char[] reverseSentence(char[] paraList) {
        int begin = 0;
        int end = paraList.length - 1;
        result = paraList;
        //先把整个句子翻转
        reverse(begin, end);
        begin = end = 0;
        while (begin < paraList.length) {
            if (paraList[begin] == ' ') {
                begin++;
                end++;
            } else if (end == paraList.length || paraList[end] == ' ') {
                reverse(begin, --end);
                begin = ++end;
            } else {
                end++;
            }
        }
        return result;
    }
}
