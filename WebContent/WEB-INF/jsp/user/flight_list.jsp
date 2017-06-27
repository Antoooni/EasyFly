<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang=${language}>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Flights</title>
    <link rel="stylesheet" type="text/css" href="css/flight_list.css"> 
	<script type="text/javascript" src="js/script.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container_flights_list">
        
    <header>
       	<%@include file="/WEB-INF/include/header.jspf"%>
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2>AVAILABLE FLIGHTS </h2>
          <!-- <form name="add_to_cart" action="Main" method="GET" id="cart">
            <input type="hidden" name="action" value="add_to_cart">-->
              <!--<table class="table" border="1" >
                <tr class="table_field">
                  <th class="table_field" style="width: 36px; ">#</th>
                  <th style="width: 100px; height: 24px; ">selection</th>
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
                       <td style="text-align: center; vertical-align: middle;"><input type="submit" name="add_cart" value="buy" /></td>
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
                </table>-->
               <div class="datagrid">
                 <table>
                 <thead>
                    <tr>
                      <th>#</th>
                      <th>selection</th>
                      <th>From airport code</th>
                      <th>From city</th>
                      <th>Departure date</th>
                      <th>Departure time</th>
                      <th>To airport code</th>
                      <th>To city</th>
                      <th>Arrival date</th>
                      <th>Arrival time</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <td colspan="10">
                      <div id="no-paging">&nbsp;</div>
                    </tr>
                  </tfoot>
                    <c:forEach items="${list_flights}" var="i">
                      <h3>
                      <tbody>
                         <tr> 
                           <td><c:out value="${list_flights.indexOf(i)}"/></td>
                           <td><!--<input type="submit" name="add_cart" value="buy" />-->
                            <div>
                              <form name="buy" action="Main" method="GET" id="buy">
                                  <input type="hidden" name="action" value="buy">
                                  <button class="button_buy" id="myBtnbuy" value="${i.getFlightId()}" name="flight_id">Buy it</button>
                              </form>
                            </div>
                           </td>
                           <td><c:out value="${i.getFromDirection().getDirectionCode()}" /></td>
                           <td><c:out value="${i.getFromDirection().getCity()}" /></td>
                           <td><c:out value="${i.getDepartureDate()}" /> </td>
                           <td><c:out value="${i.getDepartureTime()}" /></td>
                           <td><c:out value="${i.getToDirection().getDirectionCode()}" /> </td>
                           <td><c:out value="${i.getToDirection().getCity()}" /></td>
                           <td><c:out value="${i.getArrivalDate()}" /> </td>
                           <td><c:out value="${i.getArrivalTime()}" /></td>
                         </tr>
                       </tbody>
                      </h3>
                    </c:forEach>
                  </table>
                </div>
            <!--</form>-->
            <c:if test="${logged_user == false}">
              <div class="nonlogged">
                <div class="alertloggin">You are not logged-in yet. Please LOG IN
                  <!--<c:out value="You are not logged-in yet. Please LOG IN" />-->
                </div>
              </div>
            </c:if>
        </section> 

    </div>
	    <%@include file="/WEB-INF/include/footer.jspf"%>
	</div>
	
 <!--  <script type="text/javascript"> <!--
        function validate_form() {
            valid = true;
            if (document.val_form.login.value == "") {
                alert("Пожалуйста заполните поле 'Login'.");
                valid = false;
                return valid;
            }
            if (document.val_form.pass.value == "") {
                alert("Пожалуйста заполните поле 'Password'.");
                valid = false;
            return valid;
            }
        }
   </script>-->

    <script>
        // Get the modal
        var modal = document.getElementById('myPopUp');

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal 
        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script> 
</body>
</html>