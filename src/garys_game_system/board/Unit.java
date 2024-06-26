package garys_game_system.board;

import java.util.*;

public class Unit {
    private String type;
    private int id;
    private String name;
    private List weapons;
    private Map properties;

    public Unit(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addWeapon(Weapon weapon) {
        if (weapons == null) {
            weapons = new LinkedList();
        }
        weapons.add(weapon);
    }

    public List getWeapons() {
        return weapons;
    }

    public void setProperty(String property, Object value) {
        if (properties == null) {
            properties = new HashMap();
        }
        properties.put(property, value);
    }

    public Object getProperty(String property) {
        if (properties == null) {
            return new RuntimeException("What are you doing? No properties!");
        }
        return properties.get(property);
    }
}
