<%@ tag language="java" pageEncoding="UTF-8"
        trimDirectiveWhitespaces="true" body-content="scriptless"
        display-name="template" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><c:out value="Latin Quizer"></c:out></title>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!-- Custom CSS -->
    <link href='<c:url value="/resources/css/simple-sidebar.css"></c:url>'
          rel="stylesheet">
    <script type="text/javascript"
            src='<c:url value="/resources/js/custom.js"></c:url>'></script>

    <link href='<c:url value="/resources/css/custom.css"></c:url>'
          rel="stylesheet">
</head>
<body>

<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand"><a href='<c:url value="/"></c:url>'>Latin
                Quizer</a></li>
            <li><a href='<c:url value="/"></c:url>'><span
                    class="glyphicon glyphicon-home"></span> <spring:message
                    code="menu.home"></spring:message></a></li>
            <li><a href='<c:url value="/practice"></c:url>'><span
                    class="glyphicon glyphicon-pencil"></span> <spring:message
                    code="menu.practice"></spring:message></a></li>
            <li><a href='<c:url value="/statistic"></c:url>'><span
                    class="glyphicon glyphicon-list-alt"></span> <spring:message
                    code="menu.statistic"></spring:message></a></li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!--<a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><span
                        class="glyphicon glyphicon-menu-hamburger"></span> Menu</a>-->
                    <jsp:doBody></jsp:doBody>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

</body>
<script>
  $("#menu-toggle").click(function (e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
  });
</script>

</html>

