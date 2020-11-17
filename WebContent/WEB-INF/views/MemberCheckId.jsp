<%
	if(request.getAttribute("result") == "true"){
		out.print("true");
	}else{
		out.print("false");
	}
%>