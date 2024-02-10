package QAGU._11_Less_OOP.data;

public class UnionPayCard extends Card {
    public UnionPayCard() {
        super(PaymentSystem.UNION_PAY);
    }

    protected boolean isCountryValidForTheseCard(Country country) {

        if (country == Country.CN) {
            return true;
        } else {
            return false;
        }
    }
}
