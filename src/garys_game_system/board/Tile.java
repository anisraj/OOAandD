package garys_game_system.board;

import java.util.LinkedList;
import java.util.List;

public class Tile {

    public Tile() {
        this.units = new LinkedList();
    }

    private List units;
    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    public List getUnits() {
        return units;
    }

    public void removeUnits() {
        units = new LinkedList();
    }
}
