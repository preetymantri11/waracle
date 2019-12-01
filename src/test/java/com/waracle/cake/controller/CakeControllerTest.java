package com.waracle.cake.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CakeControllerTest {

    @InjectMocks
    private CakeController cakeController;

    @Test
    public void testGetAllCakesSuccess() {
        Assert.assertEquals("index", cakeController.getAllCakes());
    }

    @Test
    public void testGetAllCakesFailure() {
        Assert.assertNotEquals("test", cakeController.getAllCakes());
    }
}