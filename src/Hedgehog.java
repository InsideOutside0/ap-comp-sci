public class Hedgehog implements PhysicalTraits, PersonalityTraits {

    public int numberOfLegs() {
        return 4;
    }

    public int numberOfWings() {
        return 0;
    }

    public int numberOfFins() {
        return 0;
    }

    public boolean hasATail() {
        return false;
    }

    public String exterior() {
        return "You can't see Sonic the Hedgehog because you're too slow";
    }

    public String communicate() {
        return "YOU'RE TOO SLOW";
    }

    public String move() {
        return "You're STILL too slow!";
    }

    public String eat() {
        return "Who has time to eat? ";
    }

    public String dance() {
        return "Watch these sick moves, Tails.";
    }

}