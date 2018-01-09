<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<v:main>
	<h1>
		<spring:message code="practice.report"></spring:message>
	</h1>

	<div class="text-center col-sm-8 col-sm-offset-2">
		<div class="table-responsive">
			<table class="table">
				<tbody>
					<tr>
						<th><spring:message code="practice.report.total"></spring:message></th>
						<td><c:out value="${report.total }"></c:out></td>
					</tr>
					<tr>
						<th><spring:message code="practice.report.correct"></spring:message>:</th>
						<td><c:out value="${report.correct }"></c:out></td>
					</tr>
					<tr>
						<th><spring:message code="practice.report.incorrect"></spring:message></th>
						<td><c:out value="${report.incorrect }"></c:out></td>
					</tr>
					<tr>
						<th><spring:message code="practice.report.score"></spring:message></th>
						<td><c:out value="${report.score }"></c:out></td>
					</tr>
					<tr>
						<th><spring:message code="practice.report.time"></spring:message></th>
						<td><c:out value="${report.time }"></c:out></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn-group">
			<a href='<c:url value="/practice"></c:url>' class="btn btn-default"><spring:message
					code="practice.report.return"></spring:message></a> <a
				href='<c:url value="/practice/verb/0"></c:url>'
				class="btn btn-primary"><spring:message
					code="practice.report.review"></spring:message></a>
		</div>
	</div>

</v:main>