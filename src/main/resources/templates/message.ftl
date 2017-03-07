<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Boot 集成Mybatis 连接mysql，实现分页查询</title>
</head>
<body>
<h1>SpringBoot-MySql-Mybatis</h1>
<em>${.now}</em>
<!--如果messages存在，就遍历list集合，取出数据，并且显示在表格中-->
<#if messages?exists>
    <table style="border: 1px solid red; width:500px;">
        <#assign index = 1>
        <#list messages as message>
            <tr <#if index%2 == 0> style="color: red;"</#if>>
                <td>${message.id}</td>
                <td>${message.nickName}</td>
                <td>${message.ip}</td>
                <td>${message.insertDate?date}</td>
            </tr>
            <#assign index = index + 1>
        </#list>
    </table>
</#if>
</body>
</html>