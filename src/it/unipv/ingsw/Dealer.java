package it.unipv.ingsw;

import java.util.List;

public abstract class Dealer {
    private int balance = 0;

    public final String getName() {
        return this.getClass().getSimpleName();
    }

    public final int getBalance() {
        return balance;
    }

    public final void addToBalance(int amount) {
        balance += amount;
    }

    abstract public Suitcase exchangeSuitcase(List<Suitcase> history, int rounds);
}
