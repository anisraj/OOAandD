package doughs_dog_doors;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);

        System.out.println("Fido barks to go outside...");
        remote.pressButton();
        System.out.println("\nFido has gone outside...");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFido is all done...");

        System.out.println("\nbut he is stuck outside...");
        System.out.println("\nFido starts barking....");
        System.out.println("So Gina grabs the remote control....");
        remote.pressButton();
        System.out.println("\nFido is back inside...");
    }
}
