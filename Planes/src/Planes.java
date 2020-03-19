import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Planes {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        String pattern = "HH:mm";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar now = GregorianCalendar.getInstance();
        Calendar deadLine = GregorianCalendar.getInstance();
        deadLine.add(Calendar.HOUR, 2);

        System.out.println("Ближайшие рейсы:");
        System.out.println("=============================================");
        System.out.println("ВРЕМЯ        МОДЕЛЬ");
        airport.getTerminals().stream()
                .map(terminal -> terminal.getFlights())
                .flatMap(List::stream).distinct()
                .filter(flight -> flight.getType() == DEPARTURE)
                .filter(flight -> flight.getDate().after(now.getTime()))
                .filter(flight -> flight.getDate().before(deadLine.getTime()))
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(flight -> {
                    System.out.println(format.format(flight.getDate()) + "        " + flight.getAircraft());
                });


    }
}
