package integrationtests;

import hello.MathOperation;
import hello.MathOperationController;
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
@SpringBootTest(classes = MathOperationController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class MathOperationIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort

    @Test
    public void resultado_soma_deve_ser_status_200() {
        MathOperation mathOperation = new MathOperation(2, 3, 3);
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?numberOne="+
                mathOperation.getNumberOne()+"&numberTwo="+mathOperation.getNumberTwo(), String.class);
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }
}
