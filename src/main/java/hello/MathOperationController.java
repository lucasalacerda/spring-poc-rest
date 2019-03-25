package hello;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathOperationController {

    private static final String template = "The sum of the two number is: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sum")
    public String sum(@RequestParam(value="numberOne") double numberOne,
                             @RequestParam(value="numberTwo") double numberTwo) {

        MathOperation math = new MathOperation(counter.incrementAndGet(), numberOne, numberTwo);
        return  String.format(template, math.sumNumber());
    }

}
