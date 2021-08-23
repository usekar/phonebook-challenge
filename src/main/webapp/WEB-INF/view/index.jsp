<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>PhoneBook</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	 
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	
 
</head>
<body>
	<div class="container">
		<div class="pure-g">
			<div class="pure-u-1">
				<div class="header">
					<img class="logo" src="img/phonebook.png"/>
					<p>v 1.0</p>
					<h3>${message}</h3>
				</div>
				
			</div>
		</div>
		<div class="pure-g">
		    <div class="pure-u-sm-1 pure-u-1-3">
		    	<div class="box">
		    		<h2><i class="fa fa-user-plus"></i>New contact</h2>
<!-- 		    		<form class="pure-form" action="registerUser" method="post" modelAttribute="user"> -->
		    		<form class="pure-form" action="registerUser" method="post">
					    <fieldset class="pure-group">
					        <input type="text" class="pure-input-1-2" placeholder="First Name" name="firstName" required>
					        <input type="text" class="pure-input-1-2" placeholder="Last Name" name="lastName" required>
					         <input type="tel" class="pure-input-1-2" placeholder="Phone # 800-222-3344" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required name="phoneNumber">
					        
					    </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">
					    <i class="fa fa-user-plus"></i>Add</button>
					   		<h3>${savedMessage}</h3> 
					</form>
				</div>
			</div>
		    <div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-search"></i>Search contact</h2>
		    		<!-- <form class="pure-form" action="findUser"  method="get" modelAttribute="id"> -->
		    		<form class="pure-form" action="findUser"  method="get">
		    			<fieldset class="pure-group">
					    	<input type="text" class="pure-input-1-2" name="id">
					     </fieldset>
					    <button type="submit"  class="pure-button pure-input-1-2 pure-button-primary">
					    <i class="fa fa-search"></i>Search</button>
					    <h4>${exceptionMessage}</h4> 
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-users"></i> Contacts</h2>
	    			<table class="pure-table">
					    <thead>
					        <tr>
					            <th>First Name</th>
					            <th>Last Name</th>
					            <th>Phone</th>
					        </tr>
					    </thead>
					
					    <tbody>
					    <c:forEach var="user" items="${contactList}">
					    	<tr>
					    		<td><c:out value="${user.firstName}"/> </td>
					    		<td><c:out value="${user.lastName}"/> </td>
					    		<td><c:out value="${user.phoneNumber}"/> </td>
					    	</tr>
					    </c:forEach>
					    
					        <!-- <tr>
					            <td>Arun</td>
					            <td>Kart</td>
					            <td>415-8679089</td>
					        </tr>
					
					        <tr>
					            <td>Juan</td>
					            <td>Torus</td>
					            <td>301-2390930</td>
					        </tr>
					
					        <tr>
					            <td>Nolux</td>
					            <td>Fernandez</td>
					            <td>(310)-2930291</td>
					        </tr> -->
					    </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>