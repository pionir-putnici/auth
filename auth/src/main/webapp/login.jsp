<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<body>

<div class="container">
	<div class='row'>
	<div class='col-lg-4 col-lg-offset-4'>
    <form method="POST" action="${contextPath}/login" class="login-form">
    <div class='row'>
	    <div class='col-lg-12 login-form-heading'>
	        <h2 class="form-heading">Log in</h2>
	    </div>
	</div>
	<div class='row'>
	<div class='col-lg-12'>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control login-form-text-input" placeholder="user"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control login-form-text-input" placeholder="user"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block login-form-button" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
    </div>
	</div>
    </form>
    </div>
	</div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
