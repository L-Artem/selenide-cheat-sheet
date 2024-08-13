package test1;

public class finalTest {

    public static final String finalName=getName();

    final String finalSecondName;

    public finalTest(){
        finalSecondName = getFinalSecondName();
    }
    public static void main(String[] args) {
        System.out.println(finalName);
        System.out.println(new finalTest().getFinalSecondName());
    }


    private static String getName(){
        return "Ivan";
    }

    private String getFinalSecondName(){
        return "Ivanov";
    }


}

