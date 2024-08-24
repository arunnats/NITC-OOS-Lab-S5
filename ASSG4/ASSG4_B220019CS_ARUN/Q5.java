public class Q5 {
    public static void main(String[] args) {
        Puppy puppy1 = new Puppy("Buddy", 4, "Golden Retriever", "Say");
        Puppy puppy2 = new Puppy("Kaizer", 2, "German Shepard", "Wilhelm");
        puppy1.sound();
        puppy2.sound();
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Animal sound called");
        System.out.println("Name: " + this.name);
        System.out.println();
    }
}

class Mammal extends Animal {
    private int age;

    public Mammal(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public void sound() {
        super.sound();
        System.out.println("Mammal sound called");
        System.out.println("Age: " + this.age);
        System.out.println();
    }
}

class Dog extends Mammal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void sound() {
        super.sound();
        System.out.println("Dog sound called");
        System.out.println("Breed: " + this.breed);
        System.out.println();
    }
}

class Puppy extends Dog {
    private String nickName;

    public Puppy(String name, int age, String breed, String nickName) {
        super(name, age, breed);
        this.nickName = nickName;
    }

    @Override
    public void sound() {
        super.sound();
        System.out.println("Puppy sound called");
        System.out.println("NickName: " + this.nickName);
        System.out.println();
    }
}
