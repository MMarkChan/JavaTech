<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="resource/upload.htm" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>标题</td>
<td><input type="text" name="titleName"></td>
</tr>
<tr>
<td>描述</td>
<td><input type="text" name="description"></td>
</tr>
<tr>
<td>分值</td>
<td><input type="text" name="score" ></td>
</tr>
<tr>
<td>分类</td>
<td>
<select name="classfyID">
<option>11</option>
<option>2</option>
<option>33</option>
<option>44</option>
</select>
</td>
</tr>
<tr>
<td>上传文件</td>
<td><input type="file" name="file"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="提交"></td>
</tr>
</table>
</form>
</body>
</html>