<%@page import="htmlGenerator.Form"%>
<%@page import="modelInfo.NLAttribute"%>
<%String selectedName=Form.getSelectedName(request, session); %>
<jsp:useBean id="model" scope="session"
	class="modelInfo.impl.NLModelImpl" />
	<%NLAttribute selected = model.getAttribute(selectedName); %>
	<div class="row justify-content-md-center">
	<div class="col">
		<H1>Attribute:<%=selected.getName()%></H1>
	</div>
</div>