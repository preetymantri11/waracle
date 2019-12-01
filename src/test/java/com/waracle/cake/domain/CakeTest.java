package com.waracle.cake.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CakeTest {

    @InjectMocks
    Cake cake;

    @Test
    public void testAllGetterAsNull() {
        assertNull(cake.getId());
        assertNull(cake.getTitle());
        assertNull(cake.getImage());
        assertNull(cake.getDesc());
    }

    @Test
    public void testAllSetter() {
        cake.setDesc("here we go");
        cake.setTitle("here");
        cake.setImage("http://image");
        assertNull(cake.getId());
        assertEquals("here", cake.getTitle());
        assertEquals("http://image", cake.getImage());
        assertEquals("here we go", cake.getDesc());
    }

}