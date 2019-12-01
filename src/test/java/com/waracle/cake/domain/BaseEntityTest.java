package com.waracle.cake.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BaseEntityTest {

    @InjectMocks
    BaseEntity baseEntity;

    @Test
    public void getId() {
        assertNull(baseEntity.getId());
    }
}