import java.util.Scanner;
public class Main {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            System.out.println("1.Snake \n2.Parrot \n3.Tiger \n4.Lion \n5.Carp \n6.Arowana \n7.Monkey " +
                    "\n8.Giraffe \n9.Python \n10.Eagle \n");
            int num;
            System.out.print("Enter your choice : ");
            num = sc.nextInt();
            switch (num){
                case 1:
                    Snake snake = new Snake(12 , 12 , "black");
                    System.out.println(snake.getType());
                    snake.speed();
                    snake.action();
                    snake.ecosystem();
                    System.out.println("Is it dangerous ? " + snake.dangerous());
                    break;
                case 2:
                    Parrot parrot = new Parrot(10 , 10 , "Yellow");
                    System.out.println(parrot.getType());
                    parrot.action();
                    parrot.ecosystem();
                    parrot.speed();
                    System.out.println("Is it dangerous ? " + parrot.dangerous());
                    break;
                case 3:
                    Tiger tiger = new Tiger(10 , 10 , "Orrange");
                    System.out.println(tiger.getType());
                    tiger.action();
                    tiger.ecosystem();
                    tiger.speed();
                    System.out.println("Is it dangerous ? " + tiger.dangerous());
                    break;
                case 4:
                    Lion lion = new Lion(10 , 10 , "Orrange");
                    System.out.println(lion.getType());
                    lion.action();
                    lion.ecosystem();
                    lion.speed();
                    System.out.println("Is it dangerous ? " + lion.dangerous());
                    break;
                case 5:
                    Carp carp = new Carp(10 , 10 , "White");
                    System.out.println(carp.getType());
                    carp.action();
                    carp.ecosystem();
                    carp.speed();
                    System.out.println("Is it dangerous ? " + carp.dangerous());
                    break;
                case 6:
                    Arowana arowana = new Arowana(10 , 10 , "Gold");
                    System.out.println(arowana.getType());
                    arowana.action();
                    arowana.ecosystem();
                    arowana.speed();
                    System.out.println("Is it dangerous ? " + arowana.dangerous());
                    break;
                case 7:
                    Monkey monkey = new Monkey(10 ,10 , "Brown");
                    System.out.println(monkey.getType());
                    monkey.action();
                    monkey.ecosystem();
                    monkey.speed();
                    System.out.println("Is it dangerous ? " + monkey.dangerous());
                    break;
                case 8:
                    Giraffe giraffe = new Giraffe(10 ,10 , "Orrange");
                    System.out.println(giraffe.getType());
                    giraffe.action();
                    giraffe.ecosystem();
                    giraffe.speed();
                    System.out.println("Is it dangerous ? " + giraffe.dangerous());
                    break;
                case 9:
                    Python python = new Python(10 ,10 , "Black");
                    System.out.println(python.getType());
                    python.action();
                    python.ecosystem();
                    python.speed();
                    System.out.println("Is it dangerous ? " + python.dangerous());
                    break;
                case 10:
                    Eagle eagle = new Eagle(10 ,10 , "Brown");
                    System.out.println(eagle.getType());
                    eagle.action();
                    eagle.ecosystem();
                    eagle.speed();
                    System.out.println("Is it dangerous ? " + eagle.dangerous());
                    break;
            }
        }
    }
