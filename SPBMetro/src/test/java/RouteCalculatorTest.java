import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> routeForNegative;
    RouteCalculator testCalculator;
    StationIndex testIndex;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        testIndex = new StationIndex();
        routeForNegative = new ArrayList<>();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        line1.addStation(new Station("Петровская", line1));
        line1.addStation(new Station("Романовская", line1));
        line1.addStation(new Station("Софийская", line1));
        line2.addStation(new Station("Романовская-2", line2));
        line2.addStation(new Station("Свердловская", line2));
        line2.addStation(new Station("Кантемировская", line2));
        line3.addStation(new Station("Степановская", line3));
        line3.addStation(new Station("Кантемировская-2", line3));


        testIndex.addLine(line1);
        testIndex.addLine(line2);
        testIndex.addLine(line3);

        for(Station station : line1.getStations()) {
            testIndex.addStation(station);
        }
        for(Station station : line2.getStations()) {
            testIndex.addStation(station);
        }
        for(Station station : line3.getStations()) {
            testIndex.addStation(station);
        }

        List<Station> connectionA = new ArrayList<>();
        List<Station> connectionB = new ArrayList<>();
        List<Station> connectionC = new ArrayList<>();
        connectionA.add(testIndex.getStation("Романовская"));
        connectionA.add(testIndex.getStation("Романовская-2"));
        connectionB.add(testIndex.getStation("Кантемировская"));
        connectionB.add(testIndex.getStation("Кантемировская-2"));

        testIndex.addConnection(connectionA);
        testIndex.addConnection(connectionB);
        testCalculator = new RouteCalculator(testIndex);
        route.add(testIndex.getStation("Петровская"));
        route.add(testIndex.getStation("Романовская"));
        route.add(testIndex.getStation("Романовская-2"));
        route.add(testIndex.getStation("Свердловская"));
        routeForNegative.add(testIndex.getStation("Петровская"));
        routeForNegative.add(testIndex.getStation("Петровская"));
        for (Station station : routeForNegative) {
            System.out.println(station.getName());
        }

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }


    public void testGetRouteOnTheLine() {
        List<Station> actual = new ArrayList<>();
        actual.addAll(testCalculator.getShortestRoute(testIndex.getStation("Петровская"), testIndex.getStation("Софийская")));
        List<Station> expected = new ArrayList<>();
        expected.add(testIndex.getStation("Петровская"));
        expected.add(testIndex.getStation("Романовская"));
        expected.add(testIndex.getStation("Софийская"));
        assertEquals(expected, actual);

    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = new ArrayList<>();
        actual.addAll(testCalculator.getShortestRoute(testIndex.getStation("Петровская"), testIndex.getStation("Свердловская")));
        List<Station> expected = new ArrayList<>();
        expected.add(testIndex.getStation("Петровская"));
        expected.add(testIndex.getStation("Романовская"));
        expected.add(testIndex.getStation("Романовская-2"));
        expected.add(testIndex.getStation("Свердловская"));
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {

        List<Station> actual = new ArrayList<>();
        actual.addAll(testCalculator.getShortestRoute(testIndex.getStation("Петровская"), testIndex.getStation("Степановская")));
        List<Station> expected = new ArrayList<>();
        expected.add(testIndex.getStation("Петровская"));
        expected.add(testIndex.getStation("Романовская"));
        expected.add(testIndex.getStation("Романовская-2"));
        expected.add(testIndex.getStation("Свердловская"));
        expected.add(testIndex.getStation("Кантемировская"));
        expected.add(testIndex.getStation("Кантемировская-2"));
        expected.add(testIndex.getStation("Степановская"));
        assertEquals(expected, actual);
    }

    //тест, проверяющий, что полученный маршрут - не пустой
    public void testGetShortestRouteNegative () {
        List<Station> actual = new ArrayList<>();
        actual.addAll(testCalculator.getShortestRoute(testIndex.getStation("Петровская"), testIndex.getStation("Степановская")));
        assertFalse(actual.size() == 0);
    }

    //тест проверяющий что если станция отправления и назначения - одна и та же, то длительность пути не должна быть
    //больше нуля. Тест не выполняется, так как калькулятор считает длительность 2.5
    public void testCalculateDurationNotZero () {
        double actual = RouteCalculator.calculateDuration(routeForNegative);
        assertFalse(actual > 0);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
