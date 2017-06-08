<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Flights</title>
    <link rel="stylesheet" type="text/css" href="flight.css"> 
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
            <h2>Your flight </h2>
           <form name="add_to_cart" action="Main" method="GET" id="cart">
            <input type="hidden" name="action" value="add_to_cart">
              <table class="table" border="1" >
                <tr class="table_field">
                  <th class="table_field" style="width: 36px; ">#</th>
                  <th style="width: 100px; height: 24px; ">From airport code</th>
                  <th style="width: 100px; height: 24px; ">From city</th>
                  <th style="width: 100px; height: 24px; ">Departure date</th>
                  <th style="width: 100px; height: 24px; ">Departure time</th>
                  <th style="width: 100px; height: 24px; ">To airport code</th>
                  <th style="width: 100px; height: 24px; ">To city</th>
                  <th style="width: 100px; height: 24px; "> Arrival date</th>
                  <th style="width: 100px; height: 24px; "> Arrival time</th>
                </tr>
                  <c:forEach items="${list_flights}" var="i">
                    <h3>
                     <tr> 
                       <td><c:out value="${list_flights.indexOf(i)}"/></td>
                       <td style="text-align: center; vertical-align: middle;"></td>
                       <td><c:out value="${i.getFromDirection().getDirectionCode()}" /></td>
                       <td><c:out value="${i.getFromDirection().getCity()}" /></td>
                       <td><c:out value="${i.getDepartureDate()}" /> </td>
                       <td><c:out value="${i.getDepartureTime()}" /></td>
                       <td><c:out value="${i.getToDirection().getDirectionCode()}" /> </td>
                       <td><c:out value="${i.getToDirection().getCity()}" /></td>
                       <td><c:out value="${i.getArrivalDate()}" /> </td>
                       <td><c:out value="${i.getArrivalTime()}" /></td>
                     </tr>
                    </h3>
                  </c:forEach>
                </table>
              <div class="text_baggage_color">
        				<a href="#"
        					onclick="document.getElementById('baggage').submit(); return false;">
        					<h3>ADD Baggage? 
                  <div class= "baggage_img">
                    <img src="baggage.png" >
                  </div>
                  </h3>
        				</a>
        		  </div>
            </form>
        </section> 

    </div>
	    <footer>
	        <h3>Contact us</h3>
	        <p>Copyright 2017 © mazets_anton@tut.by</p>
	    </footer>
	</div>
	


   

    
</body>
</html>