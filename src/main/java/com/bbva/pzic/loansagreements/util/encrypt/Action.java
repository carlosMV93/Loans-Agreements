package com.bbva.pzic.loansagreements.util.encrypt;

/**
 * @author Entelgy
 */
public enum Action {

    ENCRYPT,
    MASK;

    @Override
    public String toString() {
        return this.name();
    }
}
