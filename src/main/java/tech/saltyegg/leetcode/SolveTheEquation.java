package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class SolveTheEquation {

    //"x+5-3+x=6+x-2" -> "x=2"
    public String solveEquation(String equation) {
        if (equation == null || equation.isEmpty() || !equation.contains("=")) return null;

        String IS = "Infinite solutions";
        String NS = "No solution";

        String[] splits = equation.split("=", -1);

        Expression left = parse(splits[0]);
        Expression right = parse(splits[1]);

        if (left.a == right.a) return left.b != right.b ? NS : IS;

        return "x=" + (right.b - left.b) / (left.a - right.a);
    }

    private Expression parse(String s) {
        Expression result = new Expression();

        String[] split1 = s.split("\\+");
        for (String str : split1) {
            String[] split2 = str.split("(?=-)");
            for (String x : split2) {
                if (x == null || x.isEmpty()) continue;
                if (x.contains("x")) {
                    String sub = x.substring(0, x.length() - 1);
                    if (sub.isEmpty() || sub.equals("-")) {
                        result.addX(sub.isEmpty() ? 1 : -1);
                    } else {
                        result.addX(Integer.parseInt(sub));
                    }

                } else {
                    result.add(Integer.parseInt(x));
                }
            }
        }

        return result;
    }

    private static class Expression {
        int a = 0;
        int b = 0;

        void addX(int a) {
            this.a += a;
        }

        void add(int b) {
            this.b += b;
        }
    }
}
