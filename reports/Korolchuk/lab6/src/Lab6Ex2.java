package com.spp.labs;

import java.util.Scanner;

public class Lab6Ex2 {
    public static void main(String[] args) {
        UniversalCard userUniversalCard = new BankCardDecorator(
                                        new DriversLicenseDecorator(
                                            new Card("Korolchuk Artyom Sergeevich"), "B"), "1111 2222 3333 4444", 100, "1234");
        
        userUniversalCard.printInfo();
        
        Card userCard = new Card("Korolchuk Artyom Sergeevich");
        Decorator userDecorator = new Decorator(userCard);
        BankCardDecorator userBankCard = new BankCardDecorator(userDecorator, "1111 2222 3333 4444", 100, "1234");
        
        userBankCard.pay("Cheesburger", 1500);
        userBankCard.workForSalary();
        userBankCard.workForSalary();
        userBankCard.pay("Cheesburger", 1500);
    }
}

interface UniversalCard {
    public void printInfo();
}

class Card implements UniversalCard {
    private String info;
    
    Card(String info) {
        this.info = info;
    }
    
    public void printInfo() {
        System.out.println("FIO: " + this.info);
    }
}

class Decorator implements UniversalCard {
    UniversalCard card;
    
    public Decorator(UniversalCard card) {
        this.card = card;
    }
    
    public void printInfo() {
        card.printInfo();
    }
}

class PassportDecorator extends Decorator {
    private String passportNumber;
    
    public PassportDecorator(UniversalCard card, String passportNumber) {
        super(card);
        
        this.passportNumber = passportNumber;
    }
    
    public void printInfo() {
        super.printInfo();
        
        System.out.println("Passport number: " + this.passportNumber);
    }
    
    public void showPassport() {
        System.out.println("You showed your passport");
    }
}

class BankCardDecorator extends Decorator {
    private String bankCardNumber;
    private int cash;
    private String pin;
    
    public BankCardDecorator(UniversalCard card, String bankCardNumber, int cash, String pin) {
        super(card);
        
        this.bankCardNumber = bankCardNumber;
        this.cash = cash;
        this.pin = pin;
    }
    
    public void printInfo() {
        super.printInfo();
        
        System.out.println("Bank card number: " + this.bankCardNumber);
    }
    
    public void pay(String thing, int price) {
        Scanner scanner = new Scanner("Enter pin: ");
        String s = scanner.nextLine();
        
        if (s.equals(this.pin)) {
            System.out.println("Incorrect pin");
        }
        else {
            if (cash >= price) {
                this.cash -= price;
                
                System.out.println("You paid for " + thing);
                System.out.println("Your current cash: " + this.cash);
            }
            else {
                System.out.println("You don't have enough cash to pay for " + thing);
                System.out.println("Your current cash: " + this.cash);
            }
        }
    }
    
    public void workForSalary() {
        this.cash += 1000;
        
        System.out.println("You earned 1000");
        System.out.println("Your current cash: " + this.cash);
    }
}

class DriversLicenseDecorator extends Decorator {
    private String licenseCategory;

    public DriversLicenseDecorator(UniversalCard card, String licenseCategory) {
        super(card);
        
        this.licenseCategory = licenseCategory;
    }
    
    public void printInfo() {
        super.printInfo();
        
        System.out.println("Driver's license category: " + this.licenseCategory);
    }
    
    public void getDriversLicense(String licenseCategory) {
        this.licenseCategory += ", " + licenseCategory;
        
        System.out.println("You got driver's license category " + licenseCategory + ". Congratulations!");
    }
}
