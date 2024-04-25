package ricks_guitar_shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindInstrument {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);

        Map properties = new HashMap();
        properties.put("builder", Builder.FENDER);
        properties.put("backwood", Wood.ALDER);
        properties.put("instrumentType", InstrumentType.GUITAR);
        InstrumentSpec clientSpec = new InstrumentSpec(properties);

        List<Instrument> matchingInstruments = inventory.searchInstruments(clientSpec);

        if (!matchingInstruments.isEmpty()) {
            for (Instrument instrument : matchingInstruments) {
                InstrumentSpec instrumentSpec = instrument.getSpec();
                System.out.println("We have a " + instrumentSpec.getProperty("instrumentType") +
                        " with following properties:");
                for (Object key : instrumentSpec.getProperties().keySet()) {
                    String propertyName = ((String) key);
                    if (propertyName.equals("instrumentType")) {
                        continue;
                    }
                    System.out.println(" " + propertyName + ": " + instrumentSpec.getProperty(propertyName));
                }
                System.out.println("You can have this " +
                        instrumentSpec.getProperty("instrumentType") + " for $" +
                        instrument.getPrice() + "\n----");
            }
        } else {
            System.out.println("Sorry, we have nothing for you.");
        }
    }

    private static void initializeInventory(Inventory inventory) {
        Map fenderGuitarProperties = new HashMap();
        fenderGuitarProperties.put("builder", Builder.FENDER);
        fenderGuitarProperties.put("backwood", Wood.ALDER);
        fenderGuitarProperties.put("instrumentType", InstrumentType.GUITAR);
        inventory.addInstrument("V95693", 1199.99,
                new InstrumentSpec(fenderGuitarProperties));

        Map fender2GuitarProperties = new HashMap();
        fender2GuitarProperties.put("builder", Builder.FENDER);
        fender2GuitarProperties.put("backwood", Wood.ALDER);
        fender2GuitarProperties.put("instrumentType", InstrumentType.GUITAR);
        inventory.addInstrument("V95694", 1299.99,
                new InstrumentSpec(fender2GuitarProperties));

        Map mandolin1Properties = new HashMap();
        mandolin1Properties.put("builder", Builder.FENDER);
        mandolin1Properties.put("backwood", Wood.ALDER);
        mandolin1Properties.put("style", Style.A);
        mandolin1Properties.put("instrumentType", InstrumentType.MANDOLIN);
        inventory.addInstrument("V95693", 1399.99,
                new InstrumentSpec(mandolin1Properties));

        Map mandolin2Properties = new HashMap();
        mandolin2Properties.put("builder", Builder.FENDER);
        mandolin2Properties.put("backwood", Wood.ALDER);
        mandolin2Properties.put("style", Style.F);
        mandolin2Properties.put("instrumentType", InstrumentType.MANDOLIN);
        inventory.addInstrument("V95693", 1499.99,
                new InstrumentSpec(mandolin2Properties));
    }
}
