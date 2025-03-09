package com.warneriveris.server;

import com.warneriveris.server.api.controller.KittyController;
import com.warneriveris.server.data.dao.KittyRepository;
import com.warneriveris.server.service.DataService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {"spring.profiles.active=secrets"})
class ServerApplicationTests {

	@Test
	void contextLoads(ApplicationContext context) {
		assertNotNull(context.getBean(KittyRepository.class));
		assertNotNull(context.getBean(DataService.class));
		assertNotNull(context.getBean(KittyController.class));
	}

}
