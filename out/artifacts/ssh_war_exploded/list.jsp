<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/24
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>员工信息展示页面</title>
</head>
<body>
<%-- s:a href="emp_addView"表示点击该链接后，会执行当前(在该jsp中)Action的addView()方法(此时Action为EmployeeAction)
    那前面为什么会有emp_呢？
    因为在struts.xml中--%>
<div align="center" style="width:80%"><s:a href="emp_addView">添加</s:a></div>
<table border="1" align="center" width="60%" cellpadding="5" cellspacing="0">
    <tr>
        <th>序号</th>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工薪水</th>
        <th>操作</th>
    </tr>
    <%--
    <s:iterator var="emp" value="#request.listEmp" status="st">
    解释：
    1.value属性:可选的属性,value属性是指一个被迭代的集合,使用ognl表达式指定,
        如果为空的话默认就是ValueStack栈顶的集合.
    2.var属性:是指集合元素的名字（任意）
    3.status属性:可选属性,该属性在迭代时会产生一个IteratorStatus对象,
        该对象可以判断当前元素的位置,包含了以下属性方法:
        int getCount(); 迭代元素个数
        int getIndex(); 迭代元素当前索引
        boolean getFirst(); 是否为第一个
        boolean getEven(); 是否为偶
        boolean getLast(); 是否最后一个
        bolean getOdd(); 是否为奇
     --%>
    <s:if test="#request.listEmp != null">
        <s:iterator var="emp" value="#request.listEmp" status="st">
            <tr>
                <td><s:property value="#st.count"/></td>
                <td><s:property value="#emp.id"/></td>
                <td><s:property value="#emp.name"/></td>
                <td><s:property value="#emp.salary"/></td>
                <td>
                    <%-- 有多一个空格% {#emp.id}--%>
                    <s:a href="emp_updateView?id=%{#emp.id}">修改</s:a>
                    <s:a href="emp_delete?id=%{#emp.id}">删除</s:a>
                </td>
            </tr>
        </s:iterator>
    </s:if>
    <s:else>
        <tr>
            <td colspan="5">没有你要找的数据，请先录入</td>
        </tr>
    </s:else>

</table>

</form>
</body>
</html>
