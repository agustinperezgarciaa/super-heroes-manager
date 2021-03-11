//package integration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.web.context.WebApplicationContext;
//import superheroManager.SuperheroManagerMainApp;
//import superheroManager.controller.SuperheroRestController;
//import superheroManager.model.Superhero;
//import superheroManager.repository.SuperheroRepository;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
////@RunWith(SpringRunner.class)
////@ContextConfiguration(classes={superheroManager.SuperheroManagerMainApp.class})
////@AutoConfigureMockMvc
////@WebMvcTest(superheroManager.controller.SuperheroRestController.class)
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(classes = {
////        superheroManager.repository.SuperheroRepository.class,
////        superheroManager.service.SuperheroServiceImp.class
////})
////@WebMvcTest(superheroManager.controller.SuperheroRestController.class)
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes={superheroManager.SuperheroManagerMainApp.class,
////        superheroManager.repository.SuperheroRepository.class,
////        superheroManager.service.SuperheroServiceImp.class
////
////})
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
////        classes={superheroManager.SuperheroManagerMainApp.class})
////@AutoConfigureMockMvc
//
//
////@RunWith(SpringRunner.class)
////@SpringBootTest
////@SpringBootConfiguration
////@AutoConfigureMockMvc
////@WebMvcTest(superheroManager.controller.SuperheroRestController.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@AutoConfigureMockMvc //need this in Spring Boot test
//
////@RunWith(SpringRunner.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = superheroManager.SuperheroManagerMainApp.class)
////@ActiveProfiles(profiles = "test")
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@WebAppConfiguration
////@ContextConfiguration(classes={superheroManager.SuperheroManagerMainApp.class})
////@WebMvcTest(superheroManager.controller.SuperheroRestController.class)
//
//
//@SpringBootTest(classes = SuperheroManagerMainApp.class,
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class SuperheroRestControllerTest {
//
//    @LocalServerPort
//    private int port = 8080;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
////    @Sql({"V1_1__create_superhero_table.sql" })
//    @Test
//    public void testAllEmployees() {
//        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getHeroes", String.class), "1");
//    }
//
//
////    @Autowired
////    MockMvc mockMvc;
////
////    @Autowired
////    protected WebApplicationContext wac;
////
////    @Autowired
////    SuperheroRestController SuperheroRestController;
//
////    @Mock
////    private SuperheroRepository superheroRepository;
//
////    @Before
////    public void setup() throws Exception {
////        this.mockMvc = standaloneSetup(this.SuperheroRestController).build();// Standalone context
////        // mockMvc = MockMvcBuilders.webAppContextSetup(wac)
////        // .build();
////    }
////    @Autowired
////    private ObjectMapper objectMapper;
//
//
////    @Test
////    public void registrationWorksThroughAllLayers() throws Exception {
////        UserResource user = new UserResource("Zaphod", "zaphod@galaxy.net");
//
////        mockMvc.perform(MockMvcRequestBuilders
////                .get("/getHeroes")
////                .accept(MediaType.APPLICATION_JSON))
////                .andDo(print())
////                .andExpect(status().isOk());
////                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
////                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
//
////        mockMvc.perform(get("/getHeroes", 42L)
////                .contentType("application/json")
////                .andDo(print())
////                .andExpect(status().isOk());
//
////        UserEntity userEntity = userRepository.findByName("Zaphod");
////        assertThat(userEntity.getEmail()).isEqualTo("zaphod@galaxy.net");
//    }
//
////}
