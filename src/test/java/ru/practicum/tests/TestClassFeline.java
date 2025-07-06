package ru.practicum.tests;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import util.Constants;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestClassFeline {

    @Spy
    private Feline feline;

    @Test
    public void testFelineEatMeatReturnsCorrectFood() throws Exception {
        String errorMessage = String.format("У кошачьих должна быть следующая еда: %s", Constants.FELINE_FOOD_LIST);
        assertEquals(errorMessage, Constants.FELINE_FOOD_LIST, feline.eatMeat());
    }

    @Test
    public void testFelineGetFamilyReturnsCorrectValue() throws Exception {
        String errorMessage = String.format("У кошачьих должно быть семейство: '%s'", Constants.FELINE_FAMILY);
        assertEquals(errorMessage, Constants.FELINE_FAMILY, feline.getFamily());
    }

    @Test
    public void testFelineGetKittensWithParamReturnsParamValue() throws Exception{
        String errorMessage = String.format("Переданное количество детенышей %s должно совпадать с возвращенным", Constants.FELINE_AMOUNT);
        assertEquals(errorMessage, Constants.FELINE_AMOUNT, feline.getKittens(Constants.FELINE_AMOUNT));
    }

    @Test
    public void testFelineGetKittensWithNoParamReturnsDefaultValue() throws Exception{
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(Constants.FELINE_AMOUNT_DEFAULT);
    }

}
