package doughs_dog_doors;

public class BarkRecognizer {
    private DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognize(Bark bark) {
        System.out.println("   BarkRecognizer: Heard a '" + bark.getSound() + "'");
        for (Bark allowedBark : door.getAllowedBarks()) {
            if (allowedBark.matches(bark)) {
                door.open();
                return;
            }
        }
        System.out.println("This dog is not allowed.");
    }
}
