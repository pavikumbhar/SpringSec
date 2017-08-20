<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
   
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <!--external css-->
 
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <!-- Custom styles for this template -->

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/style-responsive.css" rel="stylesheet" type="text/css"/>
   

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
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
                /* padding: 20px; */
                 margin: 50px auto; 
               /*  background: #fff; */
               /*  -webkit-border-radius: 2px;
                -moz-border-radius: 2px; */
               /*  border: 1px solid #000; */
            }
        </style>
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      
      *********************************************************************************************************************************************************** -->
    <div id="login-box">
	     	<c:if test="${param.error eq 'true'}">
                <div class="error">
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}" />
                </div>
            </c:if>
    </div>
	  <div id="login-page">
	  	<div class="container">
	  	  
	  	 
               <form:form  method="POST" cssClass="form-login" action="${pageContext.request.contextPath}/login">
                   
		        <h2 class="form-login-heading">sign in now </h2>
		        <div class="login-wrap">
		            <input type='text' name='username'  class="form-control" placeholder="User Name" autofocus>
		            <br>
		            <input type='password' name='password'  class="form-control" placeholder="Password">
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" href="home" type="submit"><i class="fa fa-lock"></i> SIGN IN</button>
		            <hr>
		            <input type="hidden"
                       name="${_csrf.parameterName}" value="${_csrf.token}" />
		            <div class="login-social-link centered">
		            <p>or you can sign in via your social network</p>
		                <button class="btn btn-facebook" type="submit"><i class="fa fa-facebook"></i> Facebook</button>
		                <button class="btn btn-twitter" type="submit"><i class="fa fa-twitter"></i> Twitter</button>
		            </div>
		            <div class="registration">
		                Don't have an account yet?<br/>
		                <a class="" href="#">
		                    Create an account
		                </a>
		            </div>
		
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Enter your e-mail address below to reset your password.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div> 
                                      <div class="modal-body">
		                          <p>Enter your e-mail address below to reset your password.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="btn btn-theme" type="button">Submit</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		          
                        
          </form:form>
		   	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    
    <script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js" type="text/javascript"></script>
    <script>
        $.backstretch("${pageContext.request.contextPath}/resources/img/Screenshot.png", {speed: 500});
    </script>


  </body>
</html>
