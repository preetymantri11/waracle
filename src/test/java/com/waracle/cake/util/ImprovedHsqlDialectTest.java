package com.waracle.cake.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImprovedHsqlDialectTest {

    @InjectMocks
    ImprovedHsqlDialect improvedHsqlDialect;

    @Test
    public void getDropSequenceStringSuccess() {
        assertEquals("drop sequence if exists test", improvedHsqlDialect.getDropSequenceString("test"));
    }

    @Test
    public void getDropSequenceStringFailure() {
        assertNotEquals("drop sequence if exists test1", improvedHsqlDialect.getDropSequenceString("test"));
    }

    @Test
    public void dropConstraints() {
        assertFalse(improvedHsqlDialect.dropConstraints());
    }
}