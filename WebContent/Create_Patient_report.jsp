<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Patient"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="cache-control" content="private" />
<meta http-equiv="x-ua-Compatible" content="IE=edge" />
<meta http-equiv="content-script-type" content="text/javascript" />
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, maximum-scale=5.0, user-scalable=1" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent" />
<meta name="author" content="Justinmind S.L." />
<meta name="description"
	content="Generated by Justinmind on Fri Nov 18 10:26:27 EST 2011" />
<title>project nurse and doctor pages - Create Patient report</title>
</head>
<body>

<%
	Patient patient = (Patient)session.getAttribute("patient"); 
%>

	<div id="s-b17e2f3b-f729-4715-a7c9-7bdad54d0cd5">
		<input id="screenName" type="hidden" value="Create Patient report" /><input
			id="canvases" type="hidden"
			value="s-b17e2f3b-f729-4715-a7c9-7bdad54d0cd5?t-cc823e36-92f0-4b7b-b8e6-250fbacc84ac" />
		<link rel="stylesheet" charset="utf-8"
			href="css/screens/Create%20Patient%20report.css" />
		<link rel="stylesheet" charset="utf-8"
			href="css/templates/Doctor%20Template.css" />
		<!--[if IE]><link rel="stylesheet" charset="utf-8" href="css/screens/Create%20Patient%20report-ie.css"/><link rel="stylesheet" charset="utf-8" href="css/templates/Doctor%20Template-ie.css"/><![endif]-->
		<div
			class="t-cc823e36-92f0-4b7b-b8e6-250fbacc84ac template firer commentable">
			<img id="t-Image_1" class="image firer commentable" alt="image"
				src="images/79-%20jp_clipboard_image.png" />
			<div id="t-Line_1" class="horizontalline firer commentable"></div>
			<img id="t-Image_2" class="image firer commentable" alt="image"
				src="images/0-%20we%20care.gif" />
			<div id="t-Line_2" class="horizontalline firer commentable"></div>
			<div id="t-Label_2" class="label firer commentable">© 2011 We
				Care. All Rights Reserved</div>
			<form action="Logout" method="post">
			<div id="t-Button_8" class="button firer click commentable"><input type="submit" value="Logout" /></div></form>
			<form action="Doctor.html" method="post">
			<div id="t-Button_9" class="button firer click commentable"><input type="submit" value="Home" /></div></form>
		</div>
		<div
			class="s-b17e2f3b-f729-4715-a7c9-7bdad54d0cd5 screen firer commentable">
			<form action="CreateMedicalReport" method="post">
			<div id="s-Rectangle_2" class="rectangle firer commentable"></div>
			<textarea id="s-Input_1" name="diagnosis" class="textarea firer commentable"></textarea>
			<textarea id="s-Input_2" name="prescription" class="textarea firer commentable"></textarea>
			<div id="s-Label_11" class="label firer commentable">Diagnosis</div>
			<div id="s-Label_12" class="label firer commentable">Prescription</div>
			<div id="s-Rectangle_1" class="rectangle firer commentable"></div>
			<div id="s-Rich_text_1" class="richtext firer commentable">
				<div id="s-Rich_text_1-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_1_0"><%=patient.getFirstName()%> <%=patient.getLastName()%></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Label_5" class="label firer commentable">Name</div>
			<div id="s-Rich_text_5" class="richtext firer commentable">
				<div id="s-Rich_text_5-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_5_0"><%=patient.getHealthInsuranceNumber() %></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Label_6" class="label firer commentable">Health
				Insurance Number</div>
			<div id="s-Label_27" class="label firer commentable">Create
				Patient Report</div>
			<div id="s-Button_1" class="button firer commentable"><input type="submit" value="Submit" /></div></form>
			<div id="s-Label_7" class="label firer commentable">Date</div>
			<div id="s-Rich_text_6" class="richtext firer commentable">
				<div id="s-Rich_text_6-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_6_0"><%=session.getAttribute("currentdate") %></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>