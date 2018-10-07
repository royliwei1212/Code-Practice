package tech.saltyegg.leetcode;

import org.junit.Test;

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
        if (s == null || s.isEmpty()) return null;

        String[] sp = s.split("\\+|(?=-)");
        int a = 0;
        int b = 0;
        for (String x : sp) {
            if (x.charAt(x.length() - 1) == 'x') {
                String sub = x.substring(0, x.length() - 1);

                if (sub.isEmpty() || sub.equals("-")) {
                    a += sub.isEmpty() ? 1 : -1;
                } else {
                    a += Integer.parseInt(sub);
                }
            } else {
                b += Integer.parseInt(x);
            }
        }
        return new Expression(a, b);
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

        public Expression(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    @Test
    public void test() {
        solveEquation("x+5-3+x=6+x-2");
    }
}
