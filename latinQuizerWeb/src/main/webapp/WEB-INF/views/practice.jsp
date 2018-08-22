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
		</ul>

		<c:set var="postUrl">
			<c:url value="/practice/verb"></c:url>
		</c:set>

		<div class="tab-content ">
			<div class="tab-pane active" id="1">
				<form:form action="${postUrl}" method="post" class="form-horizontal"
					modelAttribute="verbForm">

					<div class="form-group">
						<form:label path="amount" cssClass="col-sm-2 control-label">
							<spring:message code="practice.amount"></spring:message>
						</form:label>
						<div class="col-sm-8">
							<form:input cssClass="form-control" path="amount"
								placeholder="<spring:message code='practice.amount.placeholder'></spring:message>" />
						</div>
					</div>

					<div class="panel-group" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse1"> <spring:message
											code="practice.conjugation"></spring:message></a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse in">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="conjugations" value="1" />
												<spring:message code="practice.firstConj"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="conjugations" value="2" />
												<spring:message code="practice.secondConj"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="conjugations" value="3" />
												<spring:message code="practice.thirdOConj"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="conjugations" value="5" />
												<spring:message code="practice.thirdIOConj"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="conjugations" value="4" />
												<spring:message code="practice.fourthConj"></spring:message>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse2"> <spring:message code="practice.tense"></spring:message></a>
								</h4>
							</div>
							<div id="collapse2" class="panel-collapse collapse">
								<div class="panel-body">

									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="tenses" value="PRESENT" />
												<spring:message code="PRESENT"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="tenses"
													value="IMPERFECT" /> <spring:message code="IMPERFECT"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="tenses" value="FUTURE" />
												<spring:message code="FUTURE"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="tenses" value="PERFECT" />
												<spring:message code="PERFECT"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="tenses"
													value="FUTURE_PERFECT" /> <spring:message
													code="FUTURE_PERFECT"></spring:message>
											</label>
										</div>

										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="tenses"
													value="PLUPERFECT" /> <spring:message code="PLUPERFECT"></spring:message>
											</label>
										</div>
									</div>

								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse3"> <spring:message code="practice.mood"></spring:message></a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="moods"
													value="INDICATIVE" onchange="disableNonSub()" /> <spring:message
													code="INDICATIVE"></spring:message>
											</label>
										</div>
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="moods"
													value="SUBJUNCTIVE" onchange="disableNonSub()" /> <spring:message
													code="SUBJUNCTIVE"></spring:message>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse4"> <spring:message code="practice.voice"></spring:message></a>
								</h4>
							</div>
							<div id="collapse4" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="voices" value="ACTIVE" />
												<spring:message code="ACTIVE"></spring:message>
											</label>
										</div>
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="voices" value="PASSIVE" />
												<spring:message code="PASSIVE"></spring:message>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse5"> <spring:message code="practice.type"></spring:message></a>
								</h4>
							</div>
							<div id="collapse5" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="types" value="REGULAR"
													onchange="disablePassive()" /> <spring:message
													code="REGULAR"></spring:message>
											</label>
										</div>
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="types" value="DEPONENT"
													onchange="disablePassive()" /> <spring:message
													code="DEPONENT"></spring:message>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse6"> <spring:message
											code="practice.questionType"></spring:message></a>
								</h4>
							</div>
							<div id="collapse6" class="panel-collapse collapse">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="questionTypes"
													value="MULTIPLE_CHOICE" /> <spring:message
													code="MULTIPLE_CHOICE"></spring:message>
											</label>
										</div>
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="questionTypes"
													value="SYNOPSIS" onchange="disablePassive()" /> <spring:message
													code="SYNOPSIS"></spring:message>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<form:errors path="conjugations" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>

					<form:errors path="tenses" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>

					<form:errors path="voices" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>

					<form:errors path="moods" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>

					<form:errors path="amount" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>

					<form:errors path="types" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>


					<button type="submit" class="btn btn-primary">
						<spring:message code="practice.start"></spring:message>
					</button>

				</form:form>
			</div>

			<c:set var="postNounUrl">
				<c:url value="/practice/noun"></c:url>
			</c:set>

			<div class="tab-pane" id="2">
				<span>Under Construction...</span>
				<form:form action="${postNounUrl}" method="post"
					class="form-horizontal" modelAttribute="nounForm">
					<div class="form-group">
						<form:label path="amount" cssClass="col-sm-2 control-label">
							<spring:message code="practice.amount"></spring:message>
						</form:label>
						<div class="col-sm-8">
							<form:input cssClass="form-control" path="amount"
								placeholder="<spring:message code='practice.amount.placeholder'></spring:message>" />
						</div>
					</div>

					<div class="panel-group" id="accordionNoun">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordionNoun"
										href="#noun1"> <spring:message code="practice.declension"></spring:message></a>
								</h4>
							</div>
							<div id="noun1" class="panel-collapse collapse in">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="declensions" value="0" />
												<spring:message code="practice.firstDec"></spring:message>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordionNoun"
										href="#noun2"> <spring:message code="practice.gender"></spring:message></a>
								</h4>
							</div>
							<div id="noun2" class="panel-collapse collapse in">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="genders" value="F" />
												<spring:message code="GENDER_F"></spring:message>
											</label>
										</div>
										
									</div>
								</div>
							</div>
						</div>
						
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordionNoun"
										href="#noun3"> <spring:message code="practice.type"></spring:message></a>
								</h4>
							</div>
							<div id="noun3" class="panel-collapse collapse in">
								<div class="panel-body">
									<div class="form-group">
										<div class="checkbox checkbox_left_margin">
											<label> <form:checkbox path="types" value="REGULAR" />
												<spring:message code="REGULAR"></spring:message>
											</label>
										</div>
										
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<form:errors path="amount" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>
					
					<form:errors path="declensions" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>
					
					<form:errors path="genders" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>
						
					<form:errors path="types" element="div"
						cssClass="alert alert-danger alert-dismissible"></form:errors>
					
					<button type="submit" class="btn btn-primary">
						<spring:message code="practice.start"></spring:message>
					</button>
				</form:form>
			</div>
		</div>
	</div>
</v:main>