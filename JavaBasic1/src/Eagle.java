import java.util.Scanner;

public class Eagle extends Animals {

    Scanner sc = new Scanner(System.in);

    public Eagle(double length, int age, String color) {
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
        type = "Eagle";
        return type;
    }

    @Override
    public void action() {
        System.out.println("Fly");
    }

    @Override
    public void ecosystem() {
        System.out.println("Sky");
    }


    @Override
    public void speed() {
        System.out.println("Speed: 20m/s");
    }

    @Override
    public boolean dangerous() {
        return false;
    }
}
