package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        List<Flight> flightList = FlightBuilder.createFlights();

        FilteringWrongRoute filteringWrongRoute = new FilteringWrongRoute();
        FilterByTransferDuration ftd = new FilterByTransferDuration();
        FilterByDepartureDate fbdd = new FilterByDepartureDate();

        //1.	вылет до текущего момента времени
        System.out.println("Задание 1.");
        fbdd.sortingList(flightList, now, now.plusHours(200)).forEach(System.out::println);

        //2.	имеются сегменты с датой прилёта раньше даты вылета
        System.out.println("\nЗадание 2.");
        filteringWrongRoute.sortingList(flightList).forEach(System.out::println);

        //3.	общее время, проведённое на земле превышает два часа
        // (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
        System.out.println("\nЗадание 3.");
        ftd.sortingList(flightList, 2).forEach(System.out::println);

    }

}
