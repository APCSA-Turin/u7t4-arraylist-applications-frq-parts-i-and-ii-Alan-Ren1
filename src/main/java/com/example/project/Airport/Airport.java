package com.example.project.Airport;

import java.util.ArrayList;

public class Airport {
    /** A list of the flights into and out of this airport
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private ArrayList<Flight> allFlights;

    public Airport(ArrayList<Flight> flights) {
        allFlights = flights;
    }

    public ArrayList<Flight> getAllFlights() {
        return allFlights;
    }

    /** Returns the revenue generated by all flights at the airport,
     *  as described in part (a)
     */
    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        for (Flight flight : allFlights) {
            if (flight.getNumPassengers() < flight.getCapacity()) {
            totalRevenue += flight.getNumPassengers() * flight.getTicketPrice();
            }
            else {
                totalRevenue += flight.getCapacity() * flight.getTicketPrice();
            }
        }
        return totalRevenue;
    }

    /** Updates the list of flights by removing certain flights and
     *  returns the total number of passengers whose flights were removed,
     *  as described in part (b)
     */
    public int updateFlights() {
        int removedPassengers = 0;
        
        // Loop through the flights and remove those with fewer than 50 passengers
        for (int i = 0; i < allFlights.size(); i++) {
            Flight flight = allFlights.get(i);
            if (flight.getNumPassengers() < flight.getCapacity() * 0.2) {
                removedPassengers += flight.getNumPassengers();
                allFlights.remove(i); // Remove the flight
                i--; // Adjust the index to prevent skipping the next flight
            }
        }
        return removedPassengers;
    }
}
