package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculationResults(double firstValue, double secondValue, String nameCheck) {
        switch (nameCheck) {
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                if (secondValue > 0) {
                    return firstValue / secondValue;
                } else {
                    throw new RuntimeException();
                }
        }
        return 0;
    }
}
