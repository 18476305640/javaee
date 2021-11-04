<%--
  Created by IntelliJ IDEA.
  User: 21192
  Date: 2021/11/2
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>用户注册</h1>
    <form method="post" action="${pageContext.request.contextPath}/logon">
        请输入用户名：<input type="text" name="username"> <br/>
        请输入密码： <input type="password" name="password"> <br />
        请选择你的兴趣爱好：
        <label><input type="checkbox" name="hobbys" value="玩游戏">玩游戏</label>
        <label><input type="checkbox" name="hobbys" value="唱歌">唱歌</label>
        <label><input type="checkbox" name="hobbys" value="干饭">干饭</label>
        <button type="submit">提交</button>
    </form>

</body>
</html>
