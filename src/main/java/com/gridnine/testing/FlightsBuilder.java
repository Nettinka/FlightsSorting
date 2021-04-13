package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightsBuilder {

    List<Flight> flightList = new ArrayList<>();

    public List<Flight> getFlightList() {
        return flightList;
    }

    public Flight addNewFlightWithOneSegment(final LocalDateTime departure, final LocalDateTime arrival){
        Segment segment = new Segment(departure, arrival);
        List <Segment> segmentList = Arrays.asList(segment);
        Flight flight = new Flight(segmentList);
        return flight;
    }

    public Flight addNewFlightWithTwoSegment(final LocalDateTime departure1, final LocalDateTime arrival1,
                                           final LocalDateTime departure2, final LocalDateTime arrival2){
        Segment segment1 = new Segment(departure1, arrival1);
        Segment segment2 = new Segment(departure2, arrival2);
        List <Segment> segmentList = Arrays.asList(segment1, segment2);
        Flight flight = new Flight(segmentList);
        return flight;
    }

    public Flight addNewFlightWithThreeSegment(final LocalDateTime departure1, final LocalDateTime arrival1,
                                           final LocalDateTime departure2, final LocalDateTime arrival2,
                                             final LocalDateTime departure3, final LocalDateTime arrival3){
        Segment segment1 = new Segment(departure1, arrival1);
        Segment segment2 = new Segment(departure2, arrival2);
        Segment segment3 = new Segment(departure3, arrival3);
        List <Segment> segmentList = Arrays.asList(segment1, segment2, segment3);
        Flight flight = new Flight(segmentList);
        return flight;
    }
}
