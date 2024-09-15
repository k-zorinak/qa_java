package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private  Feline feline;
    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        String expectedGetSound = "Мяу";
        String actualGetSound = cat.getSound();
        assertEquals("Кошка мяукает", expectedGetSound, actualGetSound);
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}