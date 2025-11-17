public class AbstractRegularFactory {
        //Product
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
        //AbstractFactory interface
        abstract interface Organs_Factory {
            Heart createHeart(String color, String name, int blood, int probeg);
        }
        //Concrete Factory
        static class Heart_Factory implements Organs_Factory {
            public Heart createHeart(String color, String name, int blood, int probeg) {
                return new Heart(color, name, blood, probeg);
            }
        }
        //Client
        public static void main(String[] args) {
            Organs_Factory heartFactory = new Heart_Factory();
            Heart heart = heartFactory.createHeart("Red", "Dimash", 5, 1337228);
            heart.votHeart();
        }
}
