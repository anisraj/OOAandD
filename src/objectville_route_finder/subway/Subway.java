package objectville_route_finder.subway;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Subway {
    private List stations;
    private List<Connection> connections;
    private Map<Station, List<Station>> network;

    public Subway() {
        this.stations = new LinkedList();
        this.connections = new LinkedList<>();
        this.network = new HashMap<>();
    }

    public void addStation(String stationName) {
        if (!this.hasStation(stationName)) {
            stations.add(new Station(stationName));
        }
    }

    public boolean hasStation(String stationName) {
        return stations.contains(new Station(stationName));
    }

    public boolean hasConnection(String station1Name, String station2Name, String lineName) {
        Connection connectionToTest = new Connection(
                new Station(station1Name),
                new Station(station2Name),
                lineName);
        for (Connection connection : connections) {
            if (connection.getLineName().equalsIgnoreCase(connectionToTest.getLineName()) &&
                    connection.getStation1().equals(connectionToTest.getStation1()) &&
                    connection.getStation2().equals(connectionToTest.getStation2())
            ) {
                return true;
            }
        }
        return false;
    }

    public Connection getConnection(Station station1, Station station2) {
        for (Connection connection : connections) {
            Station one = connection.getStation1();
            Station two = connection.getStation2();
            if (station1.equals(one) && station2.equals(two)) {
                return connection;
            }
        }
        return null;
    }

    public Connection addConnection(String station1Name, String station2Name, String lineName) {
        if (this.hasStation(station1Name) && this.hasStation(station2Name)) {
            Station station1 = new Station(station1Name);
            Station station2 = new Station(station2Name);
            Connection connection = new Connection(station1, station2, lineName);
            connections.add(connection);
            connections.add(new Connection(station2, station1, lineName));

            addToNetwork(station1, station2);
            addToNetwork(station2, station1);

            return connection;
        } else {
            throw new RuntimeException("Invalid connection");
        }
    }

    private void addToNetwork(Station station1, Station station2) {
        if (network.containsKey(station1)) {
            List<Station> connectingStations = network.get(station1);
            if (!connectingStations.contains(station2)) {
                connectingStations.add(station2);
            }
        } else {
            List<Station> connectingStations = new LinkedList<>();
            connectingStations.add(station2);
            network.put(station1, connectingStations);
        }
    }

    public List<Connection> getDirections(String startStationName, String endStationName) {
        if (!this.hasStation(startStationName) ||
                !this.hasStation(endStationName)) {
            throw new RuntimeException("Station entered do not exist on this subway");
        }

        Station start = new Station(startStationName);
        Station end = new Station(endStationName);

        List<Connection> route = new LinkedList<>();
        List<Station> reachableStations = new LinkedList<>();
        Map<Station, Station> previousStations = new HashMap<>();

        List<Station> neighbours = network.get(start);
        for (Station station : neighbours) {
            if (station.equals(end)) {
                route.add(getConnection(start, end));
                return route;
            } else {
                reachableStations.add(station);
                previousStations.put(station, start);
            }
        }

        List<Station> nextStations = new LinkedList<>();
        nextStations.addAll(neighbours);
        Station currentStation = start;

        searchLoop:
        for (int i = 1; i < stations.size(); i++) {
            List<Station> tmpNextStations = new LinkedList<>();
            for (Station station : nextStations) {
                reachableStations.add(station);
                currentStation = station;
                List<Station> currentNeighbours = network.get(currentStation);
                for (Station neighbour : currentNeighbours) {
                    if (neighbour.equals(end)) {
                        reachableStations.add(neighbour);
                        previousStations.put(neighbour, currentStation);
                        break searchLoop;
                    } else if (!reachableStations.contains(neighbour)) {
                        reachableStations.add(neighbour);
                        tmpNextStations.add(neighbour);
                        previousStations.put(neighbour, currentStation);
                    }
                }
            }
            nextStations = tmpNextStations;
        }
        boolean keepLooping = true;
        Station keyStation = end;
        Station station;

        while (keepLooping) {
            station = previousStations.get(keyStation);
            route.add(0, getConnection(station, keyStation));
            if (start.equals(station)) {
                keepLooping = false;
            }
            keyStation = station;
        }

        return route;
    }

}
