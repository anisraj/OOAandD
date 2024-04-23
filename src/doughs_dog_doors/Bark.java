package doughs_dog_doors;

public class Bark {
    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public boolean matches(Bark otherBark) {
        return sound.equalsIgnoreCase(otherBark.getSound());
    }

    public String getSound() {
        return sound;
    }
}
