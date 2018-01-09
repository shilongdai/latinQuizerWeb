<%@ tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" body-content="scriptless"
	display-name="template"%><%@ taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><c:out value="Latin Quizer"></c:out></title>

<!-- Bootstrap Core CSS -->
<link href='<c:url value="/resources/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">


<!-- Custom CSS -->
<link href='<c:url value="/resources/css/simple-sidebar.css"></c:url>'
	rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery -->
<script src='<c:url value="/resources/js/jquery-2.2.4.min.js"></c:url>'></script>

<!-- Bootstrap Core JavaScript -->
<script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/Chart.bundle.min.js"></c:url>'></script>
</head>
<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a
					href='<c:url value="/"></c:url>'>Latin Quizer</a></li>
				<li><a href='<c:url value="/"></c:url>'><span
						class="glyphicon glyphicon-home"></span> <spring:message code="menu.home"></spring:message></a></li>
				<li><a href='<c:url value="/practice"></c:url>'><span
						class="glyphicon glyphicon-pencil"></span> <spring:message code="menu.practice"></spring:message></a></li>
				<li><a href='<c:url value="/statistic"></c:url>'><span
						class="glyphicon glyphicon-list-alt"></span> <spring:message code="menu.statistic"></spring:message></a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<jsp:doBody></jsp:doBody>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>

</html>

