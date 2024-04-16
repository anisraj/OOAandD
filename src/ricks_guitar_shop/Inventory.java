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
                          Wood topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type,
                                   backWood, topWood);
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

    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Guitar guitar : guitars) {
            //Ignore serial number since that's unique
            //Ignore price since that's unique
            if (searchGuitar.getSpec().getBuilder() != guitar.getSpec().getBuilder()) {
                continue;
            }

            String model = searchGuitar.getSpec().getModel().toLowerCase();
            if (model != null && !model.equals("") &&
                !model.equals(guitar.getSpec().getModel().toLowerCase())) {
                continue;
            }

            if (searchGuitar.getSpec().getType() != guitar.getSpec().getType()) {
                continue;
            }

            if (searchGuitar.getSpec().getBackWood() != guitar.getSpec().getBackWood()) {
                continue;
            }

            if (searchGuitar.getSpec().getTopWood() != guitar.getSpec().getTopWood()) {
                continue;
            }
            matchingGuitars.add(guitar);
        }
        return matchingGuitars;
    }
}
