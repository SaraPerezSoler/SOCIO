<%@page import="htmlGenerator.Configurator"%>
<%@page import="java.util.List"%>
<%@page import="modelInfo.NLAttribute"%>
<%@page import="modelInfo.NLIdentifier"%>
<%@page import="modelInfo.NLFeature"%>
<%@page import="modelInfo.DefaultId"%>
<%@page import="modelInfo.NLClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>

	<jsp:useBean id="model" scope="session"
		class="modelInfo.impl.NLModelImpl" />
	<jsp:useBean id="content_page" scope="session" class="java.lang.String" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-4">
				<ul>
					<%
						for (NLClass nlClass : model.getClasses()) {
					%>
					<li><input type="button"
						id="<%=Configurator.getNLClassId(nlClass)%>"
						onclick="changeSelected(this.id)"
						value="<%=Configurator.getNLClassName(nlClass)%><%=Configurator.getSuperClass(nlClass.getSuper())%>"
						class="btn btn-light <%if (nlClass.getClass_().isAbstract()) {%>cursiva<%}%>">
					<%
						if (!(nlClass.getFeatures().isEmpty() && nlClass.getId().get(0) instanceof DefaultId)) {
					%>
					
						<ul>
							<%
								for (NLIdentifier id : nlClass.getId()) {
											if (id instanceof NLAttribute) {
												NLAttribute attribute = (NLAttribute) id;
							%>
							<li><input type="button"
								id="<%=Configurator.getNLFeatureId(attribute)%>"
								onclick="changeSelected(this.id)"
								value="<%=Configurator.getNLFeature(attribute)%> (ID)"
								class="btn btn-light"></li>

							<%
								}
										}
							%>

							<%
								for (NLFeature nlFeature : nlClass.getFeatures()) {
							%>
							<li><input type="button"
								id="<%=Configurator.getNLFeatureId(nlFeature)%>"
								onclick="changeSelected(this.id)"
								value="<%=Configurator.getNLFeature(nlFeature)%>"
								class="btn btn-light"></li>
							<%
								}
							%>
						</ul>
					<%
						}
						}
					%>


				</ul>
			</div>
			<div class="col justify-content-md-center"
				id="ConfiguratorCenter">
				<jsp:include page="<%=content_page%>" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function changeSelected(clicked_id) {
		var jsp ="";
		var queryStr = "selectedName="
		if (clicked_id.startsWith("Class:")){
			clicked_id = clicked_id.replace("Class:", "");
			jsp = "ClassForm.jsp";
		}else if (clicked_id.startsWith("Attribute:")){
			clicked_id = clicked_id.replace("Attribute:", "");
			jsp = "AttributeForm.jsp";
		}else if (clicked_id.startsWith("Reference:")){
			clicked_id = clicked_id.replace("Reference:", "");
			jsp="ReferenceForm.jsp";
			
		}
		xmlhttpPost(jsp, queryStr+clicked_id);  
	}
	
	function xmlhttpPost(strURL, queryStr) {
	    var xmlHttpReq = false;
	    var self = this;
	    // Mozilla/Safari, opera etc
	    if (window.XMLHttpRequest) {
	        self.xmlHttpReq = new XMLHttpRequest();
	    }
	    // IE
	    else if (window.ActiveXObject) {
	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }else{
	        alert("no ajax")
	        return
	    }
	    self.xmlHttpReq.open('POST', strURL, true);
	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    self.xmlHttpReq.onreadystatechange = function() {
	        if (self.xmlHttpReq.readyState == 4) {
	            updatepageConfirm(self.xmlHttpReq.responseText);
	        }
	    }
	    self.xmlHttpReq.send(queryStr);
	}


	function updatepageConfirm(str){
	    document.getElementById("ConfiguratorCenter").innerHTML = str;
	}
	

	</script>
</body>
</html>