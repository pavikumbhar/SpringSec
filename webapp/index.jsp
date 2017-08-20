<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
  <title> New Document </title>
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/jquery.js"></script>

  
  <script type="text/javascript">
  
  $(document).ready(function(){
	      alert('Pravin Kumbhar')
 });
  
  
  </script>
  
  
  
  
  
  
  
  
  
  
  <script type="text/javascript">
    var timeoutHandle = null;
    function startTimer(timeoutCount) {
        if (timeoutCount == 0) {
            window.location.href = 'logout.jsp';
        } else if (timeoutCount < 3) {
            document.getElementById('sessionTimer').innerHTML = 'You have ' + (timeoutCount * 3000)/1000 + 'seconds until timeout' ;
        }
        timeoutHandle = setTimeout(function () { startTimer(timeoutCount-1);}, '3000');
    }
    function refreshTimer() {
        killTimer(timeoutHandle);
        startTimer(3);
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

 <body onload="startTimer(3)">
  <div id="sessionTimer"></div>
  <p>Timeout in seconds: ${pageContext.session.maxInactiveInterval}</p>
  <%= session.getMaxInactiveInterval() %>
  
 </body>
</html>