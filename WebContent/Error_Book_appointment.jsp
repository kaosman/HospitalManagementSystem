<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Patient"%>
    <%@ page import="model.Staff"%>
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
	content="Generated by Justinmind on Fri Nov 18 13:39:32 EST 2011" />
<title>project_Latest We_Care_2011-11-15_10h55m17s - Error Book
	appointment</title>
</head>
<body>

	<div id="s-f452ff46-33e9-4f62-ab03-682a04136872">
		<input id="screenName" type="hidden" value="Error Book appointment" /><input
			id="canvases" type="hidden"
			value="s-f452ff46-33e9-4f62-ab03-682a04136872?t-70f2be6c-31aa-4006-9a58-4bf50f104708" />
		<link rel="stylesheet" charset="utf-8"
			href="css/screens/Error%20Book%20appointment.css" />
		<link rel="stylesheet" charset="utf-8"
			href="css/templates/Nurse%20Template.css" />
		<!--[if IE]><link rel="stylesheet" charset="utf-8" href="css/screens/Error%20Book%20appointment-ie.css"/><link rel="stylesheet" charset="utf-8" href="css/templates/Nurse%20Template-ie.css"/><![endif]-->
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
			<form action="Nurse_Login" method="post">
			<div id="t-Button_9" class="button firer click commentable"><input type="submit" value="Home" /></div></form>
		</div>
		<div
			class="s-f452ff46-33e9-4f62-ab03-682a04136872 screen firer commentable">
			<img id="s-Image_1" class="image firer commentable" alt="image"
				src="images/0-%20services_banner_appointment_scheduling.jpg" />
			<div id="s-Label_27" class="label firer commentable">Book
				Appointment</div>
			<div id="s-Label_1" class="label firer commentable">Incorrect
				Information, Please enter again</div>
			<div id="s-Rectangle_1" class="rectangle firer commentable"></div>
			<div id="s-Label_2" class="label firer commentable">Doctor Name</div>
			<div id="s-Input_1" class="inputtext firer commentable">
			
			<% ArrayList<String> list = (ArrayList<String>)session.getAttribute("doctors");  %>
			
				<form action ="BookAppointment" method="post">
				<select name="doctor">
				<%for (int i = 0; i < list.size(); i++) { %>
				<option value="<%=i%>"><%= list.get(i) %></option> <% } %>
				</select>
				<input name="HealthInsuranceNumber" type="text" maxlength="100" />
			</div>
			<div id="s-Label_3" class="label firer commentable">Health
				Insurance Number</div>
			<div id="s-Input_2" class="inputtext firer commentable">
				<input maxlength="100" />
			</div>
			<div id="s-Label_4" class="label firer commentable">Date</div>
			<div id="s-Button_2" class="button firer commentable"><input type="submit" value="Next"/></div>
			<div id="s-Input_3" class="inputtext firer commentable">
			<select name="year">
<option value="2011">2011</option>
<option value="2012">2012</option>
<option value="2013">2013</option>
</select>
				<input maxlength="100" />
			</div>
			<div id="s-Input_4" class="inputtext firer commentable">
<select name="Month">
<option value="01">Jan</option>
<option value="02">Feb</option>
<option value="03">Mar</option>
<option value="04">Apr</option>
<option value="05">May</option>
<option value="06">Jun</option>
<option value="07">Jul</option>
<option value="08">Aug</option>
<option value="09">Sep</option>
<option value="10">Oct</option>
<option value="11">Nov</option>
<option value="12">Dec</option>
</select>

				<input maxlength="100" />
			</div>
			<div id="s-Input_5" class="inputtext firer commentable">
<select name="date">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>
</form>
				<input maxlength="100" />
			</div>
		</div>
	</div>
</body>
</html>