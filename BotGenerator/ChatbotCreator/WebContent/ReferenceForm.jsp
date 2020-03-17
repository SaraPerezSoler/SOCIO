<%@page import="htmlGenerator.Form"%>
<%@page import="modelInfo.NLReference"%>
<%String selectedName=Form.getSelectedName(request, session); %>
<jsp:useBean id="model" scope="session"
	class="modelInfo.impl.NLModelImpl" />
	<%NLReference selected = model.getReference(selectedName); %>
	
	<div class="row justify-content-md-center">
	<div class="col">
		<H1>Reference: <%=selected.getName()%></H1>
	</div>
</div>