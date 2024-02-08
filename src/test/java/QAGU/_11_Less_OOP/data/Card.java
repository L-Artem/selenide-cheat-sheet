package QAGU._11_Less_OOP.data;

public abstract class Card {

    String cardHolder;
    int balance;
    String cardNumber;
    PaymentSystem paymentSystem;


    void abstract payInCountry(Country country, int amount);
}
