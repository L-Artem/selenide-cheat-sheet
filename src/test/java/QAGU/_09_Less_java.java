package QAGU;

public class _09_Less_java {

    public static void main(String[] args) {

        //наименование пакетов

        //Типы данных (примитивные)
        //Логический
        boolean varBoolean = true; // значение по умолчанию false
        //Целочисленный (числовой литерал)
        byte varByte = 100; //8 бит  -128...127  (-2^7...2^7-1) два в седьмой степени минус один
        short varShort = 10; //16 бит -321768...321767
        int varInt = 100_000; //32 бит -2 147 483 648...2 147 483 647
        long varLong = 0L; //64 бит
        //var Avar = 10; с 10 джавы

        //Числа с плавающей точкой
        float varFloat = 0.0F; //32 бит
        double varDouble = 0.0; //64 бит
        //Символ (символьный литерал)
        char varChar = 'f'; //16 бит от 0...65536 по сути тоже число
        // BigInteger
        // BigDecimal

        // Строковый литерал
        String varString = "selenide";

        // ОПЕРАТОРЫ
        // математические
        // целочисленное деление
        int res = 5 / 3; // будет 1
        // остаток от деления
        int res2 = 5 % 3; // будет 2
        // инкременты декременты префикс постфикс, используются только с переменными
        int res3 = varInt++; // вернет значение до того как прибавит единицу
        res3 += 1;
        res3 = ++varInt;

        // Операторы сравнения

        //Логические операторы
        String coinCurrency=null;
        if(coinCurrency!= null & coinCurrency.equals("RUB")){}//nullPointer
        if(coinCurrency!= null && coinCurrency.equals("RUB")){}//ok

    }
}

