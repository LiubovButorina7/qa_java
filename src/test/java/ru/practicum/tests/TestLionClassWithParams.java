package ru.practicum.tests;

import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.Constants;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestLionClassWithParams {
    private final boolean hasMane;
    private final String lionSex;

    public TestLionClassWithParams(boolean hasMane, String lionSex) {
        this.hasMane = hasMane;
        this.lionSex = lionSex;
    }

    @Parameterized.Parameters(name = "Тестовые данные {index}: {0} {1}" )
    public static Object[][] getTestData() {
        return new Object[][] {
                { true, Constants.LION_MALE },
                { false, Constants.LION_FEMALE }
        };
    }
    @Test
    public void testLionDoesHaveManeReturnsCorrectBooleanValue() throws Exception {
        Predator feline = new Feline();
        Lion lion = new Lion(feline, lionSex);
        String errorMessage = Constants.LION_MALE.equals(lionSex) ? "Самец льва должен иметь гриву" : "У самки льва гривы нет";
        assertEquals(errorMessage, hasMane, lion.doesHaveMane());
    }

}
