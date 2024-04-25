package ricks_guitar_shop;

import java.util.HashMap;
import java.util.Map;

public class InstrumentSpec {
    private Map properties;

    public InstrumentSpec(Map properties) {
        if (properties == null) {
            this.properties = new HashMap();
        } else {
            this.properties = new HashMap(properties);
        }
    }

    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public Map getProperties() {
        return properties;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        for (Object key : otherSpec.properties.keySet()) {
            String propertyName = (String) key;
            if (properties.get(propertyName) != null && !(properties.get(propertyName).equals(otherSpec.getProperty(propertyName)))) {
                return false;
            }
        }
        return true;
    }
}
