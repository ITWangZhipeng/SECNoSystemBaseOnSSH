<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/15
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QueryAll</title>
</head>
<body>
<h1>显示所有用户信息</h1>
<form action="QueryAllUser.action" method="post">
<s:iterator value="#session.User_list" var="user">
    <tr class="user_list">
        <td><s:property value="#user.WorkId"/></td>
        <td><s:property value="#user.userName"/></td>
        <td><a href="#">删除</a></td><br/>
    </tr>
</s:iterator>
</form>
</body>
</html>