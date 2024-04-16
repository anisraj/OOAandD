package ricks_guitar_shop;

public enum Type {
    ACOUSTIC,
    ELECTRIC;

    @Override
    public String toString() {
        switch (this) {
            case ACOUSTIC: return "acoustic";
            case ELECTRIC: return "electric";
            default: return "no type";
        }
    }
}
