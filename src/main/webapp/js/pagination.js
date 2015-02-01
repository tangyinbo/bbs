var Pagination = Pagination||{};
Pagination=(function(){
	var settings={
			formName:"pageForm"
	};
	generatorInput=function(page){
		var inputItem = $("<input type='hidden' name='page' value='"+page+"'/>");
		return inputItem;
	}
	formSubmit=function(formName,page){
		var form = $("form[name='"+formName+"']");
		var input =generatorInput(page);
		form.append(generatorInput(page));
		form.submit();
	}
	
	return {
		submit:formSubmit
	}
})();