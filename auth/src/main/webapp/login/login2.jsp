<!DOCTYPE HTML>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>Login2</title>
    <!-- Bootstrap Core CSS -->
    <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/static/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
	<link rel="stylesheet" href="/static/css/style.css">
	<link rel='stylesheet' href='/static/login/login.css' type='text/css' />
	
</head>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!--     <meta charset="utf-8"> -->
<!-- <title>Login</title> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->
<!-- <link rel='stylesheet' href='login.css' type='text/css' /> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script> -->
<!-- </head> -->

<body class='background-image'>
    <section id='credential-container' class='blured-content'>
        <div class='container blured'>
            <div class='row'>
                <div class='col-xs-6 col-xs-offset-3' style='height:350px;' id='credential-form'>                    
                    <div class='row'>
                        <div class='col-lg-12' id='credential-form-title'>
                            <h1>Evidencija ambalaze</h1>
                            <h3>Pionir d.o.o. Subotica</h3>
                        </div>
                    </div>
                    <div class='row'>
                        <div class='col-lg-12' id='credential-form-fields'>
                            <form method='POST' action="/login/login2">
                                <input type='text' name='username' placeholder='Username...' />
                                <input type='password' name='password' placeholder='Password...' />
                                <input type='submit' name='' value='Login' />
                                <input type='reset' name='' value='Reset' />
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    
</body>
</html>