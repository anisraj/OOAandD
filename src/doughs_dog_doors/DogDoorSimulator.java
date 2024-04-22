package doughs_dog_doors;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        System.out.println("Fido barks to go outside...");
        System.out.println("\nFido starts barking....");

        recognizer.recognize("Woof");

        System.out.println("\nFido has gone outside...");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFido is all done...");

        System.out.println("\nbut he is stuck outside...");
        System.out.println("\nFido starts barking....");
        recognizer.recognize("Woof");
        System.out.println("\nFido is back inside...");
    }
}
