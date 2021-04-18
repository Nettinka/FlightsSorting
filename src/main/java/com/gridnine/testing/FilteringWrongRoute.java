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
        for (Flight fl : noSortinglist) {
            List<Segment> segments = fl.getSegments();
            if (segments.size() == 1) {
                if (segments.get(0).getDepartureDate().isBefore(segments.get(0).getArrivalDate())) {
                    sortingFlightList.add(fl);
                }
            }
            for (int i = 0; i < segments.size() - 1; i++) {
                if (segments.get(i).getDepartureDate().isBefore(segments.get(i + 1).getArrivalDate())) {
                    if (!sortingFlightList.contains(fl)) {
                        sortingFlightList.add(fl);
                    }
                }
            }
        }
        return sortingFlightList;
    }
}
