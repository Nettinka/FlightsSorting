package com.gridnine.testing;

;
import java.util.ArrayList;
import java.util.List;

public class FilterByTransfersCount implements Filtering {

    //Сортировка по количеству пересадок (не более, чем указанов аргументе).

    private String message = "Filter by count of transfers";
    List<Flight> sortingFlightList = new ArrayList<>();

    @Override
    public void message() {
        System.out.println(message);
    }

    public List<Flight> sortingList(List<Flight> noSortingList, Integer noMoreThenTransferCount) {

        message();
        for (Flight fl : noSortingList) {
            List<Segment> segments = fl.getSegments();
            if (segments.size() <= noMoreThenTransferCount + 1) {
                sortingFlightList.add(fl);
            }

        }
        return sortingFlightList;
    }
}
