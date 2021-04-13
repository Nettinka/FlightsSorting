package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterByRouteDuration implements Filtering {

    //сортировка по длительности перелёта

    private String message = "Filter by Rout's Duration ";
    List<Flight> sortingFlightList = new ArrayList<>();

    @Override
    public void message() {
        System.out.println(message);
    }

    public List<Flight> sortingList(List<Flight> noSortinglist, Integer noMoreThanHours) {

        List<Flight> sortingFlightList = new ArrayList<>();
        message();
        for (Flight fl : noSortinglist) {
            List<Segment> segments = fl.getSegments();

            if (segments.get(segments.size() - 1).getArrivalDate().isBefore(segments.get(0).getDepartureDate().plusHours(noMoreThanHours))) {
                sortingFlightList.add(fl);
            }

        }
        return sortingFlightList;
    }

}
