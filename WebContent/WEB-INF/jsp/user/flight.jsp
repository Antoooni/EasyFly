<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang=${language}>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Flights</title>
    <link rel="stylesheet" type="text/css" href="css/flight.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container_flights_list">
        
    <header>
        <nav>
        <%@include file="/WEB-INF/include/header.jspf"%>
            <li><a href="#"><h1>Home</h1></a></li>
        </nav>
        <div id="myPopUp" class="modal">
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2>Your flight </h2>
            <form name="buy_ticket" action="Main" method="POST">
              <input type="hidden" value="buy_ticket" name="action" />
               <!--Flight info-->
                  <%@include file="/WEB-INF/include/flight_info.jspf"%>
   </div>
              </section> 
              <!--Spoiler-->
              <details id="details_first">
                <summary class="spoiler">
                <div id="spoiler_head">Passenger info</div>
                </summary>
                <!--Name-->
                <div id="first">
                  <div id="first_left">
                    Pass name
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_name"  required>
                  </div>
                </div>
                <!--Surname-->
                <div id="first">
                  <div id="first_left">
                    Pass Surname
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_surname"  required>
                  </div>
                </div>
                <!--MiddleName-->
                <div id="first">
                  <div id="first_left">
                    Pass Middlename
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_midname" >
                  </div>
                </div>
                <!--Age-->
                <div id="first">
                  <div id="first_left">
                    Age
                  </div>
                  <div id="first_right">
                      <input id="passenger_age" type="number" size="3" min="1" max="100" value="1" name="passenger_age" pattern="[0-9]{2}">
                  </div>
                </div>
                <!--Date of birth-->
                <div id="first">
                  <div id="first_left">
                    Date of birth
                  </div>
                  <div id="first_right">
                      <input id="passenger_date" type="date" name="passenger_birth" required>
                  </div>
                </div>
                <!--gender-->
                <div id="first">
                  <div id="first_left">
                    Sex
                  </div>
                  <div id="first_right">
                      <select id="passenger_sex" name="passenger_sex">
                        <option>Male</option>
                        <option>Female</option>
                      </select>
                  </div>
                </div>
                <!--passport id-->
                <div id="first">
                  <div id="first_left">
                    Passport number
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_passport_number" required>
                  </div>
                </div>
                <!--passport expiry-->
                <div id="first">
                  <div id="first_left">
                    Passport expirty
                  </div>
                  <div id="first_right">
                      <input id="passenger_date" type="date" name="passenger_passport_expirty" required>
                  </div>
                </div>
                <div id="first">
                  <div id="first_left">
                    Primary boarding
                  </div>
                  <div id="first_right">
                      <select id="passenger_sex" name="passenger_boarding">
                        <option>No</option>
                        <option>Yes</option>
                      </select>
                  </div>
                </div>
                <div id="first">
                  <div id="first_left">
                    Online check-in
                  </div>
                  <div id="first_right">
                      <select id="passenger_sex" name="passenger_checkin">
                        <option>No</option>
                        <option>Yes</option>
                      </select>
                  </div>
                </div>
                <details id="details_last">
                  <summary class="spoiler">
                  	<div id="spoiler_head">Baggage info</div>
                  </summary>
                  <div id="baggage_img"><IMG src="img/baggage_bg.jpg" HEIGHT="200" WIDTH="600"></div>
                  <div id="first">
                    <div id="first_left_baggage">
                      Baggage
                    </div>
                    <div id="first_right">
                        <select id="passenger_sex" name="passenger_baggage">
                         <option value="small">Small 15 kilo</option>
                         <option value="medium">Medium 22 kilo</option>
                         <option value="large">Large 32 kilo</option>
                      </select>
                    </div>
                  </div>
                  <div id="buy_it">
                    <div id="buy_it_button">
                      <button class="go_search" id="go_search" >Buy it!</button>
                    </div>
                  </div>

                </details>
                
              </details>
       </form>
	<%@include file="/WEB-INF/include/footer.jspf"%>
</div>   
</body>
</html>