package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilteringWrongRoute implements Filtering {

//Сортировка ошибочных перелётов, где дата вылета позже даты прилёта.

    private String message = "Filter wrong flights";
    List<Flight> sortingFlightList = new ArrayList<>();

    @Override
    public void message() {
        System.out.println(message);
    }

    public List<Flight> sortingList(List<Flight> noSortinglist) {
        message();
        this.sortingFlightList = sortingFlightList;
        for (Flight fl : noSortinglist) {
            List<Segment> segments = fl.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                if (segments.get(i).getDepartureDate().isBefore(segments.get(i + 1).getArrivalDate())) {
                    sortingFlightList.add(fl);
                }
            }
        }
        return sortingFlightList;
    }
}
