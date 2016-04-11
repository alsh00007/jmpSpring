<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>
<h2>Select event</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/addOrder.do" commandName="orderForm">
<table>

<tr>
<td>Select event</td>
<td>
<form:select path="eventId">
 <form:options items="${orderForm.events}" />
 </form:select>
</td>
</tr>
<tr>
<td>
 <input type="submit" value="Submit"/>
</td>
</tr>

</table>
</form:form>



</body>
</html>

