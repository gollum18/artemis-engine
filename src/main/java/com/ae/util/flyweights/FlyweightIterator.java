package com.ae.util.flyweights;

import java.util.Iterator;
import java.util.List;

public class FlyweightIterator<F extends Flyweight> implements Iterator<F> {
    private final List<F> mList;
    private int dIndex = 0;

    /**
     *
     * @param list
     */
    public FlyweightIterator(List<F> list) {
        mList = list;
    }

    /**
     *
     * @return
     */
    @Override public boolean hasNext() { return dIndex == mList.size(); }

    /**
     *
     * @return
     */
    @Override public F next() { return mList.get(dIndex++); }
}
