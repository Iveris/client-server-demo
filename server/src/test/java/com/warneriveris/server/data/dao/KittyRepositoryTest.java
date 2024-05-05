package com.warneriveris.server.data.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static com.warneriveris.server.TestConstants.Belle;
import static com.warneriveris.server.TestConstants.Bob;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext
@ActiveProfiles(value = "secrets")
@Disabled
class KittyRepositoryTest {

    @Autowired
    KittyRepository repo;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void findKittyByName() {
        // arrange
        var kitty = repo.save(Bob());

        // act
        var foundCat = repo.findKittyByName(kitty.getName()).stream().findFirst().orElseThrow();

        // assert
        assertNotNull(foundCat);
        assertEquals(kitty, foundCat);
    }

    @Test
    void findKittyByOwner() {
        // arrange
        var kitty = repo.save(Belle());

        // act
        var foundCat = repo.findKittyByOwner(kitty.getOwner()).stream().findFirst().orElseThrow();

        // assert
        assertNotNull(foundCat);
        assertEquals(kitty, foundCat);

    }

    @Test
    void findKittyByNameAndOwner() {
        // arrange
        var kitty = repo.save(Bob());

        // act
        var foundCat = repo.findKittyByNameAndOwner(kitty.getName(), kitty.getOwner()).stream().findFirst().orElseThrow();

        // assert
        assertNotNull(foundCat);
        assertEquals(kitty, foundCat);
    }
}