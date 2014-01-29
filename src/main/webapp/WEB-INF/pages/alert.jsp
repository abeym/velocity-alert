<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div>
	<H1>Rule Definition</H1>
	<form:form action="alert-submit.htm" method="POST" modelAttribute="alertForm">
		<form:label path="message">Please enter the Message text that should be sent when this Alert is generated:</form:label>
		<BR/>
		<form:textarea path="message" rows="5" cssStyle="width: 392px; height: 106px;" /> 
		<BR/>

		<form:label path="trigger">When should the Rule be Checked:</form:label>
		<BR/>
		<form:textarea path="trigger" rows="5" cssStyle="width: 392px; height: 106px;" /> 
		<BR/>

		<form:label path="rule">The Rule / Condition that must be true for the ALERT to be sent:</form:label>
		<BR/>
		<form:textarea path="rule" rows="5" cssStyle="width: 392px; height: 106px;" /> 
		<BR/>

		<INPUT TYPE="SUBMIT" VALUE="Submit">
	</form:form>
</div>

<DIV>
    <H1>Converted Rule</H1>
    <BR/>
    Your Rule Converts to :
    <DIV style='width: 392px; height: 106px; border: medium;border-color: black;'>
    	${alertVO.rule}
    </DIV>
    <BR/>
    <%
	%>
    
</DIV>
