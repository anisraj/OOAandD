package ricks_guitar_shop;

import java.util.List;

public class FindGuitarTester {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        Guitar whatErinLikes = new Guitar("", 0, Builder.FENDER,
                "Stratocaster", Type.ELECTRIC, Wood.ALDER,
                Wood.ALDER);

        List<Guitar> matchingGuitars = inventory.search(whatErinLikes);

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
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("V95693", 1499.99,
                Builder.FENDER, "Stratocaster", Type.ELECTRIC,
                Wood.ALDER, Wood.ALDER);

        inventory.addGuitar("V95694", 1299.99,
                Builder.FENDER, "Stratocaster", Type.ELECTRIC,
                Wood.ALDER, Wood.ALDER);
    }
}
