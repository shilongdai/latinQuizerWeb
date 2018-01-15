<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>

<v:main>

	<h1>
		<spring:message code="practice.practice"></spring:message>
	</h1>

	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#1" data-toggle="tab"><spring:message
						code="practice.verb"></spring:message></a></li>
			<li><a href="#2" data-toggle="tab"><spring:message
						code="practice.noun"></spring:message></a></li>
			<li><a href="#3" data-toggle="tab"><spring:message
						code="practice.adjective"></spring:message></a></li>
		</ul>

		<c:set var="postUrl">
			<c:url value="/practice/verb"></c:url>
		</c:set>

		<div class="tab-content ">
			<div class="tab-pane active" id="1">
				<form:form action="${postUrl}" method="post" class="form-horizontal"
					modelAttribute="verbForm">

					<c:set var="amountErrors">
						<form:errors element="span" path="amount" cssClass="help-block" />
					</c:set>

					<c:choose>
						<c:when test="${not empty amountErrors }">
							<div class="form-group has-error">
								<form:label path="amount" cssClass="col-sm-2 control-label">
									<spring:message code="practice.amount"></spring:message>
								</form:label>
								<div class="col-sm-8">
									<form:input cssClass="form-control" path="amount" />
									${amountErrors}
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<form:label path="amount" cssClass="col-sm-2 control-label">
									<spring:message code="practice.amount"></spring:message>
								</form:label>
								<div class="col-sm-8">
									<form:input cssClass="form-control" path="amount"
										placeholder="<spring:message code='practice.amount.placeholder'></spring:message>" />
								</div>
							</div>
						</c:otherwise>
					</c:choose>

					<div class="form-group">
						<div class="checkbox col-sm-offset-2">
							<label> <form:checkbox path="conjugations" value="1" />
								<spring:message code="practice.firstConj"></spring:message>
							</label>
						</div>

						<div class="checkbox col-sm-offset-2">
							<label> <form:checkbox path="conjugations" value="2" />
								<spring:message code="practice.secondConj"></spring:message>
							</label>
						</div>

						<div class="checkbox col-sm-offset-2">
							<label> <form:checkbox path="conjugations" value="3" />
								<spring:message code="practice.thirdOConj"></spring:message>
							</label>
						</div>

						<div class="checkbox col-sm-offset-2">
							<label> <form:checkbox path="conjugations" value="5" />
								<spring:message code="practice.thirdIOConj"></spring:message>
							</label>
						</div>

						<div class="checkbox col-sm-offset-2">
							<label> <form:checkbox path="conjugations" value="4" />
								<spring:message code="practice.fourthConj"></spring:message>
							</label>
						</div>
					</div>
					<form:errors path="conjugations" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-2">
							<div class="btn-group">
								<a href='<c:url value="/"></c:url>' class="btn btn-default"><spring:message
										code="label.cancel"></spring:message></a>
								<button type="submit" class="btn btn-primary">
									<spring:message code="practice.start"></spring:message>
								</button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="tab-pane" id="2">
				<p>UnderConstruction</p>
			</div>
			<div class="tab-pane" id="3">
				<p>under construction</p>
			</div>
		</div>
	</div>
</v:main>