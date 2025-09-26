class java_real_training {

    // ====== Органы ======
    static class Liver {
        private final String color;
        private final String name;
        private final boolean hasDisease;
        private final int probeg;

        public Liver(String color, String name, boolean hasDisease, int probeg) {
            this.color = color;
            this.name = name;
            this.hasDisease = hasDisease;
            this.probeg = probeg;
        }

        public void votLiver() {
            System.out.println("This liver is " + color + ", its name is " + name + ". Unfortunately or not, the statement that it has disease is " + hasDisease + " and it already worked hard for " + probeg + " hours");
        }
    }

    static class Heart {
        private final String color;
        private final String name;
        private final int blood;
        private final int probeg;

        public Heart(String color, String name, int blood, int probeg) {
            this.color = color;
            this.name = name;
            this.blood = blood;
            this.probeg = probeg;
        }

        public void votHeart() {
            System.out.println("This heart despite of everything is: " + name + ", coloured with " + color + ", has  " + blood + ", liters of blood and " + probeg + " hours of work overall.");
        }
    }

    abstract interface Organs_Factory {
        Liver createLiver(String color, String name, boolean hasDisease, int probeg);
        Heart createHeart(String color, String name, int blood, int probeg);
    }

    static class Liver_Factory implements Organs_Factory {
        public Liver createLiver(String color, String name, boolean hasDisease, int probeg) {
            return new Liver(color, name, hasDisease, probeg);
        }
        public Heart createHeart(String color, String name, int blood, int probeg) {
            throw new UnsupportedOperationException("Of my God, Heart is not the Liver bro!!");
        }
    }

    static class Heart_Factory implements Organs_Factory {
        public Liver createLiver(String color, String name, boolean hasDisease, int probeg) {
            throw new UnsupportedOperationException("For what are you doing this? Heart is not the liver!!");
        }

        public Heart createHeart(String color, String name, int blood, int probeg) {
            return new Heart(color, name, blood, probeg);
        }
    }

    public static void main(String[] args) {
        Organs_Factory liverFactory = new Liver_Factory();
        Liver liver = liverFactory.createLiver("Brown", "Khovansky", true, 228228);
        liver.votLiver();

        Organs_Factory heartFactory = new Heart_Factory();
        Heart heart = heartFactory.createHeart("Red", "Dimash", 5, 1337228);
        heart.votHeart();
    }
}