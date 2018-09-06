<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib
        prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib
        prefix="v" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib
        prefix="spring" uri="http://www.springframework.org/tags" %>

<v:main>
    <v:practice type="synopsisAnswer">
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
                                                disabled="true"/>
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
                                                disabled="true"/>
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
                            <form:input path="rows[${i}]" aria-describedby="${i}"/>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </v:practice>
    <c:if test="${reviewing }">
        <h4>
            <spring:message code="question.multipleChoice.steps"></spring:message>
        </h4>
        <c:forEach items="${question.tenses}" var="i">
            <div class="panel-group">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" href="#collapse${i}"><spring:message
                                    code="${i}"></spring:message></a>
                        </h4>
                    </div>

                    <div id="collapse${i}" class="panel-collapse collapse">
                        <div class="panel-body">
                            <c:forEach var="i" items="${question.steps[i]}">
                                <p>
                                    <spring:message code="${i.left }"
                                                    arguments="${i.middle}"></spring:message>
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
        </c:forEach>
    </c:if>
</v:main>