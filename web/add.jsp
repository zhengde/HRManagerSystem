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
    <title>添加员工信息页面</title>
</head>
<body>
<%-- 信息录入点击提交之后,跳转到save方法--%>
<s:form action="emp_save" method="post" theme="simple">
    <table align="center" cellpadding="5" cellspacing="0" border="1" width="40%">
        <tr>
            <td>员工姓名</td>
            <td>
                    <%--name是Employee类中定义的属性名--%>
                <s:textfield id="name" name="employee.name" value="" ></s:textfield>
            </td>
        </tr>
        <tr>
            <td>员工薪水</td>
            <td>
                <s:textfield id="salary" name="employee.salary" value=""></s:textfield>
            </td>
        </tr>
        <tr>
            <td>员工部门</td>
            <td>
                <s:select list="#request.deptList" headerKey="-1" headerValue="请选择部门"
                          name="deptId" value="-1" listKey="id" listValue="name">
                </s:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <s:submit action="emp_save" value="添加员工"></s:submit>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
