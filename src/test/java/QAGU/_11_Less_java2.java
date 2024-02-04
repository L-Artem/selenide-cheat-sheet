package QAGU;

public class _11_Less_java2 {

    public static void main(String[] args) {

        //QA.GURU.Advansed
        //0) прочитать про коллекции - начать с базовой иерархии https://habr.com/ru/post/237043/
        //1) ArrayList https://habr.com/ru/post/128269/
        //2) HashMap https://habr.com/ru/post/128017/
        //3) https://www.youtube.com/watch?v=UufkoVcMnX8- занятие по ООП от меня

        // Массивы
        int[] arr1 = new int[3];
        int[] arr2 = new int[]{100, 200, -1, 90};
        int[] arr3 = {100, 200, -1, 90};
        int[][] arrArr1 = {arr2, arr3};

        System.out.println("print 200 " + arr3[1]);
        arr3[1] = 222;
        //Array
        //Arrays
        String[] arrStr1 = new String[]{"Dima", "Ivan"};

        //Циклы
        // исходные условия : пока тру выполнять : выполнить после каждой итерации
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("for break " + arr3[i]);
            if (arr3[i] == -1) {
                break;
            }

        }

        System.out.println("");
        System.out.println("=== CONTINIUE");

        // === CONTINIUE;
        for (int i = 0; i < arr3.length; i++) {

            System.out.println(i + " for continue " + arr3[i]);

            if (arr3[i] == -1) {

                System.out.println(" If value is equals -1, continue");
                continue; // перейти к следующей итерации минуя дальнейший код.
            }

            System.out.println(i + " After continue" + arr3[i]);
        }

        System.out.println("");
        System.out.println("=== BREAK");
        // === BREAK
        for (int i = 0; i < arr3.length; i++) {
            System.out.println( i + " for break " + arr3[i]);
            if (arr3[i] == -1) {
                System.out.println("break === complex calculation ");
                break;  // завершить цикл
            }
            System.out.println(i + " after break " + arr3[i]);
        }

        forContinue(arr3);

        System.out.println("");
        for (int i = arr3.length - 1; i >= 0; i--) {
            System.out.println(i + " for revers " + arr3[i]);
        }

        int index = 0;
        while (index < arr3.length) {
            System.out.println(arr3[index]);
            index++;
        }

        do {
            //сделать что-то
        } while (false);

        // переменная для данных : источник данных
        for (int var : arr3) {
            System.out.println("forEach " + var);
        }


        //Коллекции

    }


    public static void forContinue(int[] arr3){

        System.out.println();
        System.out.println("METHOD CONTINUE");
        // === CONTINIUE;
        for (int i = 0; i < arr3.length; i++) {

            System.out.println(i + " for continue " + arr3[i]);

            if (arr3[i] == -1) {

                System.out.println(" If value is equals -1, return");
                return;
            }

            System.out.println(i + " After continue" + arr3[i]);
        }
    }

}
