<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="/SpringDemo/resource/images/bkg1.png">

 <table align="center" width="600">  
    <tr>  
       <td align="center" colspan="10">  
            <a href="/SpringDemo/page/list.htm?pno=1">首页</a> 
            
<c:choose>
   <c:when test="${myPage.hasPreviousPage }">
   <a href="/SpringDemo/page/list.htm?pno=${myPage.prePage }">上一页</a>
   </c:when>
   
   <c:otherwise> 
   <a href="#">上一页</a>
   </c:otherwise>
</c:choose>

<c:choose>
   <c:when test="${myPage.hasNextPage }">
   <a href="/SpringDemo/page/list.htm?pno=${myPage.nextPage }">下一页</a>
   </c:when>
   <c:otherwise> 
   <a href="#">下一页</a>
   </c:otherwise>
</c:choose>
 <a href="/SpringDemo/page/list.htm?pno=${myPage.totalPage }">末页</a>  
           每页<c:out value="${myPage.pageSize }"/> 条记录  
           共<c:out value="${myPage.rowCount }"/>条记录  
                当前第(
                <bean:write name="myPage" property="currentPage"/><bean:write name="myPage" property="totalPage"/>
                <c:out value="${myPage.currentPage }"/>
                /
                <c:out value="${myPage.totalPage }"></c:out>
                )页  
      </td>  
      </tr>  
    </table>  
    
    
</body>
</html>