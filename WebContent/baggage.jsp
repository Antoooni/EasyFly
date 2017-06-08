<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Baggage</title>
    <link rel="stylesheet" type="text/css" href="baggage.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container_flights_list">
        
    <header>
        <nav>
            <li><a href="#"><h1>Home</h1></a></li>
            
            
           <!-- <li><a href="#">Link</a></li>
            <form name="val_form" action="MainServlet" method="POST" onsubmit="return validate_form ( );">
                  <input type="hidden" value="login" name="action" />
            Login:    <input type="text" name="login" /><br>
            Password: <input type="password" name="pass" />
            <input type="submit" onClick="return Formdata(this.form)" value="Log In" />--> 
            
        </nav>

        

        <div id="myPopUp" class="modal">

              
              
              
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2>Choose baggage </h2>
           <form name="add_baggage" action="Main" method="GET" id="baggage">
            <input type="hidden" name="action" value="add_to_cart">
              <table class="table" border="1" >
                <tr class="table_field">
                  <th class="table_field" style="width: 36px; ">#</th>
                  <th style="width: 160px; height: 24px; text-align: center; vertical-align: middle;">Choosing</th>
                  <th style="width: 120px; height: 24px; ">Babbage size</th>
                  <th style="width: 120px; height: 24px; ">Description</th>
                  <th style="width: 120px; height: 24px; ">MAX weight</th>
                  <th style="width: 120px; height: 24px; ">basic tariff</th>
                </tr>
                  <c:forEach items="${list_baggage}" var="i">
                    <h3>
                     <tr> 
                       <td><c:out value="${list_baggage.indexOf(i)}"/></td>
                       <td style="text-align: center; vertical-align: middle;"><input type="checkbox" name="add_baggage" value="${i.getId()}" /></td>
                       <td><c:out value="${i.getFromDirection().getDirectionCode()}" /></td>
                       <td><c:out value="${i.getFromDirection().getCity()}" /></td>
                       <td><c:out value="${i.getDepartureDate()}" /> </td>
                       <td><c:out value="${i.getDepartureTime()}" /></td>
                    </h3>
                  </c:forEach>
                </table>
              <div class="text_passenger_color">
        				<a href="#"
        					onclick="document.getElementById('add_passen').submit(); return false;">
                    
                    <h3>Continue to passenger</h3>
        				</a>
        		  </div>
          </form>
          <div class= "baggage_img">
                      <img src="baggage_bg.jpg" >
                    </div>
        </section> 

    </div>
	    <footer>
	        <h3>Contact us</h3>
	        <p>Copyright 2017 © mazets_anton@tut.by</p>
	    </footer>
	</div>
	


   

    
</body>
</html>