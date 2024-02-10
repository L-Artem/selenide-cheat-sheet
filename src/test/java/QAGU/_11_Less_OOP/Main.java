package QAGU._11_Less_OOP;

import QAGU._11_Less_OOP.data.Card;
import QAGU._11_Less_OOP.data.UnionPayCard;

import static QAGU._11_Less_OOP.data.Country.RU;

// 1:13:30 - ENUM
//https://www.youtube.com/watch?v=UufkoVcMnX8#t=01h13m30s
// Изучаем Java - Сьерра Кэти и Бэйтс Берт  ООП
// Философия Java. 4-е полное изд. | Эккель Брюс
// Java: эффективное программирование | Блох Джошуа

public class Main {
    public static void main(String[] args) {
        invoke(new UnionPayCard());

        System.out.println();
        System.out.println(RU.getRusCountryName());
    }

    public static void invoke(Card card){
        card.setBalance(100);
        card.payInCountry(RU, 75);
        System.out.println("Баланс: " + card.getBalance());
    }
}
