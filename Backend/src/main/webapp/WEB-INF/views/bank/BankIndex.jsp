<%@ page import="com.frostfire.myfinancialapp.model.Bank" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: d.huskey
  Date: 12/19/2023
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix = "mfa" %>
<html>
    <body>
        <mfa:header/>
        <mfa:myNav/>
        <form method="post">
            Bank Name
            <input type="text" name="bankName" value="${bankName}" />
            <input type="submit" value="Query" />
        </form><br><br>
        <button type="button" height="100" width="200" /><a href=/bank/addNewBank>New Bank </a></button>
        <table>
            <tr>
                <th>Name</th>
                <th>Account Num</th>
                <th>Type</th>
                <th>Balance</th>
            </tr>
        <c:if test="${banks} != null">
            <c:forEach var="bank" items="${banks}" >
            <tr id="${bank.getId()}">
                <td id="${bank.getId()}.name">${bank.getBankName()}</td>
                <td id="${bank.getId()}.accountNumber">${bank.getAccountNumber()}</td>
                <td id="${bank.getId()}.type">${bank.getType()}</td>
                <td id="${bank.getId()}.balance">${bank.getBalance()}</td>
                <td>
                        <span>
                            <button id="${bank.getId()}.updateBtn" type="button" onclick="updateBtnFunction(this)">Update</button>
                            <button id="${bank.getId()}.deleteBtn" type="button" onclick="deleteBtnFunction(this)">Delete</button>
                       </span>
            </tr>
            </c:forEach>
        </c:if>
        <p>Outside</p>

    </body>
</html>
