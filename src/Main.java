import garys_game_system.board.Unit;
import garys_game_system.board.UnitTester;

public class Main {
    public static void main(String[] args) {
        UnitTester unitTester = new UnitTester();
        Unit unit = new Unit(1000);
        unitTester.testType(unit, "army", "army");
    }
}