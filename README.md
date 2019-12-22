<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://stackedit.io/style.css" />
</head>

<body class="stackedit">
  <div class="stackedit__html"><h1><a id="Interview_Question_0"></a>Interview_Question</h1>
<p>用java实现剑指offer上面的面试题(可以安装在安卓手机上进行输入输出测试)</p>
<p>本人是刚刚毕业的软件工程专业大学生一枚,已经工作了半年左右.<br>
现在想要换个更好的公司,所以在工作之余的时间刷一下编程题,以便好好准备面试和笔试.<br>
我做的是一个能在手机上面跑的软件,上面按题目顺序列出了《剑指Offer》这本书上面的一些题目,<br></p>
    
 ![Image text](https://github.com/starP1at1num/Interview_Question/blob/master/img_folder/device-2019-12-22-204354.png)
<p>点击题目就能看到这个题目的描述,输入合法的参数并点击计算按钮能根据参数和题目得出计算结果,<br>
我也预设了一些参数,可以使输入参数更加便捷一些.<br></p>

 ![Image text](https://github.com/starP1at1num/Interview_Question/blob/master/img_folder/device-2019-12-22-204429.png)
<p>《剑指Offer》这本书本身的编程题的答案是用C++写的,而我这里转换成了java实现<br>
我先是编写了一个基类,上面有详情界面的基本布局和一些用得多的公共方法.<br>
而实现一个具体的题目的详情页面只需继承基类,以及根据具体情况重写<br>
goToNext(用于前往下一道题目),<br>
calculate(用于根据参数计算结果),setDescription(用于提供题目的描述),<br>
setDefaultTestCase(用于给出默认的测试用例)四个方法.<br>
在主页面我则添加了一个listView,listView的适配器只需要传入<br>
题目名,题目简介,<code>在这里插入代码片</code>和详情界面的类,就能把这道题添加进列表中.<br>
后续我会刷一下LeetCode上面的高频题,并且也做成一个安卓app<br>
(LeetCode上面的好刷一点,因为不用把C++转成java了O.O)<br>
如果有公司想要联系我可以联系我的邮箱:850928398@qq.com或者我的QQ:850928398<br>
希望能找到一个好工作O.O</p>
</div>
</body>

</html>
