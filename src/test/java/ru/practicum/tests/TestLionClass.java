package ru.practicum.tests;

import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import util.Constants;
import static org.junit.Assert.*;

public class TestLionClass {
    private Predator feline;

    @Before
    public void initialize() {
        feline = new Feline();
    }

    @Test
    public void testLionConstructorWithWrongSexValueReturnsErrorMessage() throws Exception {
        Throwable exception = assertThrows(Exception.class, () -> {
            new Lion(feline, Constants.LION_WRONG_SEX);
        });
        assertTrue(exception.getMessage().contains(Constants.LION_INIT_ERROR_MESSAGE));
    }

    @Test
    public void testLionGetFoodReturnsCorrectFood() throws Exception {
        Predator feline = new Feline();
        Lion lion = new Lion(feline, Constants.LION_MALE);
        String errorMessage = String.format("У льва должна быть следующая еда: %s", Constants.FELINE_FOOD_LIST);
        assertEquals(errorMessage, Constants.FELINE_FOOD_LIST, lion.getFood());
    }

    @Test
    public void testLionGetKittensReturnsDefaultAmount() throws Exception {
        Predator feline = new Feline();
        Lion lion = new Lion(feline, Constants.LION_MALE);
        String errorMessage = String.format("У льва количество детенышей должно быть: %s", Constants.FELINE_AMOUNT_DEFAULT);
        assertEquals(errorMessage, Constants.FELINE_AMOUNT_DEFAULT, lion.getKittens());
    }
}
