<%@ tag language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" body-content="scriptless"
	display-name="template"%><%@ attribute name="type"
	type="java.lang.String" rtexprvalue="true" required="true"%><%@ taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="question.status"
		arguments="${current + 1}, ${count}"></spring:message>
</h3>
<p>
	<c:out value="${question.question}"></c:out>
</p>
<c:url value="/practice/verb/${current}/${type}" var="postUrl"></c:url>
<form:form action="${postUrl }" method="post" modelAttribute="answer">
	<jsp:doBody></jsp:doBody>
	<br>
	<div class="btn-group">
		<c:choose>
			<c:when test="${current == 0 }">
				<a href='<c:url value="/"></c:url>' class="btn btn-default disabled"><spring:message
						code="question.prev"></spring:message></a>
			</c:when>
			<c:otherwise>
				<a href='<c:url value="/practice/verb/${current-1}"></c:url>'
					class="btn btn-default"><spring:message code="question.prev"></spring:message></a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${current == count-1 }">
				<button type="submit" class="btn btn-primary">
					<spring:message code="question.done"></spring:message>
				</button>
			</c:when>
			<c:otherwise>
				<button type="submit" class="btn btn-primary">
					<spring:message code="question.next"></spring:message>
				</button>
			</c:otherwise>
		</c:choose>
	</div>
</form:form>