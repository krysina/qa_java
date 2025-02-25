package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    private Feline mockFeline;

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
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveManeValidSex() throws Exception {
            // Проверка наличия гривы для известного пола
            Lion lion = new Lion(sex, mockFeline);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void testDoesHaveManeInvalidSex() throws Exception {
        // Проверка наличия гривы для неизвестного пола
        String invalidSex = "Незнакомый пол";
        assertThrows(Exception.class, () -> new Lion(invalidSex, mockFeline));
    }

}