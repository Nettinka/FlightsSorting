package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterByArrivalDate implements Filtering {

//сортировка по дате прибытия (не ранее чем - не позднее чем)

    private String message = "Filter by Arrival Date";
    List<Flight> sortingFlightList = new ArrayList<>();

    @Override
    public void message() {
        System.out.println(message);
    }

    public List<Flight> sortingList(List<Flight> noSortinglist, LocalDateTime localDateTimeFrom, LocalDateTime localDateTimeTo) {
        List<Flight> sortingFlightList = new ArrayList<>();
        message();
        for (Flight fl : noSortinglist) {
            List<Segment> segments = fl.getSegments();
            if (segments.get(segments.size() - 1).getArrivalDate().isAfter(localDateTimeFrom)
                    && segments.get(segments.size() - 1).getArrivalDate().isBefore(localDateTimeTo)) {
                sortingFlightList.add(fl);
            }
        }
        return sortingFlightList;
    }
}
