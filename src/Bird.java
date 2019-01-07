public abstract class Bird implements PhysicalTraits, PersonalityTraits {

        public int numberOfLegs() {
            return 2;
        }

        public int numberOfWings() {
            return 2;
        }

        public int numberOfFins() {
            return 0;
        }

        public boolean hasATail() {
            return true;
        }

        public abstract String exterior();

        public abstract String communicate();

        public abstract String move();

        public abstract String eat();

        public abstract String dance();

}


