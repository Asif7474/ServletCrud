<%@page import="java.util.Iterator"%>
<%@page import="com.Dao.Daoimplement"%>
<%@page import="com.Dao.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Bean.Bean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
<script type="text/javascript">
function update(id,name,surname){
	document.getElementById('id').value=id;
	document.getElementById('name').value=name;
	document.getElementById('surname').value=surname;
	document.getElementById('submit').value='update';
	document.getElementById('submit').innerHTML='update';
}
</script>
</head>
<body>
<form action="Controller" method="post">
<table align="center" >
<tr>
<td>ID</td>
<td><input type= "text" name="id" id="id" maxlength="3" required></td>
</tr>

<tr>
<td>NAME</td>
<td><input type= "text" name="name" id="name" required></td>
</tr>

<tr>
<td>SURNAME</td>
<td><input type= "text" name="surname" id="surname"required></td>
</tr>

<tr>
<td></td>
<td><input type="submit" id="submit" name="submit" value="save"></td>
</tr>

</table>

<table border="1">
<tr>
<th>Id</th>
<th>NAME</th>
<th>SURNAME</th>
<th>ACTION</th>
<th>ACTION</th>
</tr>
<% Dao d=new Daoimplement();
	List<Bean>list=d.fetch();
	Iterator<Bean> itr=list.iterator();
	while(itr.hasNext()){
		Bean bean=(Bean)itr.next();
%>
<tr>
<td><%=bean.getId() %></td>
<td><%=bean.getName() %></td>
<td><%=bean.getSurname() %></td>
<td><a href="Controller?id=<%=bean.getId()%>">Delete</a>
<td><a href="#" onclick="update(<%=bean.getId() %>,'<%=bean.getName() %>','<%=bean.getSurname() %>')">Update</a>
</tr>
<%} %>
</table>

</form>
</body>
</html>