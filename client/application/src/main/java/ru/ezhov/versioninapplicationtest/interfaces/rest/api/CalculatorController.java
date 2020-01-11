package ru.ezhov.versioninapplicationtest.interfaces.rest.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ezhov.versioninapplicationtest.algorithm.api.Calculator;
import ru.ezhov.versioninapplicationtest.algorithm.defaultimplementation.CalculatorImpl;

import java.util.Random;

@RestController()
@RequestMapping("calculator")
public class CalculatorController {

    @GetMapping(path = "plus")
    public int plus() {
        Calculator calculator = new CalculatorImpl();

        return calculator.plus(new Random().nextInt(), new Random().nextInt());
    }
}
