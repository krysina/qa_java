package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline mockFeline;

    private Lion l;

    @Before
    public void setup() throws Exception {
        when(mockFeline.getKittens()).thenReturn(2);
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void testGetKittensLionWithMane() throws Exception {
        Lion l = new Lion("Самец", mockFeline);
        // Проверка результата
        assertEquals(2, l.getKittens());
    }

    @Test
    public void testGetKittensLionWithoutMane() throws Exception {
        Lion l = new Lion("Самка", mockFeline);
        // Проверка результата
        assertEquals(2, l.getKittens());
    }

    @Test
    public void testGetKittensInteraction() throws Exception {
        Lion l = new Lion("Самец", mockFeline);
        l.getKittens();
        // Проверяем, что был вызван метод getKittens()
        Mockito.verify(mockFeline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testDoesHaveManeWithMane() throws Exception {
        Lion l = new Lion("Самец", mockFeline);
        boolean sex = l.doesHaveMane();
        assertTrue(sex);
    }

    @Test
    public void testDoesHaveManeWithoutMane() throws Exception {
        Lion l = new Lion("Самка", mockFeline);
        boolean sex = l.doesHaveMane();
        assertFalse(sex);
    }

    @Test
    public void testGetFoodResultWithMane() throws Exception {
        Lion l = new Lion("Самец", mockFeline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = l.getFood();
        // Проверяем результат
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodResultWithoutMane() throws Exception {
        Lion l = new Lion("Самка", mockFeline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = l.getFood();
        // Проверяем результат
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodInteraction() throws Exception {
        Lion l = new Lion("Самец", mockFeline);
        l.getFood();
        // Проверяем, что был вызван метод getFood("Хищник")
        Mockito.verify(mockFeline, Mockito.times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testDoesHaveManeInvalidSex() throws Exception {

        Lion l = new Lion("Незнакомый пол", mockFeline);
    }
}