package objectville_route_finder;

import objectville_route_finder.loader.SubwayLoader;
import objectville_route_finder.subway.Subway;

import java.io.File;
import java.io.IOException;

public class RouteFinderTester {
    public static void main(String[] args) {
        try {
            SubwayLoader subwayLoader = new SubwayLoader();
            Subway subway = subwayLoader.loadFromFile(new File("src/ObjectvilleSubway.txt"));
            System.out.println("Testing Stations...");
            if (subway.hasStation("shenoli")) {
                System.out.println("...station test passed.");
            } else {
                System.out.println("..station test FAILED");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
