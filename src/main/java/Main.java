import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        List<Flight> flightList = FlightBuilder.createFlights();

        //1.	вылет до текущего момента времени
        System.out.println("Задание 1.");
        for (Flight fl : flightList) {
            List<Segment> segments = fl.getSegments();
            for (Segment sg : segments) {
                if (sg.getDepartureDate().isAfter(now)) {
                    System.out.println(sg);
                }
            }
        }

        //2.	имеются сегменты с датой прилёта раньше даты вылета
        System.out.println("\nЗадание 2.");
        for (Flight fl : flightList) {
            List<Segment> segments = fl.getSegments();
            segments.stream()
                    .filter(x -> x.getDepartureDate().isBefore(x.getArrivalDate()))
                    .forEach(System.out::println);

        }
        //3.	общее время, проведённое на земле превышает два часа
        // (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
        System.out.println("\nЗадание 3.");
        for (Flight fl : flightList) {
            List<Segment> segments = fl.getSegments();
            for (int i = 0; i < segments.size()-1; i++) {
                if(Duration.between(segments.get(i).getArrivalDate(), segments.get(i+1).getDepartureDate()).toHours() < 2){
                    System.out.println(segments.get(i));
                }
            }
        }
    }

}
