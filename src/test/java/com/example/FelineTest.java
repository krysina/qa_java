package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline f;

    @Before
    public void setUp() {
    }

    @Test
    public void eatMeatResult() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = f.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodInteraction() throws Exception {
        f.eatMeat();
        // Проверяем, что метод getFood() был вызван один раз
        Mockito.verify(f, Mockito.times(1)).getFood("Хищник");
    }


    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = f.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensInteraction() {
        f.getKittens();
        // Проверяем, что внутри метода getKittens() без параметров был вызван getKittens(1) 1 раз
        Mockito.verify(f, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensResultWithCount() {
        int expectedCount = 5;
        int actualCount = f.getKittens(expectedCount);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testGetKittensResultWithoutCount() {
        int expectedCount = 1;
        int actualCount = f.getKittens();
        assertEquals(expectedCount, actualCount);
    }
}