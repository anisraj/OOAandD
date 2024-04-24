package ricks_guitar_shop;

import java.util.List;

public class FindGuitarTester {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        GuitarSpec whatErinLikes = new GuitarSpec(Builder.FENDER,
                "Stratocaster", Type.ELECTRIC, Wood.ALDER,
                Wood.ALDER, 12);

        List<Guitar> matchingGuitars = inventory.searchGuitars(whatErinLikes);

        if (!matchingGuitars.isEmpty()) {
            for (Guitar guitar : matchingGuitars) {
                System.out.println("Erin, you might like this " +
                        guitar.getSpec().getBuilder() + " " + guitar.getSpec().getModel() + " " +
                        guitar.getSpec().getType() + " guitar:\n   " +
                        guitar.getSpec().getTopWood() + " top.\nYou can have it only $" +
                        guitar.getPrice() + "!\n ----"
                );
            }
        } else {
            System.out.println("Sorry Erin, we have nothing for you.");
        }

        MandolinSpec whatRickLikes = new MandolinSpec(Builder.FENDER,
                "Stratocaster", Type.ELECTRIC, Wood.ALDER,
                Wood.ALDER, Style.A);

        List<Mandolin> matchingMandolins = inventory.searchMandolins(whatRickLikes);

        if (!matchingMandolins.isEmpty()) {
            for (Mandolin mandolin : matchingMandolins) {
                System.out.println("Erin, you might like this " +
                        mandolin.getSpec().getBuilder() + " " + mandolin.getSpec().getModel() + " " +
                        mandolin.getSpec().getType() + " mandolin:\n   " +
                        mandolin.getSpec().getTopWood() + " top.\nYou can have it only $" +
                        mandolin.getPrice() + "!\n ----"
                );
            }
        } else {
            System.out.println("Sorry Erin, we have nothing for you.");
        }
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addInstrument("V95693", 1499.99,
                new GuitarSpec(Builder.FENDER, "Stratocaster", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, 12));

        inventory.addInstrument("V95694", 1299.99,
                new GuitarSpec(Builder.FENDER, "Stratocaster", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, 12));

        inventory.addInstrument("V95693", 1499.99,
                new MandolinSpec(Builder.FENDER, "Stratocaster", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, Style.A));

        inventory.addInstrument("V95693", 1499.99,
                new MandolinSpec(Builder.FENDER, "Stratocaster", Type.ELECTRIC,
                        Wood.ALDER, Wood.ALDER, Style.F));
    }
}
