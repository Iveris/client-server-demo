package com.warneriveris.server;

import com.warneriveris.server.data.dao.KittyRepository;
import com.warneriveris.server.data.dto.KittyDto;
import com.warneriveris.server.data.entity.Kitty;
import com.warneriveris.server.data.validation.ObjectValidator;
import com.warneriveris.server.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@TestConfiguration
@Import(ObjectValidator.class)
public class TestConfig {

    @Bean
    ObjectValidator<Kitty> kittyValidator(){
        return new ObjectValidator<>();
    }
    @Bean
    ObjectValidator<KittyDto> kittyDtoValidator(){
        return new ObjectValidator<>();
    }

}
