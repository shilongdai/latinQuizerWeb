<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>

<v:main>
	<v:verbPractice type="singleTextualAnswer">
		<div class="funkyradio">
			<c:forEach items="${question.choices }" var="i" varStatus="theCount">
				<c:choose>
					<c:when test="${reviewing }">
						<c:choose>
							<c:when
								test="${question.answer.answer == i && answer.answer == i}">
								<div class="funkyradio-success">
									<form:radiobutton path="answer" value="${i}" />
									<label for="answer${theCount.count}"> <c:out
											value="${i}"></c:out></label>
								</div>
							</c:when>
							<c:when
								test="${question.answer.answer == i && answer.answer != i}">
								<div class="funkyradio-success">
									<form:radiobutton path="answer" value="${i}" disabled="true" />
									<label class="bg-success" for="answer${theCount.count}">
										<c:out value="${i}"></c:out>
									</label>
								</div>
							</c:when>
							<c:when
								test="${answer.answer == i && question.answer.answer != i}">
								<div class="funkyradio-danger">
									<form:radiobutton path="answer" value="${i}" checked="true" />
									<label for="answer${theCount.count}"> <c:out
											value="${i}"></c:out></label>
								</div>
							</c:when>
							<c:otherwise>
								<div class="funkyradio-default">
									<form:radiobutton path="answer" value="${i}" disabled="true" />
									<label for="answer${theCount.count}"> <c:out
											value="${i}"></c:out></label>
								</div>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<div class="funkyradio-default">
							<form:radiobutton path="answer" value="${i}" />
							<label for="answer${theCount.count}"> <c:out value="${i}"></c:out></label>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</v:verbPractice>
	<br>
	<c:if test="${reviewing}">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse1"><spring:message
								code="question.multipleChoice.steps"></spring:message></a>
					</h4>
				</div>

				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						<c:forEach var="i" items="${question.steps}">
							<p>
								<spring:message code="${i.left }" arguments="${i.middle}"></spring:message>
							</p>
							<blockquote>
								<b>${i.right}</b>
							</blockquote>
							<br>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>
	</c:if>
</v:main>