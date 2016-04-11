<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>

<form:form method="POST" action="${pageContext.request.contextPath}/submitOrder.do" commandName="orderForm">
<table>

<tr>
<td>Select place</td>
<td>
      <form:select path="place" items="${orderForm.freePlaces}">
         </form:select></ul>
</tr>


<tr>
<td>Select user</td>
<td>
        <form:select path="userId" items="${orderForm.users}">
         </form:select></ul>
</td>
</tr>

<tr>
<td>
<form:hidden path="eventId" />
</td>
<td>
 <input type="submit" value="Submit"/>
</td>

</tr>

</table>
</form:form>


</body>
</html>
