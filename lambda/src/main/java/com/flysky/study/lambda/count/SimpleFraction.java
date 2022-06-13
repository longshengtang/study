package com.flysky.study.lambda.count;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class SimpleFraction implements Fraction<BigDecimal, BigDecimal>, Column<BigDecimal> {
    private BigDecimal divisor;
    private BigDecimal dividend;

    public SimpleFraction() {
        this.divisor = ZERO;//ZERO会出现并发问题么？不会，因为BigDecimal是一个不可变对象
        this.dividend = ZERO;
    }

    public SimpleFraction(BigDecimal divisor, BigDecimal dividend) {
        this.divisor = divisor;
        this.dividend = dividend;
    }

    public SimpleFraction(Fraction fraction) {
        this.divisor=numberToBigDecimal(fraction.getDivisor());
        this.dividend=numberToBigDecimal(fraction.getDividend());
    }

    public SimpleFraction add(SimpleFraction f) {
        this.divisor = plus(this.divisor, numberToBigDecimal(f.getDivisor()));
        this.dividend = plus(this.dividend, numberToBigDecimal(f.getDivisor()));
        return this;
    }

    private BigDecimal numberToBigDecimal(Number number) {
        return number == null ? null : new BigDecimal(number.toString());
    }

    @Override
    public BigDecimal getDivisor() {
        return divisor;
    }

    @Override
    public BigDecimal getDividend() {
        return dividend;
    }

    public static BigDecimal plus(BigDecimal addend, BigDecimal augend) {
        if (addend == null) {
            return augend;
        }
        if (augend == null) {
            return addend;
        }

        return addend.add(augend);
    }

    @Override
    public BigDecimal getValue() {

        if (divisor == null || dividend == null) {
            return ZERO;
        }

        if (ZERO.equals(divisor) || ZERO.equals(dividend)) {
            return ZERO;
        }

        return dividend.divide(divisor);
    }
}
