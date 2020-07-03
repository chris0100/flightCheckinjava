<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Display Reservation Details</title>
</head>
<body>
    <h2>Flight Details</h2>

    Airlines: ${reservation.flight.operatingAirlines}<br/>
    Flight Number: ${reservation.flight.flightNumber}<br/>
    Departure City: ${reservation.flight.departureCity}<br/>
    Arrival City: ${reservation.flight.arrivalCity}<br/>
    Date Of Departure: ${reservation.flight.dateOfDeparture}<br/>
    Estimate Departure Time: ${reservation.flight.estimatedDepartureTime}<br/>

    <h2>Passenger Details</h2>

    First Name: ${reservation.passenger.firstName}<br/>
    Last Name: ${reservation.passenger.lastName}<br/>
    Email: ${reservation.passenger.email}<br/>
    Phone: ${reservation.passenger.phone}<br/>

    <form action="completeCheckIn" method="post">
        Enter the number of Bags you want to checkIn <input type="text" name="numberOfBags"/>
        <input type="hidden" value="${reservation.id}" name="reservationId"/>
        <input type="submit" value="Check In">
    </form>



</body>
</html>