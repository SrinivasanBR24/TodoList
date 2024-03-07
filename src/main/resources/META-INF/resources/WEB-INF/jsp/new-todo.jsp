		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<H1> Enter todo details </H1> 
	          <form:form method="post" modelAttribute="todo">
	          
	          <fieldset class="mb-3">
	          <form:label path="description">Description </form:label>
	          <form:input type="text" required="required" path="description"/> <br>
	          <form:errors path="description" cssClass="text-warning"/>
	          </fieldset>           
	                        
	                        
	          <fieldset class="mb-3">
	          <form:label path="targetDate">TargetDate </form:label>
	          <form:input type="text" required="required" path="targetDate"/> <br>
	          <form:errors path="targetDate" cssClass="text-warning"/>
	          </fieldset> 
	          
	           <form:input type="hidden"  path="id"/> 
	           
	           <form:input type="hidden"  path="isDone"/> 
	           
	           <input type="submit" value="Submit" class="btn btn-success"> 
	          </form:form>
				
				<p> You can see your <a href="list-todos">todos </a> here </p>
		</div>
		
		
		<%@ include file="common/footer.jspf" %>
		<script type="text/javascript">
		$('#targetDate').datepicker({
		format: 'yyyy-mm-dd',
		});
		</script>