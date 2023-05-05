
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reminders</title>
 <link rel="stylesheet" href="styles.css" />
</head>
<body>
<%@ page import="com.company.dao.ReminderDao, com.company.nomeprojeto.*, java.util.*"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%
	List <Reminder> list = ReminderDao.getAllReminders();
	request.setAttribute("list", list);
	%>
	<div class="container">
		<div class="child">
			<div class="insert">
			<h1>New reminder</h1>
			
			<form class="form">
				<div>
					<label for="name">Name:</label>
					<input type="text" id="name" name="name" placeholder="Reminder name"><br><br>
					<label for="date">Date:</label>
					<input type="date" id="date" name="date" placeholder="Reminder date">
				</div>
				<button type="submit">Create</button>
			</form>
		</div>
		<div class="list">
			<h2>Reminder list</h2>
			<table>
				<c:forEach items="${reminders}" var="reminder">
					<tr>
						<td>${reminder.name}</td>
						<td>${reminder.date}</td>
						<td>
							<form action="deleteReminder" method="post">
								<input type="hidden" name="id" value="${reminder.id}">
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
		    </table>
		</div>
		</div>
	</div>
</body>
</html>