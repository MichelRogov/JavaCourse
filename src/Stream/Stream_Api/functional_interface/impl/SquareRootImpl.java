package Stream.Stream_Api.functional_interface.impl;

import Stream.Stream_Api.functional_interface.SquareRoot;

public class SquareRootImpl implements SquareRoot {

    @Override
    public double findSquareRoot(int n) {
        return Math.sqrt(n);
    }
}
