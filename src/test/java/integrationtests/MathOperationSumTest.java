package integrationtests;

import hello.MathOperationController;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class MathOperationSumTest {

    @Test
    public void test_when_sum_mockito_01(){

        //teste inválido. Apenas testando o mock.
//        MathOperationController mathOperationController = Mockito.mock(MathOperationController.class);
//        Mockito.when(mathOperationController.sum(2, 2)).thenReturn("test mockito return");
//
//        String resultOfMath = mathOperationController.sum(2, 2);

        Assertions.assertEquals("1", "1");
    }

}
