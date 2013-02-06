<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Patient"%>
    <%@ page import="model.Appointment"%>
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
	content="Generated by Justinmind on Fri Nov 18 19:41:29 EST 2011" />
<title>project_Latest We_Care_2011-11-15_10h55m17s - Success
	Cancel appointment</title>
</head>
<body>

<%
	Appointment appointment = (Appointment)session.getAttribute("cancelApp"); 
%>
	<div id="s-72936889-72d3-4aab-82fc-6e67b82102c4">
		<input id="screenName" type="hidden"
			value="Success Cancel appointment" /><input id="canvases"
			type="hidden"
			value="s-72936889-72d3-4aab-82fc-6e67b82102c4?t-70f2be6c-31aa-4006-9a58-4bf50f104708" />
		<link rel="stylesheet" charset="utf-8"
			href="css/screens/Success%20Cancel%20appointment.css" />
		<link rel="stylesheet" charset="utf-8"
			href="css/templates/Nurse%20Template.css" />
		<!--[if IE]><link rel="stylesheet" charset="utf-8" href="css/screens/Success%20Cancel%20appointment-ie.css"/><link rel="stylesheet" charset="utf-8" href="css/templates/Nurse%20Template-ie.css"/><![endif]-->
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
			class="s-72936889-72d3-4aab-82fc-6e67b82102c4 screen firer commentable">
			<div id="s-Rectangle_1" class="rectangle firer commentable"></div>
			<div id="s-Label_1" class="label firer commentable">Doctor Name</div>
			<div id="s-Label_2" class="label firer commentable">Health
				Insurance Number</div>
			<div id="s-Label_3" class="label firer commentable">Date</div>
			<div id="s-Label_4" class="label firer commentable">Patient
				Name</div>
			<div id="s-Label_5" class="label firer commentable">Time</div>
			<div id="s-Label_6" class="label firer commentable">Appointment
				Cancelled</div>
			<div id="s-Rich_text_1" class="richtext firer commentable">
				<div id="s-Rich_text_1-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_1_0"><%= appointment.getDoctorName() %></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Rich_text_2" class="richtext firer commentable">
				<div id="s-Rich_text_2-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_2_0"><%= appointment.getPatientName()%></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Rich_text_3" class="richtext firer commentable">
				<div id="s-Rich_text_3-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_3_0"><%= appointment.getHealthInsuranceNumber()%></span></td>
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
								<td><span id="s-Rich_text_4_0"><%= appointment.getTime()%></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div id="s-Rich_text_5" class="richtext firer commentable">
				<div id="s-Rich_text_5-container">
					<table class="collapse" style="height: 100%; width: 100%;"
						summary="">
						<tbody>
							<tr>
								<td><span id="s-Rich_text_5_0"><%= appointment.getDate()%></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<img id="s-Image_1" class="image firer commentable" alt="image"
				src="images/0-%20services_banner_appointment_scheduling.jpg" />
			<div id="s-Label_27" class="label firer commentable">Appointment
				Cancelled Successfully</div>
			<img id="s-Image_2" class="image firer commentable" alt="image"
				src="images/0-%20blue_sad_sticker-p217815627216706462qjcl_400.jpg" />
		</div>
	</div>
</body>
</html>