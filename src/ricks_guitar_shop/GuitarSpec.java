package ricks_guitar_shop;

public class GuitarSpec extends InstrumentSpec {

    private int numOfStrings;

    public GuitarSpec(Builder builder, String model, Type type,
                      Wood backWood, Wood topWood, int numOfStrings) {
        super(builder, model, type, backWood, topWood);
        this.numOfStrings = numOfStrings;
    }

    public int getNumOfStrings() {
        return numOfStrings;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) {
            return false;
        }
        if (!(otherSpec instanceof GuitarSpec)) {
            return false;
        }
        GuitarSpec spec = (GuitarSpec) otherSpec;
        if (numOfStrings != spec.numOfStrings) {
            return false;
        }
        return true;
    }
}
