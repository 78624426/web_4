package day2.转发与重定向;

public class Test {
    public static void main(String[] args) {
        Anaimal a=new Dog();
        Dog d=(Dog)a;
        Object r=a;
        Run f=(Run) r;
    }
}
