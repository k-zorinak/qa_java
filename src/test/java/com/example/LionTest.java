package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class LionTest {

    Feline feline = Mockito.mock(Feline.class);

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getKittensLion () throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedGetKittens = 0;
        int actualGetKittens = lion.getKittens();
        assertEquals("У льва не может быть котят", expectedGetKittens, actualGetKittens);
    }

    @Test
    public void doesHaveManeLion () throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals("У льва есть грива", expectedHasMane, actualHasMane);
    }

    @Test
    public void doesHaveManeLioness () throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expectedHasMane = false;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals("У львицы нет гривы", expectedHasMane, actualHasMane);
    }

    @Test
    public void doesHaveManeException () {
        try{
            Lion lion = new Lion("Белка", feline);
        } catch(Exception exception){
            System.out.println(exception);
            String expected = "java.lang.Exception: Используйте допустимые значения пола животного — самец или самка";
            assertEquals(expected, exception.toString());
        }
    }

    @Test
    public void getFoodLion () throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
