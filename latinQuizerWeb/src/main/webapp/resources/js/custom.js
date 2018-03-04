/**
 * 
 */

function disablePassive() {
	if($("#types2").is(":checked") && !$("#types1").is(":checked")) {
		$("#voices2").prop("checked", false);
		$("#voices2").prop("disabled", true);
	} else {
		$("#voices2").prop("disabled", false);
	}
}

function disableNonSub(){
	if($("#moods2").is(":checked") && !$("#moods1").is(":checked")) {
		
		$("#tenses3").prop("checked", false);
		$("#tenses3").prop("disabled", true);
		
		$("#tenses5").prop("checked", false);
		$("#tenses5").prop("disabled", true);
	} else {
		$("#tenses3").prop("disabled", false);
		$("#tenses5").prop("disabled", false);
	}
}