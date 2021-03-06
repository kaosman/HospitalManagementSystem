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
	content="Generated by Justinmind on Thu Nov 24 18:37:39 EST 2011" />
<title>changed prototype - Admit_Patient</title>
</head>
<body>
<%
	Patient patient = (Patient)session.getAttribute("patient"); 
%>
	<div id="s-92555fe1-6344-413c-8a8e-1e4a254f3ebf">
		<input id="screenName" type="hidden" value="Admit_Patient" /><input
			id="canvases" type="hidden"
			value="s-92555fe1-6344-413c-8a8e-1e4a254f3ebf?t-70f2be6c-31aa-4006-9a58-4bf50f104708" />
		<link rel="stylesheet" charset="utf-8"
			href="css/screens/Admit_Patient.css" />
		<link rel="stylesheet" charset="utf-8"
			href="css/templates/Nurse%20Template.css" />
		<!--[if IE]><link rel="stylesheet" charset="utf-8" href="css/screens/Admit_Patient-ie.css"/><link rel="stylesheet" charset="utf-8" href="css/templates/Nurse%20Template-ie.css"/><![endif]-->
		<div
			class="t-70f2be6c-31aa-4006-9a58-4bf50f104708 template firer commentable">
			<img id="t-Image_1" class="image firer commentable" alt="image"
				src="images/19-%20jp_clipboard_image.png" /><img id="t-Image_2"
				class="image firer commentable" alt="image"
				src="images/0-%20we%20care.gif" />
			<div id="t-Line_1" class="horizontalline firer commentable"></div>
			<div id="t-Line_2" class="horizontalline firer commentable"></div>
			<div id="t-Label_2" class="label firer commentable">© 2011 We
				Care. All Rights Reserved</div>
				<form action="Logout" method="post">
			<div id="t-Button_8" class="button firer click commentable"><input type="submit" value="Logout" /></div></form>
			<form action="Nurse_Login.html" method="post">
			<div id="t-Button_9" class="button firer click commentable"><input type="submit" value="Home" /></div></form>
		</div>
		<div
			class="s-92555fe1-6344-413c-8a8e-1e4a254f3ebf screen firer commentable">
			<div id="s-Label_27" class="label firer commentable">Admit
				Patient</div>
				<form action="AdmitPatient" method="post">
			<div id="s-Button_1" class="button firer commentable"><input type="submit" value="Next"/></div>
			<img id="s-Image_2" class="image firer commentable" alt="image"
				src="images/0-%20images%20(3).jpg" />
			<div id="s-Rectangle_2" class="rectangle firer commentable"></div>
			<div id="s-Label_30" class="label firer commentable">Room #</div>
			<div id="s-Rectangle_1" class="rectangle firer commentable"></div>
			<div id="s-Rich_text_1" class="richtext firer commentable">
				<div id="s-Rich_text_1-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_1_0"><%=patient.getFirstName()%> <%=patient.getLastName() %></span></td>
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
			<div id="s-Label_7" class="label firer commentable">Date of
				Birth</div>
			<div id="s-Label_8" class="label firer commentable">Registration
				Date</div>
			<div id="s-Rich_text_3" class="richtext firer commentable">
				<div id="s-Rich_text_3-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_3_0"><%=patient.getDOB() %></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Rich_text_4" class="richtext firer commentable">
				<div id="s-Rich_text_4-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_4_0"><%=patient.getRegistrationDate() %></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Input_1" class="inputtext firer commentable">

<select name="Room">
<% for (int i = 0; i < 5; i++) { %>
<option value="<%=(i+1)%>"> <%= (i+1) %></option>
<% } %>
</select>	</div></form>
				<input maxlength="100" />
			</div>
		</div>

</body>
</html>