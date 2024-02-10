package QAGU._11_Less_OOP.data;

public class MirCard extends Card {
    public MirCard() {
        super(PaymentSystem.MIR);
    }
    protected boolean isCountryValidForTheseCard(Country country) {

        if (country == Country.RU) {
            return true;
        } else {
            return false;
        }
    }
}

