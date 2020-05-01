<%@page import="java.text.DecimalFormat"%>
<%@page import="recommenderQuestionnaire.main.RecommenderControl"%>
<%@page import="recommenderQuestionnaire.servlets.StartQuestionnaire"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		long id = (long) session.getAttribute(StartQuestionnaire.ID);
		RecommenderControl control = RecommenderControl
				.getRecommenderControl(pageContext.getServletContext().getInitParameter("RecommenderPath"), null);
		Map<String, Double> ranking = control.getRanking(id);
		DecimalFormat df2 = new DecimalFormat("#.##");
		String active = "active";
		boolean first = true;
	%>
	<div class="container">
		<div class="row justify-content-md-center box">
			<div class="col-md-4">

				<div class="nav flex-column nav-pills" id="tools" role="tablist"
					aria-orientation="vertical">
					<h1>Ranking</h1>
					<%
						for (String tool : ranking.keySet()) {
							String toolId = tool.replace(" ", "_").replace(".", "");
					%>
					<div class="row">

						<div class="col">
							<a class="nav-link" id="<%=toolId%>" data-toggle="pill"
								href="#<%=toolId%>-pane" role="tab"
								aria-controls="<%=toolId%>-pane" aria-selected="<%=first%>"><%=tool%></a>
						</div>
						<div class="col"><%=df2.format(ranking.get(tool) * 100)%>%
						</div>
					</div>
					<%
						active = "";
							first = false;
						}
					%>
				</div>
			</div>
			<div class="col-md-8">

				<div class="tab-content" id="toolsReport">
					<%
						active = "active";
						for (String tool : ranking.keySet()) {
							String toolId = tool.replace(" ", "_").replace(".", "");
					%>
					<div class="tab-pane fade show <%=active%>" id="<%=toolId%>-pane"
						role="tabpanel" aria-labelledby="<%=toolId%>">

						<h1 class="text-center"><%=tool%></h1>
						<%
							Map<String, Map<String, List<String>>> questions_evaluations = control.getAllQuestions();
								for (String type : questions_evaluations.keySet()) {

									Map<String, List<String>> questions = questions_evaluations.get(type);
						%>
						<h2><%=type%></h2>
						<%
							for (String question : questions.keySet()) {
										boolean isMulti = control.isMulti(question);
										String name = control.getQuestionName(question);
						%>
						<div class="row">
							<div class="col box">
								<div class="row ">
									<div class="col-md-9">
										<%=question%>
										<%
											if (isMulti) {
										%>(Multi-response)<%
											}
										%>
									</div>
									<div class="col-md-2">
										<%=control.getRelevantLevel(id, question)%>
									</div>
									<div class="col-md-1">
										<%
											double score = control.getQuestionScore(id, question, tool);
														if (score == -1) {
										%>
										-
										<%
											} else {
										%>
										<%=df2.format(score * 100)%>%
										<%
											}
										%>
									</div>
								</div>
								<div class="row justify-content-md-center">
									<div class="col-md-10">

										<ul class="list-group">
											<%
												Map<String, String> answers = control.getAnswersTool(id, question, tool);
															for (String option : answers.keySet()) {
																if (answers.get(option).equals(RecommenderControl.ACCEPTED)) {
											%>
											<li class="list-group-item list-group-item-success"><%=option%>
												(<%=answers.get(option)%>)</li>
											<%
												} else if (answers.get(option).equals(RecommenderControl.REFUSED)) {
											%>
											<li class="list-group-item list-group-item-danger"><%=option%>
												(<%=answers.get(option)%>)</li>
											<%
												} else {
											%>
											<li class="list-group-item list-group-item-warning"><%=option%>
												(<%=answers.get(option)%>)</li>
											<%
												}
															}
											%>
										</ul>

									</div>
								</div>
							</div>
						</div>
						<%
							}
								}
						%>
					</div>
					<%
						active = "";

						}
					%>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			e.target // newly activated tab
			e.relatedTarget // previous active tab
		})
	</script>
</body>
</html>