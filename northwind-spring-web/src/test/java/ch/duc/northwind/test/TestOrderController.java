package ch.duc.northwind.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import ch.duc.northwind.config.PersistenceConfig;
import ch.duc.northwind.config.RootConfig;
import ch.duc.northwind.config.ServletConfig;

// http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration/
// http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={PersistenceConfig.class, RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class TestOrderController {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		assertNotNull(webApplicationContext);
		System.out.println("---------- Begin list of beans ----------");
		for (String beanName: webApplicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName + ": " + webApplicationContext.getBean(beanName));
		}
		System.out.println("---------- End list of beans ----------");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	 
	@Test
	public void testGetRecentOrders() throws Exception {
		ResultActions get = mockMvc.perform(MockMvcRequestBuilders.get("/orders"));
		get.andExpect(MockMvcResultMatchers.model().attributeExists("orderList"));
	}
}
