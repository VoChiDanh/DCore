package net.danh.dcore.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.1
 */
public class Calculator {
    private static boolean isExpresstion(String s) {
        s = s.replaceAll(" ", "");
        boolean is = true;
        for (int i = 0; i < s.length(); i++) {
            if (!String.valueOf(s.charAt(i)).matches("[0-9+\\-*/%^@{}()]")) {
                is = false;
                break;
            }
        }
        return is;
    }
    private static double parsefirst (String s) {
        s = s.replaceAll(" ", "");
        if (s.startsWith("@")) {
            int sqrt = 0;
            int open = 0;
            int close = 0;
            double result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '@') {
                    sqrt = i;
                    break;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '{') {
                    open = i;
                    break;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '}') {
                    close = i;
                    break;
                }
            }
            if (s.charAt(sqrt + 1) == '{') {
                double number = Double.parseDouble(calculator(s.substring(open + 1, close), -1));
                result = Math.sqrt(number);
            }
            return result;
        } else if (s.contains("^")) {
            List<Integer> pow = new ArrayList<>();
            double result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '^') {
                    pow.add(i);
                }
            }
            for (int i = 0; i < pow.size(); i++) {
                if (i == 0) {
                    double a = Double.parseDouble(calculator(s.substring(0, pow.get(i)), -1));
                    double b;
                    if (i == pow.size() - 1) b = Double.parseDouble(calculator(s.substring(pow.get(0) + 1), -1));
                    else b = Double.parseDouble(calculator(s.substring(pow.get(0) + 1, pow.get(1)), -1));
                    result += Math.pow(a, b);
                } else if (i == pow.size() - 1) {
                    double a = Double.parseDouble(calculator(s.substring(pow.get(i) + 1), -1));
                    result = Math.pow(result, a);
                } else {
                    double a = Double.parseDouble(calculator(s.substring(pow.get(i) + 1, pow.get(i + 1)), -1));
                    result = Math.pow(result, a);
                }
            }
            return result;
        }
        else {
            return Double.parseDouble(s);
        }
    }
    private static double parsesecond (String s) {
        s = s.replaceAll(" ", "");
        if (s.contains("*") || s.contains("/") || s.contains("%")) {
            List<Integer> terms = new ArrayList<>();
            double result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%') {
                    terms.add(i);
                }
            }
            for (int i = 0; i < terms.size(); i++) {
                if (i == 0) {
                    double a = Double.parseDouble(calculator(s.substring(0, terms.get(i)), -1));
                    double b;
                    if (i == terms.size() - 1) b = Double.parseDouble(calculator(s.substring(terms.get(0) + 1), -1));
                    else b = Double.parseDouble(calculator(s.substring(terms.get(0) + 1, terms.get(1)), -1));
                    if (s.charAt(terms.get(i)) == '*') result = a * b;
                    else if (s.charAt(terms.get(i)) == '/') result = a / b;
                    else if (s.charAt(terms.get(i)) == '%') result = a % b;
                } else if (i == terms.size() - 1) {
                    double b = Double.parseDouble(calculator(s.substring(terms.get(i) + 1), -1));
                    if (s.charAt(terms.get(i)) == '*') result *= b;
                    else if (s.charAt(terms.get(i)) == '/') result /= b;
                    else if (s.charAt(terms.get(i)) == '%') result %= b;
                } else {
                    double b = Double.parseDouble(calculator(s.substring(terms.get(i) + 1, terms.get(i + 1)), -1));
                    if (s.charAt(terms.get(i)) == '*') result *= b;
                    else if (s.charAt(terms.get(i)) == '/') result /= b;
                    else if (s.charAt(terms.get(i)) == '%') result %= b;
                }
            }
            return result;
        } else {
            return Double.parseDouble(s);
        }
    }
    private static double parsethird (String s) {
        s = s.replaceAll(" ", "");
        List<Integer> operators = new ArrayList<>();
        double result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                operators.add(i);
            }
        }
        for (int i = 0; i < operators.size(); i++) {
            if (i == 0) {
                double a = Double.parseDouble(calculator(s.substring(0, operators.get(i)), -1));
                double b;
                if (i == operators.size() - 1) b = Double.parseDouble(calculator(s.substring(operators.get(0) + 1), -1));
                else b = Double.parseDouble(calculator(s.substring(operators.get(0) + 1, operators.get(1)), -1));
                if (s.charAt(operators.get(i)) == '+') result = a + b;
                else if (s.charAt(operators.get(i)) == '-') result = a - b;
            } else if (i == operators.size() - 1) {
                double b = Double.parseDouble(calculator(s.substring(operators.get(i) + 1), -1));
                if (s.charAt(operators.get(i)) == '+') result += b;
                else if (s.charAt(operators.get(i)) == '-') result -= b;
            } else {
                double b = Double.parseDouble(calculator(s.substring(operators.get(i) + 1, operators.get(i + 1)), -1));
                if (s.charAt(operators.get(i)) == '+') result += b;
                else if (s.charAt(operators.get(i)) == '-') result -= b;
            }
        }
        return result;
    }
    private static String calculator(String Expression, int Demical) {
        if (isExpresstion(Expression)) {
            if (Demical <= -1) {
                if (!Expression.contains("(") && !Expression.contains(")")) {
                    if (Expression.startsWith("@{")) {
                        if (Expression.contains("^") || Expression.contains("@{")) {
                            return String.valueOf(parsefirst(Expression));
                        } else if (Expression.contains("*") || Expression.contains("/") || Expression.contains("%")){
                            return String.valueOf(parsesecond(Expression));
                        } else if (Expression.contains("+") || Expression.contains("-")) {
                            return String.valueOf(parsethird(Expression));
                        } else {
                            return Expression;
                        }
                    } else {
                        Expression = Expression.replaceAll(" ", "");
                        List<Integer> open = new ArrayList<>();
                        List<Integer> close = new ArrayList<>();
                        List<String> es = new ArrayList<>();
                        for (int i = 0; i < Expression.length(); i++) {
                            if (Expression.charAt(i) == '{') open.add(i);
                        }
                        for (int i = Expression.length() - 1; i >= 0; i--) {
                            if (Expression.charAt(i) == '}') close.add(i);
                        }
                        if (open.size() != close.size()) return Expression;
                        else {
                            for (int i = 0; i < open.size(); i++) {
                                if (!Expression.substring(open.get(i) + 1, close.get(i)).contains("@{") && !Expression.substring(open.get(i) + 1, close.get(i)).contains("}"))
                                    es.add(Expression.substring(open.get(i) + 1, close.get(i)));
                                else es.add(calculator(Expression.substring(open.get(i) + 1, close.get(i)), Demical));
                            }
                        }
                        for (String e : es) {
                            Expression = Expression.replace("@{" + e + "}", calculator(e, Demical));
                        }
                        if (Expression.contains("+") || Expression.contains("-")) {
                            return String.valueOf(parsethird(Expression));
                        } else if (Expression.contains("*") || Expression.contains("/") || Expression.contains("%")){
                            return String.valueOf(parsesecond(Expression));
                        } else if (Expression.contains("^") || Expression.contains("@{")) {
                            return String.valueOf(parsefirst(Expression));
                        } else {
                            return Expression;
                        }
                    }
                } else {
                    Expression = Expression.replaceAll(" ", "");
                    final String regex = "([(]{1})([\\d\\s+\\-*/%^@{}]+)([)]{1})";
                    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                    final Matcher matcher = pattern.matcher(Expression);
                    if (matcher.find()) {
                        Expression = Expression.replaceFirst(regex, calculator(matcher.group(0).replaceAll("\\(", "").replaceAll("\\)", ""), Demical));
                    }
                    return calculator(Expression, Demical);
                }
            } else {
                if (!Expression.contains("(") && !Expression.contains(")")) {
                    if (Expression.startsWith("@{")) {
                        if (Expression.contains("^") || Expression.contains("@{")) {
                            return String.format("%." + Demical + "f", parsefirst(Expression));
                        } else if (Expression.contains("*") || Expression.contains("/") || Expression.contains("%")){
                            return String.format("%." + Demical + "f", parsesecond(Expression));
                        } else if (Expression.contains("+") || Expression.contains("-")) {
                            return String.format("%." + Demical + "f", parsethird(Expression));
                        } else {
                            return Expression;
                        }
                    } else {
                        Expression = Expression.replaceAll(" ", "");
                        List<Integer> open = new ArrayList<>();
                        List<Integer> close = new ArrayList<>();
                        List<String> es = new ArrayList<>();
                        for (int i = 0; i < Expression.length(); i++) {
                            if (Expression.charAt(i) == '{') open.add(i);
                        }
                        for (int i = Expression.length() - 1; i >= 0; i--) {
                            if (Expression.charAt(i) == '}') close.add(i);
                        }
                        if (open.size() != close.size()) return Expression;
                        else {
                            for (int i = 0; i < open.size(); i++) {
                                if (!Expression.substring(open.get(i) + 1, close.get(i)).contains("@{") && !Expression.substring(open.get(i) + 1, close.get(i)).contains("}"))
                                    es.add(Expression.substring(open.get(i) + 1, close.get(i)));
                                else es.add(calculator(Expression.substring(open.get(i) + 1, close.get(i)), Demical));
                            }
                        }
                        for (String e : es) {
                            Expression = Expression.replace("@{" + e + "}", calculator("@{" + e + "}", Demical));
                        }
                        if (Expression.contains("+") || Expression.contains("-")) {
                            return String.format("%." + Demical + "f", parsethird(Expression));
                        } else if (Expression.contains("*") || Expression.contains("/") || Expression.contains("%")){
                            return String.format("%." + Demical + "f", parsesecond(Expression));
                        } else if (Expression.contains("^") || Expression.contains("@{")) {
                            return String.format("%." + Demical + "f", parsefirst(Expression));
                        } else {
                            return Expression;
                        }
                    }
                } else {
                    Expression = Expression.replaceAll(" ", "");
                    final String regex = "([(]{1})([\\d\\s+\\-*/%^@{}]+)([)]{1})";
                    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
                    final Matcher matcher = pattern.matcher(Expression);
                    if (matcher.find()) {
                        Expression = Expression.replaceFirst(regex, calculator(matcher.group(0).replaceAll("\\(", "").replaceAll("\\)", ""), Demical));
                    }
                    return calculator(Expression, Demical);
                }
            }
        } else {
            return "Couldn't find any expressions";
        }
    }
}
