package ricks_guitar_shop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, Builder builder,
                          String model, Type type, Wood backWood,
                          Wood topWood, int numOfStrings) {
        GuitarSpec spec = new GuitarSpec(builder, model, type,
                backWood, topWood, numOfStrings);
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Guitar guitar : guitars) {
            if (guitar.getSpec().matches(searchSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }
}
