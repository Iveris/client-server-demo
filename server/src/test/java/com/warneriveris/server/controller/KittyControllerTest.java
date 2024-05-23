package com.warneriveris.server.controller;

import java.util.List;
import java.util.stream.Stream;

import com.warneriveris.server.TestConfig;
import com.warneriveris.server.data.dao.KittyRepository;
import com.warneriveris.server.data.dto.KittyDto;
import com.warneriveris.server.data.entity.Kitty;
import com.warneriveris.server.data.validation.ObjectValidator;
import com.warneriveris.server.exception.ObjectValidationException;
import com.warneriveris.server.service.DataService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("secrets")
@DataJpaTest
@Import({TestConfig.class})
class KittyControllerTest {

    @Autowired
    KittyRepository kittyRepo;

    @Autowired
    ObjectValidator<Kitty> kittyValidator;

    @Autowired
    ObjectValidator<KittyDto> kittyDtoValidator;


    @ParameterizedTest
    @MethodSource("invalidKittyDtoGenerator")
    void helloKitty_givenInvalidDto_responseEntityReturnsErrorMessage(KittyDto kitty, List<String> expectedErrors){
        DataService dataService = new DataService(kittyRepo, kittyValidator, kittyDtoValidator);
        KittyController kittyController = new KittyController(dataService);
        var exception = assertThrows(ObjectValidationException.class, () -> kittyController.helloKitty(kitty));
        for(String error: expectedErrors){
            assertTrue(exception.getErrorMessages().contains(error));
        }
    }

    static Stream<Arguments> invalidKittyDtoGenerator(){
        return Stream.of(
                Arguments.of(new KittyDto("", "Tim and Jim", "Orange", 14.0, 2, ""),
                        List.of("Kitty must have a name")),
                Arguments.of(new KittyDto(null, "Tim and Jim", "Orange", 14.0, 2, ""),
                        List.of("Kitty must have a name")),
                Arguments.of(new KittyDto("Mr. Kitty", "Tim and Jim", "Orange", null, 2, ""),
                        List.of("Kitty must have a weight")),
                Arguments.of(new KittyDto("Mr. Kitty", "Tim and Jim", "Orange", 14.0, null, ""),
                        List.of("Kitty intelligence rating required")),
                Arguments.of(new KittyDto("", "Tim and Jim", "Orange", null, null, ""),
                        List.of("Kitty must have a name", "Kitty must have a weight", "Kitty intelligence rating required"))
        );
    }

}