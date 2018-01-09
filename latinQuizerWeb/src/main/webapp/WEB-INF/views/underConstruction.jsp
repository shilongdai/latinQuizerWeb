<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ taglib
	prefix="v" tagdir="/WEB-INF/tags"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<v:main>
	<h1>
		<spring:message code="underconstruction"></spring:message>
	</h1>

	<p>
		<spring:message code="redirecting"></spring:message>
		<span id="timer">5</span>
		<script>
			window.setInterval(function() {
				var txt = $("#timer").text();
				if (txt == 0) {
					window.location.replace("<c:url value='/'></c:url>");
				}
				$("#timer").html(txt - 1);
			}, 1000);
		</script>
	</p>
</v:main>