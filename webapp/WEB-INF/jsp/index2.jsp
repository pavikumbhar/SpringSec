<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<html>
 <head>
  <title> New Document </title>
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="<c:url value="/resources/js/jquery-1.8.3.min.js" />"></script>
<spring:url value="resources/css/bootstrap.css" var="mainCss" />
	<spring:url value="resources/js/jquery-1.8.3.min.js" var="jqueryJs" />
	<spring:url value="resources/js/main.js" var="mainJs" />

<script type="text/javascript">
  
  $(document).ready(function(){
	      alert('Pravin Kumbhar')
 });
  
  
</script>
<script type="text/javascript">

$(document).ready(function() {
    setTimeout("checkSession();", 60000);

    $("body").mouseup(function () {
        renewSession();
    });

    $("input").blur(function () {
        renewSession();
    });

    $("input").focus(function () {
        renewSession();
    });
});

function checkSession() {
    $.ajax({
        url: "/Account/CheckIfSessionValid",
        type: "POST",
        success: function (result) {
            if (result == "False") {
                window.location = "/Account/LogOff";
            }
        },
        complete: function () {
            setTimeout("checkSession();", 60000);
        }
    });
} 

function renewSession() {
    $.ajax({
        url: "/Account/RenewSession",
        type: "POST",
        data: {
            __RequestVerificationToken: $('input[name=__RequestVerificationToken]').val()
        }
    });
}

</script>


 <script type="text/javascript">
    cdId = 0;
    seconds = 0;
    minutes = 60;
    function countDown(){
       
       if(seconds == 0){
          minutes --;
          seconds = 59;
       }else{
          seconds --;
       }
       self.status = "Time left before Session Timeout: "+minutes+":"+seconds;
    }
    setInterval("countDown()",1000); // calls countDown every 1000 ms (1 s).
 </script>
 </head>

 <body>
  <div>PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPpp</div>
  <p>Timeout in seconds: ${pageContext.session.maxInactiveInterval}</p>
  <%= session.getMaxInactiveInterval() %>
  
 </body>
</html>