package main4.task1;

import java.util.ArrayList;
import java.util.List;


public class Account {

    private final List<Payment> payments;

    private final List<Income> incomes;

    private final List<Withdrawal> withdrawals;

    private final long id;

    private long money;

    public Account(List<Payment> payments, List<Income> incomes, List<Withdrawal> withdrawals, long id, long money) {
        this.payments = payments;
        this.incomes = incomes;
        this.withdrawals = withdrawals;
        this.id = id;
        this.money = money;
    }

    public Account(long money, long id) {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), id, money);
    }

    public void withdraw(long money) {
        withdrawals.add(new Withdrawal(money));
        this.money -= money;
    }

    public void pay(Account destination, long payment) {
        payments.add(new Payment(destination, payment));
        destination.incomes.add(new Income(this, payment));
        this.money -= payment;
        this.money += payment;
    }

    @Override
    public String toString() {
        return "Account{" +
                "payments=" + payments +
                ", incomes=" + incomes +
                ", withdrawals=" + withdrawals +
                ", money=" + money +
                '}';
    }

    private record Payment(Account destination, long money) {

        @Override
        public String toString() {
            return "Payment{" +
                    "destination=" + destination.id +
                    ", money=" + money +
                    '}';
        }
    }

    private record Income(Account source, long money) {

        @Override
        public String toString() {
            return "Income{" +
                    "source=" + source.id +
                    ", money=" + money +
                    '}';
        }
    }

    private record Withdrawal(long money) {

    }
}
