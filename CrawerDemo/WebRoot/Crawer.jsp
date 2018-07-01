<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="com.chenhongjuan.mavendemo.*"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>千度以下，你就知道</title>
<style type="text/css">
.keywordClass {
	height: 50px;
	width: 450px;
	font-size: 30px;
	color: #06F;
	border-top-width: 0px;
	border-left-width: 0px;
	border-right-width: 0px;
	border-bottom-color: black;
	background-color: #D9D9D9;
}

.bgBtn {
	width: 99px;
	height: 39px;
	border-width: 0px;
	background-image: url(images/bg_btn.png);
}

.container {
	width: 600px;
}

* {
	margin: 0 auto;
}

.head {
	width: 150px;
}

* {
	margin: 0 auto;
}

a {
	color: #F39;
}

#searchDiv {
	position: fixed;
	top: 0px;
	background-color: #D9D9D9;
	width: 600px;
	opacity: 1;
	z-index: 1;
}

#searchResultDiv {
	position: relative;
	top: 140px;
}
</style>
</head>

<body>
	<div class="container">
		<div id="searchDiv">
			<div class="head">
				<font color="white" size="+20">千度</font> <br />
			</div>
			<!-- action='Crawer.jsp' method='post' -->
			<form action="Crawer.jsp" method="post">
				<!--文本输入框架，输入内容-->
				<input class="keywordClass" type='text' name='keyword' />
				<!--按钮-->
				<input class="bgBtn" type='submit' name='search' value="千度一下" />
			</form>
		</div>
		<%-- 调用DAO，获取所有的Blog对象集合 --%>
		<%
			//实现汉字的转码--只能解决post方式提交的数据
			request.setCharacterEncoding("UTF-8");
			//获取keyword输入框中的数值
			String name = request.getParameter("keyword");
			TencentPositionDao dao = new TencentPositionDaoImpl();
			// 调用根据条件查询的方法
			List<TencentPosition> list = dao.searchByName(name);//dao.searchAll();
		%>

		<div id="searchResultDiv">

			<%
				for (TencentPosition p : list) {
			%>
			<div class="searchItem">
				<!--标题链接-->
				<a href="<%=p.getPositionLink()%>" target="_blank"><%=p.getPositionName()%></a><br />
				<!--简介-->
				标题：<%=p.getPositionName()%><br /> 数量:<%=p.getPositionNum()%><br />
				类型:<%=p.getPositionType()%><br /> 发布时间:<%=p.getPublishTime()%>
			</div>
			<br />
			<%
				}
			%>

		</div>
	</div>
</body>
</html>
