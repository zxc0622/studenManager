<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var className = $(this).parent().parent().find("td:first").text();
			var classInfo = "确定要删除   " + className + "  的信息吗?";
			var flag = confirm(classInfo);
			return flag;
		});
	});
</script>
</head>
<body>
    <center>
    <c:if test="${requestScope.page !=null }">
       <c:if test="${!empty requestScope.page.list}">
        <table cellpadding="10" cellspacing="0" border="1">
            <tr><th>班级信息</th><th>删除班级</th></tr>
            <c:forEach items="${requestScope.page.list }" var="classes">
               <tr>
              		 <td>${classes.className }</td>
	                 <td><a class="delete" href="classes?method=deleteClasses&id=${classes.id }" >DELETE</a></td>
               </tr>
            </c:forEach>
        </table>
        <br/>
        <c:if test="${page.hasPre }">
          <a href="classes?pageNo=1">首页</a>
          <a href="classes?pageNo=${page.prePage }">上一页</a>
        </c:if>
        <c:if test="${page.hasNext }">
          <a href="classes?pageNo=${page.nextPage }">下一页</a>
          <a href="classes?pageNo=${page.pageCount }">末页</a>
        </c:if>
        <br/>
        <span>总共:${page.pageCount }页</span>
        <span>当前:${page.pageNo }页</span>
       </c:if>
    </c:if>
	<h4>添加一个班级</h4>
	<form action="${pageContext.request.contextPath }/classes?method=addClasses" method="post">
		<input type="text" name="className" /><br> 
		<input type="submit" value="Submit" />
	</form>
	</center>
</body>
</html>