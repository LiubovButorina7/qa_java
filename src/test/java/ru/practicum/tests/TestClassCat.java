package ru.practicum.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import util.Constants;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestClassCat {
    @Mock
    Feline felineMock;

    @Test
    public void testCatGetSoundReturnsCorrectValue() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String errorMessage = String.format("Кот должен издавать звук: %s", Constants.CAT_SOUND);
        assertEquals(errorMessage, Constants.CAT_SOUND, cat.getSound());
    }

    @Test
    public void testCatGetFoodReturnsCorrectFood() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(Constants.FELINE_FOOD_LIST);
        String errorMessage = String.format("У кота должна быть следующая еда: %s", Constants.FELINE_FOOD_LIST);
        assertEquals(errorMessage, Constants.FELINE_FOOD_LIST, cat.getFood());
    }
}

