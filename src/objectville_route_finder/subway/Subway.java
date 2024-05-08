package objectville_route_finder.subway;

import java.util.LinkedList;
import java.util.List;

public class Subway {
    private List stations;
    private List connections;

    public Subway() {
        this.stations = new LinkedList();
        this.connections = new LinkedList();
    }

    public void addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            stations.add(new Station(stationName));
        }
    }

    public boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }

    public void addConnection(String station1Name, String station2Name, String lineName) {
        if (this.hasStation(station1Name) && this.hasStation(station2Name)) {
            Station station1 = new Station(station1Name);
            Station station2 = new Station(station2Name);
            Connection connection = new Connection(station1, station2, lineName);
            connections.add(connection);
            connections.add(new Connection(station2, station1, lineName));
        } else {
            throw new RuntimeException("Invalid connection");
        }
    }

    public boolean hasConnection(String station1Name, String station2Name, String lineName) {
        Connection connectionToTest = new Connection(
                new Station(station1Name),
                new Station(station2Name),
                lineName);
        for (Object object : connections) {
            Connection connection = (Connection) object;
            if (connection.getLineName().equalsIgnoreCase(connectionToTest.getLineName()) &&
                    connection.getStation1().equals(connectionToTest.getStation1()) &&
                    connection.getStation2().equals(connectionToTest.getStation2())
            ) {
                return true;
            }
        }
        return false;
    }
}
