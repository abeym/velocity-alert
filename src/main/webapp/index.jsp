<div>
	<H1>Rule Definition</H1>
	<FORM ACTION="index.jsp" METHOD="POST">
		Please enter your text:
		<BR>
		<TEXTAREA NAME="rule1" ROWS="5" cols="10"> </TEXTAREA>
		<BR>
		<INPUT TYPE="SUBMIT" VALUE="Submit">
	</FORM>
</div>

<DIV>
    <H1>Converted Rule</H1>
    Your Rule Converts to :
    <BR>
    <%
		String text = request.getParameter("rule1");
		if(text!=null)
		{
			text.replaceAll("\n", "<br/>");
			out.println(text); 
		}
	%>
</DIV>
