package ufrn.imd.simplecalculator;

import net.objecthunter.exp4j.ExpressionBuilder;

public final class SimpleCalculator {

    public static Integer calculate(final String stringExpression) {
        final var expression = new ExpressionBuilder(stringExpression).build();
        return (int) expression.evaluate();
    }

}
