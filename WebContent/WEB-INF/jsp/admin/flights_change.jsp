<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Flights</title>
    <link rel="stylesheet" type="text/css" href="css/flight_list.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<div class="container_flights_list">
        
    <header>
    	<%@include file="/WEB-INF/include/header.jspf"%> 
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2>FLIGHTS </h2>
               <div class="datagrid">
                 <table>
                 <thead>
                    <tr>
                      <th>#</th>
                      <th>selection</th>
                      <th>Code</th>
                      <th>From city</th>
                      <th>Departure date</th>
                      <th>Departure time</th>
                      <th>Code</th>
                      <th>To city</th>
                      <th>Arrival date</th>
                      <th>Arrival time</th>
                      <th>Cancel</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <td colspan="11">
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
                              <form name="change_flight" action="Main" method="GET" id="change_flight">
                                  <input type="hidden" name="action" value="change_flight">
                                  <button class="button_buy" id="myBtnbuy" value="${i.getFlightId()}" name="flight_id">Select it</button>
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
                            <td><c:out value="${i.getArrivalTime()}" /></td>
                         </tr>
                       </tbody>
                      </h3>
                    </c:forEach>
                  </table>
                </div>
            <!--</form>-->
            <div class="img_tower">
               <img src="img/tower.jpg" style="    padding-top: 10px;">
            </div>
        </section> 

    </div>
    <%@include file="/WEB-INF/include/footer.jspf"%>   
</body>
</html>