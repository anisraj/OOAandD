package garys_game_system.board;

public class UnitTester {

    public void testType(Unit unit, String type, String expectedOutputType) {
        System.out.println("\nTesting setting/getting the type property.");
        unit.setType(type);
        String outputType = unit.getType();
        if (expectedOutputType.equals(outputType)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed: " + outputType + "didn't match "
            + expectedOutputType);
        }
    }
}
