<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/24
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<s:form method="POST" action="admin_login" theme="simple">
    <table align="center" width="60%" cellspacing="0" cellpadding="5" border="1">
        <tr>
            <td>账号</td>
            <td><s:textfield name="name" value=""></s:textfield></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><s:textfield name="password" value="" type="password"></s:textfield></td>
        </tr>
        <tr>
            <td colspan="2"><s:submit value="登录"></s:submit></td>
        </tr>
    </table>
</s:form>
</body>
</html>
