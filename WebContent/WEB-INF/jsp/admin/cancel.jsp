<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Flights</title>
    <link rel="stylesheet" type="text/css" href="css/cancel.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>

<div class="container_flights_list">    
    <header>
    	<%@include file="/WEB-INF/include/header.jspf"%>
            <!-- <li><a href="#"><h1>Home</h1></a></li>-->
        <div id="myPopUp" class="modal">
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2>Flight </h2>
            <!--Flight info-->
                  <%@include file="/WEB-INF/include/flight_info.jspf"%>
   </div>
        </section> 
        <!--Spoiler-->
        <details id="details_first">
          <summary class="spoiler">
          <div id="spoiler_head">Change date & time</div>
          </summary>
          <form name="change_flight_data" action="Main" method="GET" id="change_flight_data">
	      <input type="hidden" name="action" value="change_flight_data">
	          <!--Date of birth-->
	          <div id="first">
	            <div id="first_left">
	              Departure date
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="date" name="change_dept_date" required>
	            </div>
	          </div>
	
	          <div id="first">
	            <div id="first_left">
	              Departure time
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="time" name="change_dept_time" required>
	            </div>
	          </div>
	          <!--passport expiry-->
	          <div id="first">
	            <div id="first_left">
	              Arrival date
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="date" name="change_arr_date" required>
	            </div>
	          </div>
	          <div id="first">
	            <div id="first_left">
	              Arrival time
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="time" name="change_arr_time" required>
	            </div>
	          </div>
	          <c:if test="${empty_data == true}">
	          <div class="empty_data">
                <div class="alert_empty_data">Please select data above
                </div>
              </div>
	          </c:if>
	          <div id="buy_it">
		           <div id="buy_it_button">
		          	 <button class="go_search" id="go_search" name="change_date">Change date</button>
		           </div>
	          </div>
          </form>
        </details>

          <details id="details_last">
            <summary class="spoiler">
            <div id="spoiler_head">CANCEL FLIGHT</div>
            </summary>
            <div id="baggage_img"><IMG src="img/cancel.jpg" HEIGHT="200" WIDTH="600">
            </div>
            <form name="cancel_flight" action="Main" method="GET" id="cancel_flight">
              <input type="hidden" name="action" value="cancel_flight">
              <div id="buy_it">
                <div id="buy_it_button">
                  <button class="go_search" id="cancel_flight" name="cancel_flight">Cancel flight</button>
                </div>
              </div>
            </form>

          </details>
	    <%@include file="/WEB-INF/include/footer.jspf"%>
    </div>
</body>
</html>