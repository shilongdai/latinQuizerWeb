<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<v:main>
	<h1>
		<spring:message code="menu.home"></spring:message>
	</h1>

	<p>
		<spring:message code="home.intro"></spring:message>
	</p>
	<p>
		<spring:message code="home.amount" arguments="${size }"></spring:message>
	</p>
	<br>
	<a class="btn btn-primary btn-large"
		href='<c:url value="/practice"></c:url>'><span
		class="glyphicon glyphicon-pencil"></span> <spring:message
			code="home.practiceNow"></spring:message></a>
</v:main>