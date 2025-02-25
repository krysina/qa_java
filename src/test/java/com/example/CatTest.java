package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat c;

    @Before
    public void setUp() {
        c = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        String sound = c.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFoodResult() throws Exception {
        // Настроим поведение мока
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);
        // Выполняем действие
        List<String> actualFood = c.getFood();
        // Проверяем результат
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testEatMeatInteraction() throws Exception {
        c.getFood();
        // Проверяем, что метод eatMeat() был вызван один раз
        Mockito.verify(mockFeline, Mockito.times(1)).eatMeat();
    }


}