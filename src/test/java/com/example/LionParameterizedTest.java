package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final Boolean expectedHasMane;

    public LionParameterizedTest(String sex, Boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testParameters() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Незнакомый пол", null}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        // Создание реального объекта Feline
        Feline feline = new Feline();

        // Создание льва
        if (expectedHasMane != null) {
            // Проверка наличия гривы для известного пола
            Lion lion = new Lion(sex, feline);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
        } else {
            // Проверка на исключение для неизвестного пола
            assertThrows(Exception.class, () -> new Lion(sex, feline));
        }
    }

}