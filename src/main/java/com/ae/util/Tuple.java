package com.ae.util;

import java.util.Objects;

public class Tuple<T0, T1> {
    public final T0 v1;
    public final T1 v2;

    public Tuple(T0 v1, T1 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;

        Tuple tuple = (Tuple) o;

        return Objects.equals(v1, tuple.v1);
    }

    @Override
    public int hashCode() {
        int result = v1 != null ? v1.hashCode() : 0;
        result = 31 * result + (v2 != null ? v2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "(" + v1 + ',' + v2 + ')';
    }
}