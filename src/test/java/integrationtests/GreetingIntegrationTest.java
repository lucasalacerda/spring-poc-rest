package integrationtests;

import hello.Greeting;
import hello.GreetingController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GreetingController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class GreetingIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    //@MockBean
    //private MathOperationRepository mathOperationRepository; Mocka o DB. Quando o crud é feito, não é salvo no DB real.

    //@Autowired
    //private MockMvc mockMvc; //Podemos usar restTemplate ou mockMvc. Precisa da @AutoConfigureMockMvc p/ funcionar
/*
    @EnableAutoConfiguration
    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
//            return new RestTemplateBuilder().basicAuthorization("asd", "asd");
            return new RestTemplateBuilder();
        }
    }
    */

    @Test
    public void get_greeting_deve_ser_status_200() {
        Greeting greetig = new Greeting(1, "Lucas");
//        BDDMockito.when(greetig).thenReturn(greetig);
        ResponseEntity<String> response = restTemplate.getForEntity("/greeting?name="+greetig.getContent(), String.class);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);

        System.out.println("hello");
    }
}
