package ru.practicum.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import util.Constants;
import static org.junit.Assert.*;

public class TestLionClass {
    private Feline feline;

    @Before
    public void initialize() {
        feline = new Feline();
    }

    @Test
    public void testLionConstructorWithWrongSexValueReturnsErrorMessage() throws Exception {
        Throwable exception = assertThrows(Exception.class, () -> {
            new Lion(Constants.LION_WRONG_SEX, feline);
        });
        assertTrue(exception.getMessage().contains(Constants.LION_INIT_ERROR_MESSAGE));
    }

    @Test
    public void testLionGetFoodReturnsCorrectFood() throws Exception {
        Lion lion = new Lion(Constants.LION_MALE, feline);
        String errorMessage = String.format("У льва должна быть следующая еда: %s", Constants.FELINE_FOOD_LIST);
        assertEquals(errorMessage, Constants.FELINE_FOOD_LIST, lion.getFood());
    }

    @Test
    public void testLionGetKittensReturnsDefaultAmount() throws Exception {
        Lion lion = new Lion(Constants.LION_MALE, feline);
        String errorMessage = String.format("У льва количество детенышей должно быть: %s", Constants.FELINE_AMOUNT_DEFAULT);
        assertEquals(errorMessage, Constants.FELINE_AMOUNT_DEFAULT, lion.getKittens());
    }
}
