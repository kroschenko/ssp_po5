package main4.task1;

public class App1 {

    public static void main(String[] args) {
        var zero = new Account(1000, 0);
        var one = new Account(2000, 1);
        zero.pay(one, 100);
        one.pay(zero, 1000);
        zero.withdraw(170);
        System.out.println(zero);
        System.out.println(one);
    }
}
