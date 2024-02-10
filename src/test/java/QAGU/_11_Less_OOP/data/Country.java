package QAGU._11_Less_OOP.data;

public enum Country {
    RU("Россия"),
    CN("Китай"),
    US("Америка");

    private final String rusCountryName;

    Country(String rusCountryName){
        this.rusCountryName = rusCountryName;
    }

    public String getRusCountryName(){
        return rusCountryName;
    }
}
