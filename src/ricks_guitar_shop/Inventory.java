package ricks_guitar_shop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Instrument> instruments;

    public Inventory() {
        instruments = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = null;
        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
        } else if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
        }
        instruments.add(instrument);
    }

    public Instrument getInstrument(String serialNumber) {
        for (Instrument instrument : instruments) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Guitar> searchGuitars(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Instrument instrument : instruments) {
            if (!(instrument instanceof Guitar)) {
                continue;
            }
            if (instrument.getSpec().matches(searchSpec)) {
                matchingGuitars.add((Guitar) instrument);
            }
        }
        return matchingGuitars;
    }

    public List<Mandolin> searchMandolins(MandolinSpec searchSpec) {
        List<Mandolin> matchingMandolins = new LinkedList<>();
        for (Instrument instrument : instruments) {
            if (!(instrument instanceof Mandolin)) {
                continue;
            }
            if (instrument.getSpec().matches(searchSpec)) {
                matchingMandolins.add((Mandolin) instrument);
            }
        }
        return matchingMandolins;
    }
}
