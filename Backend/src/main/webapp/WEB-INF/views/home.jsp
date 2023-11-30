<<<<<<< HEAD
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mfa" %>
=======
>>>>>>> d005570 (Adding stuff worked on from house)
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <title>Home page</title>
    </head>
   <body>
    <mfa:myNav/><br>
       <div>
          <h1>Hit Home</h1>
           <h2>Columns</h2>
       </div>
<<<<<<< HEAD

=======
       <c:if test="${not empty banks}">
           <h2>Columns</h2>
           <c:forEach var="bank" items="${banks}">
               <ul>
                 <li>${bank.name}</li>
                 <li>${bank.accountNumber}</li>
                 <li>${bank.accountType}</li>
                   <li>${bank.balance}</li>
               </ul>
           </c:forEach>
       </c:if>
>>>>>>> d005570 (Adding stuff worked on from house)
   </body>
</html>