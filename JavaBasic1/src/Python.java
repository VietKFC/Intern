import java.util.Scanner;

public class Python extends Animals {
    Scanner sc = new Scanner(System.in);

    public Python(double length, int age, String color) {
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
        type = "Python";
        return type;
    }

    @Override
    public void action() {
        System.out.println("Crawl");
    }

    @Override
    public void ecosystem() {
        System.out.println("Ground");
    }


    @Override
    public void speed() {
        System.out.println("Speed: 10m/s");
    }

    @Override
    public boolean dangerous() {
        return true;
    }
}
