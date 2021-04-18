package com.gridnine.testing;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterTest {

    FlightsBuilder flightsBuilder = new FlightsBuilder();
    List<Flight> flightList = new ArrayList<>();
    LocalDateTime now = LocalDateTime.now();
    ;

    FilterByDepartureDate filterByDepartureDate = new FilterByDepartureDate();
    FilterByArrivalDate filterByArrivalDate = new FilterByArrivalDate();
    FilterByRouteDuration filterByRouteDuration = new FilterByRouteDuration();
    FilterByTransferDuration filterByTransferDuration = new FilterByTransferDuration();
    FilterByTransfersCount filterByTransferCount = new FilterByTransfersCount();
    FilteringWrongRoute filteringWrongRoute = new FilteringWrongRoute();

    @Before
    public void setUp() {

        flightList.add(flightsBuilder.addNewFlightWithOneSegment(now.minusHours(5), now.plusHours(2)));
        flightList.add(flightsBuilder.addNewFlightWithOneSegment(now.plusHours(2), now.minusHours(1)));
        flightList.add(flightsBuilder.addNewFlightWithTwoSegment(now.plusHours(1), now.plusHours(2), now.plusHours(4), now.plusHours(7)));
        flightList.add(flightsBuilder.addNewFlightWithThreeSegment(now.minusHours(1), now.plusHours(3), now.plusHours(4), now.plusHours(8),
                now.plusHours(10), now.plusHours(18)));

    }

    @Test
    public void TestFilterByDepartureDate() {
        List<Flight> actual = filterByDepartureDate.sortingList(flightList, now, now.plusHours(3));
        List<Flight> expected = Arrays.asList(flightList.get(1), flightList.get(2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestFilterByArrivalDate() {
        List<Flight> actual = filterByArrivalDate.sortingList(flightList, now.minusHours(6), now);
        List<Flight> expected = Arrays.asList(flightList.get(1));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestFilterByRouteDuration() {
        List<Flight> actual = filterByRouteDuration.sortingList(flightList, 18);
        List<Flight> expected = Arrays.asList(flightList.get(0), flightList.get(1), flightList.get(2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestFilterByTransferDuration(){
        List<Flight> actual = filterByTransferDuration.sortingList(flightList, 3);
        List<Flight> expected = Arrays.asList(flightList.get(2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestFilterByTransferCount(){
        List<Flight> actual = filterByTransferCount.sortingList(flightList, 1);
        List<Flight> expected = Arrays.asList(flightList.get(0), flightList.get(1), flightList.get(2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestFilterWrongRoute(){
        List<Flight> actual = filteringWrongRoute.sortingList(flightList);
        List<Flight> expected = Arrays.asList(flightList.get(0), flightList.get(2), flightList.get(3));
        Assert.assertEquals(expected, actual);
    }
}
