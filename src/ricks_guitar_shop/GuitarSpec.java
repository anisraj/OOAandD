package ricks_guitar_shop;

public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood, topWood;
    private int numOfStrings;

    public GuitarSpec(Builder builder, String model, Type type,
                      Wood backWood, Wood topWood, int numOfStrings) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.numOfStrings = numOfStrings;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public int getNumOfStrings() {
        return numOfStrings;
    }

    public boolean matches(GuitarSpec otherSpec) {
        if (builder != otherSpec.builder) {
            return false;
        }
        if (model != null && !model.equals("") &&
            !model.equals(otherSpec.model)) {
            return false;
        }
        if (type != otherSpec.type) {
            return false;
        }
        if (backWood != otherSpec.backWood) {
            return false;
        }
        if (topWood != otherSpec.topWood) {
            return false;
        }
        if (numOfStrings != otherSpec.numOfStrings) {
            return false;
        }
        return true;
    }
}
