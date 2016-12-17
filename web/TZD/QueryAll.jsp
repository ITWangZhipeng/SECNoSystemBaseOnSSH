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
<h1>显示所有通知单信息</h1>
<form action="QueryAllTZD.action" method="post">
    <s:iterator value="#session.TZD_list" var="tzd">
        <tr class="TZD_list">
            <td><s:property value="#tzd.department"/></td>
            <td><s:property value="#tzd.year"/></td>
            <td><s:property value="#tzd.tid"/></td>
            <td><s:property value="#tzd.content"/></td>
            <td><a href="#">删除</a></td><br/>
        </tr>
    </s:iterator>
</form>
</body>
</html>