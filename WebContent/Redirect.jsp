<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String msg = (String)request.getAttribute("msg");
  String url = (String)request.getAttribute("url");
  
  if(msg != null && url != null){
%>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
	window.onload = function() { 
		
		swal({
		     title: "<%=msg%>",
		     text: "",
		     icon: "success", //"info,success,warning,error" 중 택1
		     buttons: ["NO", "YES"]
		}).then((YES) => {
		     if (YES) {
		     /* "YES"클릭시 로직 */
		    	 location.href='<%=request.getContextPath()%><%=url%>';
		     }
		});
		
	}

	</script>
	
<%	  
  }
%>

