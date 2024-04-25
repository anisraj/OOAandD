package ricks_guitar_shop;

public enum InstrumentType {
    GUITAR, BANJO, DOBRO, FIDDLE, BASS, MANDOLIN;

    @Override
    public String toString() {
        switch (this) {
            case GUITAR:    return "GUITAR";
            case BANJO:     return "BANJO";
            case DOBRO:     return "DOBRO";
            case FIDDLE:    return "FIDDLE";
            case BASS:      return "BASS";
            case MANDOLIN:  return "MANDOLIN";
            default:        return "UNSPECIFIED";
        }
    }
}
