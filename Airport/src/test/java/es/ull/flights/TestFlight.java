package es.ull.flights;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestFlight {

    @Test
    void testValidFlightNumber() {
        assertDoesNotThrow(() -> new Flight("AB123", 100));
    }

    @Test
    void testInvalidFlightNumber() {
        Exception exception = assertThrows(RuntimeException.class, () -> new Flight("123AB", 100));
        assertEquals("Invalid flight number", exception.getMessage());
    }

    @Test
    void testAddPassengerSuccessfully() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");
        assertTrue(flight.addPassenger(passenger));
        assertEquals(1, flight.getNumberOfPassengers());
    }
}