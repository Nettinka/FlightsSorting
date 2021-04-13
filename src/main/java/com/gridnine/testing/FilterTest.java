//НУЖНО ДЕБАЖИТЬ.Не работает.

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
    LocalDateTime now = LocalDateTime.now();;

    FilterByDepartureDate filterByDepartureDate = new FilterByDepartureDate();

    @Before
    public void setUp() throws Exception {

        flightList.add(flightsBuilder.addNewFlightWithOneSegment(now.minusHours(5), now.plusHours(2)));
        flightList.add(flightsBuilder.addNewFlightWithOneSegment(now.plusHours(2) , now.minusHours(1)));
        flightList.add(flightsBuilder.addNewFlightWithTwoSegment(now.plusHours(1) , now.plusHours(2), now.plusHours(4), now.plusHours(7)));
        flightList.add(flightsBuilder.addNewFlightWithThreeSegment(now.minusHours(1), now.plusHours(3), now.plusHours(4), now.plusHours(8),
                now.plusHours(10), now.plusHours(18)));

        flightList = flightsBuilder.getFlightList();
    }

    @Test
    public void TestFilterByDepartureDate(){
        List <Flight> actual = filterByDepartureDate.sortingList(flightList, now, now.plusHours(3));
        List<Flight> expected = Arrays.asList(flightList.get(0), flightList.get(1));
        Assert.assertEquals(expected, actual);
    }
}
