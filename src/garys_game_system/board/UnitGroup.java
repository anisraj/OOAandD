package garys_game_system.board;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UnitGroup {
    private Map units;


    public UnitGroup(List unitList) {
        units = new HashMap();
        for (Object unitObject : unitList) {
            Unit unit = (Unit) unitObject;
            units.put(unit.getId(), unit);
        }
    }

    public UnitGroup() {
        this(new LinkedList());
    }

    public void addUnit(Unit unit) {
        units.put(unit.getId(), unit);
    }

    public void removeUnit(int id) {
        units.remove(id);
    }

    public Unit getUnit(int id) {
        return (Unit) units.get(id);
    }

    public List getUnits() {
        List unitList = new LinkedList();
        for (Object unitObject : unitList) {
            unitList.add(unitObject);
        }
        return unitList;
    }
}
