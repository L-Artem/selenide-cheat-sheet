package QAGU._11_Less_OOP;

import QAGU._11_Less_OOP.data.Card;
import QAGU._11_Less_OOP.data.VisaCard;

import static QAGU._11_Less_OOP.data.Country.RU;

public class Main {
    public static void main(String[] args) {
        Card visacard = new VisaCard();
        visacard.setBalance(100);
        visacard.payInCountry(RU,75);
        System.out.println(visacard.getBalance());

    }
}
