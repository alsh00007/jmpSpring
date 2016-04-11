<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
Enter date (yyyy-MM-dd):
<form:form method="POST" action="${pageContext.request.contextPath}/searchEvent.do" commandName="searchEventForm">
<input type="text" path="dueDate" class= "date" name = "day" value = "<fmt:formatDate value="${searchEventForm.day}" pattern="yyyy-MM-dd" />"/>
 <input type="submit" value="Submit"/>
</form:form>


<div>
<a href="${pageContext.request.contextPath}/showOrder.do">Show order</a>
</div>

<div>
<a href="${pageContext.request.contextPath}/showOrders.do">Show orders</a>
</div>

<div>
<a href="${pageContext.request.contextPath}/selectDeletionOrder.do">Delete order</a>
</div>


</body>
</html>



