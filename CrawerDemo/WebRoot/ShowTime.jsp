<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取此刻的时间</title>
</head>
<body>
	<%--怎么写java代码 --%>
	<%-- java脚本，任何的java语句--%>
	<%
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(date);
	%>
	<%--怎么显示java处理后的结果 --%>
	<!-- java表达式 -->
	<%="现在的时间是：" + dateStr%>
	<br />
	<!-- out输出 -->
	<%
		out.println("现在的年-月-日 时：分：秒:" + dateStr);
	%>
</body>
</html>