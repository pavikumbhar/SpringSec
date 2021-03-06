<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
     <link href="resources/css/bootstrap.css" rel="stylesheet">
    <script src="<c:url value="resources/js/bootstrap.js" />"></script>
    <spring:url value="resources/js/jquery-1.8.3.min.js" var="jqueryJs" />
    <script src="${jqueryJs}"></script>
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
        <title>Login Page</title>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 350px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>
        
        
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.ui.touch-punch.min.js"></script>
    <script class="include" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="resources/js/common-scripts.js"></script>

    <!--script for this page-->
    
    </head>
    <body onload='document.loginForm.username.focus();'>


        <div id="login-box">

            <h2>Login with Username and Password</h2>

            <c:if test="${param.error eq 'true'}">
                <div class="error">
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}" />
                </div>
            </c:if>

            <form name='loginForm'
                  action="login" method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='username' ></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'>
                            <input name="submit" type="submit" value="submit" />
                        </td>
                    </tr>
                </table>

                <input type="hidden"
                       name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>

    </body>
</html>