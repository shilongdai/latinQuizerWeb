<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>

<v:main>
	<h3>
		<spring:message code="question.status"
			arguments="${current + 1}, ${count}"></spring:message>
	</h3>
	<p>
		<c:out value="${question.question}"></c:out>
	</p>
	<c:url value="/practice/verb/${current}" var="postUrl"></c:url>
	<form:form action="${postUrl }" method="post" modelAttribute="answer">
		<c:forEach items="${question.choices }" var="i">
			<c:choose>
				<c:when test="${reviewing }">
					<c:choose>
						<c:when test="${question.answer == i && answer.answer == i}">
							<div class="checkbox has-success">
								<label><form:radiobutton path="answer" value="${i}" />
									<c:out value="${i}"></c:out></label>
							</div>
						</c:when>
						<c:when test="${question.answer == i && answer.answer != i}">
							<div class="checkbox has-success disabled">
								<label><form:radiobutton path="answer" value="${i}" />
									<c:out value="${i}"></c:out></label>
							</div>
						</c:when>
						<c:when test="${answer.answer == i && question.answer != i}">
							<div class="checkbox has-error">
								<label><form:radiobutton path="answer" value="${i}" />
									<c:out value="${i}"></c:out></label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="checkbox disabled">
								<label><form:radiobutton path="answer" value="${i}" />
									<c:out value="${i}"></c:out></label>
							</div>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<div class="checkbox">
						<label><form:radiobutton path="answer" value="${i}" /> <c:out
								value="${i}"></c:out></label>
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br>
		<div class="btn-group">
			<c:choose>
				<c:when test="${current == 0 }">
					<a href='<c:url value="/"></c:url>'
						class="btn btn-default disabled"><spring:message
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
</v:main>