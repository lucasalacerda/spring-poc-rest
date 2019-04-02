package integrationtests;

import hello.MathOperation;
import hello.MathOperationController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

public class MathOperationSumTest {

    @Test
    public void test_when_sum_mockito_01(){

        //teste inválido. Apenas testando o mock.
        MathOperationController mathOperationController = Mockito.mock(MathOperationController.class);
        Mockito.when(mathOperationController.sum(2, 2)).thenReturn("test mockito return");

        String resultOfMath = mathOperationController.sum(2, 2);

        Assertions.assertEquals("test mockito return", resultOfMath);
    }

}
