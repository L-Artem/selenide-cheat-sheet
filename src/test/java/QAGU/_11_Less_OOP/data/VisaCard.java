package QAGU._11_Less_OOP.data;

public class VisaCard extends Card {
    public VisaCard() {
        super(PaymentSystem.VISA);
    }

    protected boolean isCountryValidForTheseCard(Country country) {
        return true;
    }
}
