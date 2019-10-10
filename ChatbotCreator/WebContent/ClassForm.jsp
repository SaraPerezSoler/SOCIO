<%@page import="modelInfo.NLAttribute"%>
<%@page import="modelInfo.NLClass"%>
<%@page import="htmlGenerator.Form"%>
<%
	String selectedName = Form.getSelectedName(request, session);
%>


<jsp:useBean id="model" scope="session"
	class="modelInfo.impl.NLModelImpl" />
<%
	NLClass selected = model.getClass(selectedName);
%>
<div class="row justify-content-md-center">
	<div class="col">
		<H1><%=selected.getName()%></H1>
	</div>
</div>
<div class="row">
	<form action="">
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Description</span>
			</div>
			<textarea class="form-control" aria-label="With textarea"><%=selected.getDescription()%></textarea>
		</div>
		<div class="col-auto">
			<input type="checkbox" id="create"
				<%=Form.checked(selected.getCreate())%> name="create" /> <label
				for="create">When users mention objects of this class that
				do not exist, they will be created</label>
		</div>
		<div class="col-auto">
			<input type="checkbox" id="withConteiner"
				<%=Form.checked(selected.isWithContainer())%> name="withConteiner" />
			<label for="withConteiner">Objects of this class cannot be in
				the model without belonging to a container reference</label>
		</div>
		<div class="col-auto">
			<input type="checkbox" id="instantiable"
				<%=Form.checked(selected.isInstantiable())%> name="instantiable" />
			<label for="instantiable"> The chatbot's users can
				instantiate this class, even if it is abstract</label>
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Synonyms (separated with
					commas)</span>
			</div>
			<textarea class="form-control" aria-label="With textarea"><%=Form.getSynonymsString(selected.getSynonyms())%></textarea>
		</div>
		<br>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Create Templates</span>
			</div>
			<textarea class="form-control" aria-label="With textarea"><%=Form.getTemplatesString(selected.getCreateTemplates())%></textarea>
		</div>

		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Delete Templates</span>
			</div>
			<textarea class="form-control" aria-label="With textarea"><%=Form.getTemplatesString(selected.getDeleteTemplates())%></textarea>
		</div>
		<br>
		<h5>Select identifiers attributes</h5>
		<%
			if (selected.getId().get(0) instanceof NLAttribute) {
		%>
		<div class="row">
			<div class="col">
				<input type="radio" name="id" value="Attributes" checked onchange="enable_disable(this.value)"><span
					class="text">Identifiers Attributes</span>
			</div>
			<div class="col">
				<input type="radio" name="id" value="Default" onchange="enable_disable(this.value)"><span
					class="text">Default identifier</span>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col">
				<%
					for (NLAttribute attr : selected.getAllAttribtues()) {
						String checked ="";
						if (selected.getId().contains(attr)){
							checked="checked";
						}
				%>
				<div class="row">
					<div class="col">
						<input type="checkbox" name="AttributesIds" id ="<%= attr.getName()%>"
							value="<%=attr.getName()%>" <%=checked%>><span id ="<%= attr.getName()%>Text" class="text"><%=attr.getName()%></span>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<div class="col"></div>
		</div>
		<%
			} else {
		%>
		<div class="row">
			<div class="col">

				<input type="radio" name="id" value="Attributes" onchange="enable_disable(this.value)"><span
					class="text">Identifiers Attributes</span>
			</div>
			<div class="col">
				<input type="radio" name="id" value="Default" checked onchange="enable_disable(this.value)"><span
					class="text">Default identifier</span>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col">
				<%
					for (NLAttribute attr : selected.getAllAttribtues()) {
				%>
				<div class="row">
					<div class="col">
						<input type="checkbox" name="AttributesIds" id ="<%= attr.getName()%>"
							value="<%=attr.getName()%>" disabled ><span id ="<%= attr.getName()%>Text" class="text text-muted"><%=attr.getName()%></span>
					</div>
				</div>
				<%
					}
				%>
			</div>
			<div class="col"></div>
		</div>
		<%
			}
		%>
		<div class="row">
			<div class="col">
			</div>
			<div class="col">
			<input type="submit" class="btn btn-secondary btn-lg btn-block" value="Save">
			</div>
			<div class="col">
			<input type="submit" class="btn btn-secondary btn-lg btn-block" value="Generate">
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
function enable_disable(value) {
	if (value === "Attributes"){
		<%for (NLAttribute attr : selected.getAllAttribtues()){%>
		document.getElementById("<%=attr.getName()%>").disabled = false;
		document.getElementById("<%=attr.getName()%>Text").classList.remove("text-muted");
		<%}%>
	}else if(value === "Default"){
		<%for (NLAttribute attr : selected.getAllAttribtues()){%>
		document.getElementById("<%=attr.getName()%>").disabled = true;
		document.getElementById("<%=attr.getName()%>Text").classList.add("text-muted");
		<%}%>
	}
}
<!--

//-->
</script>
