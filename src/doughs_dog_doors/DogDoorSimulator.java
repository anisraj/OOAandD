package doughs_dog_doors;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("Woof"));
        door.addAllowedBark(new Bark("rawlf"));
        BarkRecognizer recognizer = new BarkRecognizer(door);


        System.out.println("Fido barks to go outside...");
        System.out.println("\nFido starts barking....");

        recognizer.recognize(new Bark("Woof"));

        System.out.println("\nFido has gone outside...");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFido is all done...");

        System.out.println("\nbut he is stuck outside...");

        Bark smallDogBark = new Bark("aa uu");
        System.out.println("A small dog started barking");
        recognizer.recognize(smallDogBark);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nFido starts barking....");
        recognizer.recognize(new Bark("rawlf"));

    }
}
