package QAGU;

import org.junit.jupiter.api.*;

public class _12_Less_JUnit5 {


    @Disabled("MS-13452 Причина отключения, попвдет в аллюр") // отключить тест в тест ране
    @DisplayName("Название теста, можно использовать в аллюр")
    @Test
    @Tags({@Tag("BLOCKER"), @Tag("UITEST")})
    void simpleTest() {

        Assertions.assertTrue(3>2);
    }

    @Disabled("MS-13452 Причина отключения, попвдет в алюр") // отключить тест в тест ране
    @DisplayName("Название теста, можно использовать в алюр")
    @Test
    @Tags({@Tag("BLOCKER"), @Tag("UITEST")})
    void commonParamTest(){

    }


}
