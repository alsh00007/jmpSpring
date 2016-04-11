<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>
<h2>Insert order number</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/searchOrder.do" commandName="searchOrderForm">
<form:input type="text" path="orderId"/>
<input type="submit" value="Submit"/>
</form:form>

</body>
</html>