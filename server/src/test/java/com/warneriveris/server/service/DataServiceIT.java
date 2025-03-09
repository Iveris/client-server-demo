package com.warneriveris.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;

import static com.warneriveris.server.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.profiles.active=secrets"})
class DataServiceIT {

    @Autowired
    DataService service;

    @Test
    void findKittyByName() {
        // arrange
        var kitty = service.saveKitty(BobDto());

        // act
        var foundCat = service.findKittyByName(kitty.name());

        // assert
        assertNotNull(foundCat);
        assertTrue(foundCat.stream().anyMatch(x -> x.equals(kitty)));
        foundCat.stream().forEach(cat -> service.removeKitty(cat));
    }

    @Test
    void findKittyByOwner() {

        // arrange
        var kitty = service.saveKitty(BobDto());

        // act
        var foundCat = service.findKittyByOwner(kitty.owner());

        // assert
        assertNotNull(foundCat);
        assertEquals(List.of(kitty), foundCat);
        foundCat.stream().forEach(cat -> service.removeKitty(cat));
    }

    @Test
    void findKittyByNameAndOwner() {

        // arrange
        var kitty = service.saveKitty(BobDto());

        // act
        var foundCat = service.findKittyByNameAndOwner(kitty.name(), kitty.owner());

        // assert
        assertNotNull(foundCat);
        assertEquals(List.of(kitty), foundCat);
        foundCat.stream().forEach(cat -> service.removeKitty(cat));
    }

    @Test
    void findCatByName_not_in_db_returns_empty(){
        // arrange/act
        var cat = service.findKittyByName("kitty");

        // assert
        assertEquals(Collections.emptyList(), cat);
    }
}