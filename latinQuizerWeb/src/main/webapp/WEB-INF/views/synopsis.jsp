<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>

<v:main>
	<v:verbPractice type="synopsisAnswer">
		<c:forEach var="i" items="${question.tenses}">
			<c:choose>
				<c:when test="${reviewing }">
					<c:choose>
						<c:when test="${question.answer.rows[i] == answer.rows[i]}">
							<div class="form-group has-success">
								<div class="col-xs-3 text-right">
									<form:label path="rows[${i}]" cssClass="control-label">
										<spring:message code="${i }"></spring:message>
									</form:label>
								</div>
								<div class="col-xs-9">
									<form:input path="rows[${i}]" aria-describedby="${i}"
										disabled="true" />
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group has-error">
								<div class="col-xs-3 text-right">
									<form:label path="rows[${i}]" cssClass="control-label">
										<spring:message code="${i }"></spring:message>
									</form:label>
								</div>
								<div class="col-xs-9">
									<form:input path="rows[${i}]" aria-describedby="${i}"
										disabled="true" />
									<span class="help-block"><c:out
											value="${question.answer.rows[i] }"></c:out></span>
								</div>
							</div>

						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<div class="form-group">
						<div class="col-xs-3 text-right">
							<form:label path="rows[${i}]" cssClass="control-label">
								<spring:message code="${i }"></spring:message>
							</form:label>
						</div>
						<div class="col-xs-9">
							<form:input path="rows[${i}]" aria-describedby="${i}" />
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</v:verbPractice>
</v:main>