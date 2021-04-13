package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterByDepartureDate implements Filtering {

    //сортировка по дате отлёта (не ранее чем - не позднее чем)

    private String message = "Filter by departure Date";
    List<Flight> sortingFlightList = new ArrayList<>();

    public List<Flight> sortingList(List<Flight> noSortinglist, LocalDateTime localDateTimeFrom, LocalDateTime localDateTimeTo) {

        message();
        for (Flight fl : noSortinglist) {
            List<Segment> segments = fl.getSegments();
            if (segments.get(0).getDepartureDate().isAfter(localDateTimeFrom)
                    && segments.get(0).getDepartureDate().isBefore(localDateTimeTo)) {
                sortingFlightList.add(fl);
            }
        }
        return sortingFlightList;
    }

    @Override
    public void message() {
        System.out.println(message);
    }
}
