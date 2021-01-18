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
		<div class="row justify-content-md-center">
			<div class="col">
				<h1 class="text-center box">Chatbot tool recommender</h1>
				<!--<p class="text-justify">Welcome to the tool recommender for creating chatbots. On
					this first page you must select the model of the chatbot. I will
					use this model to evaluate different characteristics of the chatbot
					(listed below) to obtain better precision when recommending a tool.
					Then you can select the level of relevance you want to give to each
					characteristic. The characteristics have four levels of relevance:
					relevant, doble relevance, critical. In the relevant and double
					relevant cases, if the tool cannot satisfy the characteristics of
					the chatbot, the tool will score less in the ranking, but in
					critical cases if the tool cannot satisfy the needs of the chatbot,
					that tool will be discarded. The multi-response characteristics
					have critical relevance divided into two:</p>
				<ul>
					<li>at least one option: the tool must satisfy at least one of
						the options that the chatbot has, but the more options it
						satisfies, the higher it will score in the ranking</li>
					<li>all options: if the tool does not satisfy all the options
						that the chatbot has, it will be discarded.</li>
				</ul>
				<p class="text-justify">For example, if you select a level of relevance "not
					relevant" to the chatbot language feature, it implies that when
					recommending a tool I will not take into account the language of
					the bot, however, if the selected tool does not support said
					language at best you have to make modifications in the chatbot to
					be able to use the tool.</p>-->
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form class="login-form" method="post" action="StartQuestionnaire"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col">
							<!-- Fila del File browser -->
							<div class="row justify-content-md-center box">
								<div class="col-med">
									<div>
										<h5>Select the chatbot model</h5>
										<div class="custom-file">
											<input type="file" id="model-file" name="model-file" class="custom-file-input" />
											<label class="custom-file-label" for="ecore-file">Choose
												file</label>
										</div>
									</div>
								</div>
							</div>
							<div class="row justify-content-md-center">
								<div class="col-lg-9">
									<%
										RecommenderControl control = RecommenderControl
												.getRecommenderControl(pageContext.getServletContext().getInitParameter("RecommenderPath"), null);
										for (String ev : control.getEvaluations().keySet()) {
									%>
									<div class="row">
										<div class="col-md-9">
											<%=ev%>
										</div>
										<div class="col-md">
											<select name ="<%=control.getQuestionName(ev)%>"class="form-control form-control-sm">
												<%
													for (String level : control.getRelevantLevel(ev)) {
												%>
												<option value ="<%=level%>"><%=level%></option>
												<%
													}
												%>
											</select>
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
										class="row-lg btn btn-secondary btn-lg btn-block">Start
										Questionnaire</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>