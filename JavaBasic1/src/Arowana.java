import java.util.Scanner;

public class Arowana extends Animals {
    Scanner sc = new Scanner(System.in);

    public Arowana(double length, int age, String color) {
        super(length, age, color);
    }


    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String getType() {
        type = "Arowana";
        return type;
    }

    @Override
    public void action() {
        System.out.println("Swim");
    }

    @Override
    public void ecosystem() {
        System.out.println("Water");
    }


    @Override
    public void speed() {
        System.out.println("Speed: 15m/s");
    }

    @Override
    public boolean dangerous() {
        return false;
    }
}
