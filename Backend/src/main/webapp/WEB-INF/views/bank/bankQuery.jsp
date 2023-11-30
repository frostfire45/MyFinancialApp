<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix = "mfa" %>
<html>
    <mfa:header/>
    <body>
        <mfa:myNav/>
        <h2>These are your banks</h2>
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
        </table>
        <script>
            function updateBtnFunction(id){
                var text = id.id;
                var textArray = text.split(".");
                var url = "/bank/updateBank/";
                window.location.href = url.concat(textArray[0]);
            }
            function deleteBtnFunction(id){
                var text = id.id;
                var textArray = text.split(".");
                var url = "/bank/deleteBank/";
                window.location.href = url.concat(textArray[0]);
            }
            /*function post(path, params, method='post') {

              // The rest of this code assumes you are not using a library.
              // It can be made less verbose if you use one.
              const form = document.createElement('form');
              form.method = method;
              form.action = path;

              for (const key in params) {
                if (params.hasOwnProperty(key)) {
                  const hiddenField = document.createElement('input');
                  hiddenField.type = 'hidden';
                  hiddenField.name = key;
                  hiddenField.value = params[key];

                  form.appendChild(hiddenField);
                }
              }
            */
        </script>
    </body>
</html>