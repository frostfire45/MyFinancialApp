<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/bank/updateBank"  name="bankUpdateForm">
      <label for="BankName">Bank Name:</label><br>
      <input type="text" id="bankName" name="bankName" value="${bank.getBankName()}"><br>

      <label for="AccountNumber">Account Number:</label><br>
      <input type="text" id="accountNumber" name="accountNumber" value="${bank.getAccountNumber()}"><br>

      <label for="accountType">Account Type:</label><br>
      <select id="type" name="type"><br>
        <option value="Checking">Checking</option>
        <option value="Savings">Savings</option>
      </select><br>
      <label for="Balance">Balance:</label><br>
      <input type="text" id="balance" name="balance" value="${bank.getBalance()}"><br>
      <input type="submit" value="Update Bank" />
      <input type="submit" value="Cancel"/>
    </form>
</body>
</html>