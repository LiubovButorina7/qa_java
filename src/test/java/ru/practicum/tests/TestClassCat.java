package ru.practicum.tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import util.Constants;
import static org.junit.Assert.assertEquals;

public class TestClassCat {
    private Cat cat;

    @Before
    public void initialize() {
        Feline feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void testCatGetSoundReturnsCorrectValue() throws Exception {
        String errorMessage = String.format("Кот должен издавать звук: %s", Constants.CAT_SOUND);
        assertEquals(errorMessage, Constants.CAT_SOUND, cat.getSound());
    }

    @Test
    public void testCatGetFoodReturnsCorrectFood() throws Exception {
        String errorMessage = String.format("У кота должна быть следующая еда: %s", Constants.FELINE_FOOD_LIST);
        assertEquals(errorMessage, Constants.FELINE_FOOD_LIST, cat.getFood());
    }
}

