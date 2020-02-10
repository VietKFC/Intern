public abstract class Animals {

    protected double length;
    protected int age;
    protected String color;
    protected String type;

    public Animals(double length, int age, String color) {
        this.length = length;
        this.age = age;
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getType();

    public abstract void action();
    public abstract void ecosystem();
    public abstract void speed();
    public abstract boolean dangerous();
}
