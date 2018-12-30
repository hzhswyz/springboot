<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/hzh/upload" method="post" enctype="multipart/form-data">
    <input name="file" type="file"/>
    <input type="submit">
</form>
</body>
</html>