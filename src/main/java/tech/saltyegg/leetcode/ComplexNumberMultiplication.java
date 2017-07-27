package tech.saltyegg.leetcode;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        return multiplication(parse(a), parse(b)).toString();
    }

    private ComplexNumber parse(String a) {
        if (a == null || a.isEmpty()) {
            return new ComplexNumber();
        }
        ComplexNumber result = new ComplexNumber();
        String[] split = a.split("\\+");
        if (split.length == 1) {
            if (split[0].contains("i")) {
                result.a = 0;
                result.b = Integer.valueOf(split[0].substring(0, split[0].length() - 1));
            } else {
                result.a = Integer.valueOf(split[0]);
                result.b = 0;
            }
        } else {
            result.a = Integer.valueOf(split[0]);
            result.b = Integer.valueOf(split[1].substring(0, split[1].length() - 1));
        }
        return result;
    }

    private ComplexNumber multiplication(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = new ComplexNumber();
        result.a = a.a * b.a - a.b * b.b;
        result.b = a.a * b.b + a.b * b.a;
        return result;
    }

    private static class ComplexNumber {
        int a = 0;
        int b = 0;

        ComplexNumber() {
        }

        @Override
        public String toString() {
            /**
             if (a == 0 && b == 0) {
             return "0";
             }
             return ((a == 0) ? "" : (a + "+")) + ((b == 0) ? "" : b + "i");
             **/
            return a + "+" + b + "i";
        }
    }
}