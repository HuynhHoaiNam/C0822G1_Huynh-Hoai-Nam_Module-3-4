public class Calculator {
    public static double MethodCalculation(double numberFist, String operator, double numberSecond) {
        switch (operator) {
            case "+":
                return numberFist + numberSecond;
            case "-":
                return numberFist - numberSecond;
            case "*":
                return numberFist * numberSecond;
            case "/":
                if (numberSecond != 0) {
                    return numberFist / numberSecond;
                } else {
                    throw new ArithmeticException("Không thể chia cho 0");
                }
            default:
                throw new RuntimeException("Phép chia không hợp lệ");
        }
    }
}
