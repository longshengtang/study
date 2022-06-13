package com.flysky.study.lambda.count;

import java.math.BigDecimal;
import java.util.Date;

public class MultipleColumnOriginalData {
    private Long total;
    private Long uv;
    private Long pv;

    public MultipleColumnOriginalData() {
    }

    public MultipleColumnOriginalData(Metadata metadata) {
        UserPvUv userPvUv = (UserPvUv) metadata;
        this.total = userPvUv.total;
        this.pv = userPvUv.pv;
        this.uv = userPvUv.uv;
    }

    public MultipleColumnOriginalData add(MultipleColumnOriginalData multipleColumnOriginalData) {
        this.total = plus(this.total, multipleColumnOriginalData.total);
        this.pv = plus(this.pv, multipleColumnOriginalData.pv);
        this.uv = plus(this.uv, multipleColumnOriginalData.uv);
        return this;
    }

    public Column[] columns() {
        return new Column[]{getSimpleFraction(this.pv, this.total), getSimpleFraction(this.uv, this.total)};
    }

    private SimpleFraction getSimpleFraction(Long divisor, Long dividend) {
        return new SimpleFraction(toBigDecimal(divisor), toBigDecimal(dividend));
    }

    private BigDecimal toBigDecimal(Long value) {
        return value != null ? BigDecimal.valueOf(value) : BigDecimal.ZERO;
    }

    public static Long plus(Long addend, Long augend) {
        if (addend == null) {
            return augend;
        }
        if (augend == null) {
            return addend;
        }

        return addend + augend;
    }

    class UserPvUv implements Metadata<Integer> {

        private Long total;
        private Long uv;
        private Long pv;

        @Override
        public Date getRowKey() {
            return null;
        }

        @Override
        public Integer getTypeKey() {
            return null;
        }


        public Long getTotal() {
            return total;
        }

        public Long getUv() {
            return uv;
        }

        public Long getPv() {
            return pv;
        }
    }
}
