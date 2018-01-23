<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>

<v:main>
	<v:verbPractice type="singleTextAnswer">
		<c:forEach items="${question.choices }" var="i">
			<c:choose>
				<c:when test="${reviewing }">
					<c:choose>
						<c:when
							test="${question.answer.answer == i && answer.answer == i}">
							<div class="checkbox has-success">
								<label><form:radiobutton path="answer" value="${i}" />
									<c:out value="${i}"></c:out></label>
							</div>
						</c:when>
						<c:when
							test="${question.answer.answer == i && answer.answer != i}">
							<div class="checkbox has-success disabled">
								<label><form:radiobutton path="answer" value="${i}"
										disabled="true" /> <c:out value="${i}"></c:out></label>
							</div>
						</c:when>
						<c:when
							test="${answer.answer == i && question.answer.answer != i}">
							<div class="checkbox has-error">
								<label><form:radiobutton path="answer" value="${i}" />
									<c:out value="${i}"></c:out></label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="checkbox disabled">
								<label><form:radiobutton path="answer" value="${i}"
										disabled="true" /> <c:out value="${i}"></c:out></label>
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
	</v:verbPractice>
</v:main>