<div>
	<H1>Rule Definition</H1>
	<FORM ACTION="index.jsp" METHOD="POST">
		Please enter your text:
		<BR/>
		<TEXTAREA NAME="rule1" ROWS="5" style="width: 392px; height: 106px;"> </TEXTAREA>
		<BR>
		<INPUT TYPE="SUBMIT" VALUE="Submit">
	</FORM>
</div>

<DIV>
    <H1>Converted Rule</H1>
    Your Rule Converts to :
    <BR/>
    <%
		String text = request.getParameter("rule1");
		if(text!=null)
		{
			text.replaceAll("\n", "<br/>");
			out.println("<div style='width: 392px; height: 106px; border: medium;border-color: black;'>");
			out.println(text); 
			out.println("</div>");
		}
	%>
    
</DIV>

<h1>Message : ${message}</h1>
