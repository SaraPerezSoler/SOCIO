<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="recommenderQuestionnaire.main.RecommenderControl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bot tool recomendation</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
	<div class="container">
		<form class="login-form" method="post" action="EndQuestionnaire">
			<div class="row justify-content-md-center">
				<div class="col-lg-9">
					<%
						RecommenderControl control = RecommenderControl
								.getRecommenderControl(pageContext.getServletContext().getInitParameter("RecommenderPath"), null);
						Map<String, List<String>> questions = control.getQuestions();
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
								<div class="col-md">
									<select name="<%=name%>-Relevant"
										class="form-control form-control-sm">
										<%
											for (String level : control.getRelevantLevel(question)) {
										%>
										<option value="<%=level%>"><%=level%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-md-10">
									<div class="form-check">
										<%
											int i = 0;
												for (String option : questions.get(question)) {
										%>
										<%
											if (i % 2 == 0) {
										%>
										<div class="row">
											<%
												}
											%>
											<div class="col">
												<%
													if (isMulti) {
												%>
												<input class="form-check-input" name="<%=name%>-Answer"
													id="<%=option%>" type="checkbox" value="<%=option%>">
												<%
													} else {
												%>
												<input class="form-check-input" type="radio"
													name="<%=name%>-Answer" id="<%=name%>-Answer"
													value="<%=option%>">
												<%
													}
												%>
												<label class="form-check-label" for="<%=option%>"> <%=option%></label>

											</div>
											<%
												if (i % 2 != 0) {
											%>
										</div>
										<%
											}
													i += 1;
										%>
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<div class="row justify-content-md-center box">
				<div class="col">
					<button type="submit"
						class="row-lg btn btn-secondary btn-lg btn-block">Send
						Questionnaire</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>