package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FilterByTransferDuration implements Filtering {

//сортировка по общему времени проведённому на земле во время пересадок

    private String message = "Filter by total duration of transfers";
    List<Flight> sortingFlightList = new ArrayList<>();

    @Override
    public void message() {
        System.out.println(message);
    }

    public List<Flight> sortingList(List<Flight> noSortingList, Integer noMoreHour) {
        message();
        for (Flight fl : noSortingList) {
            List<Segment> segments = fl.getSegments();
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    if (Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours() < 2) {
                        sortingFlightList.add(fl);
                    }
                }
            } else {
                return null;
            }
        }
        return sortingFlightList;
    }
}
