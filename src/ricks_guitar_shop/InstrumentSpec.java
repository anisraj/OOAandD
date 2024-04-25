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
            if (!(otherSpec.getProperty(propertyName).equals(properties.get(propertyName)))) {
                return false;
            }
        }
        return true;
    }
}
