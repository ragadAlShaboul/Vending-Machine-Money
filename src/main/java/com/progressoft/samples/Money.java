package com.progressoft.samples;

import java.util.*;

public class Money {
    public static final Money Zero = new Money(0);
    public static final Money OnePiaster = new Money(0.01);
    public static final Money FivePiasters = new Money(0.05);
    public static final Money TenPiasters = new Money(0.1);
    public static final Money TwentyFivePiasters = new Money(0.25);
    public static final Money FiftyPiasters = new Money(0.5);
    public static final Money OneDinar = new Money(1);
    public static final Money FiveDinars = new Money(5);
    public static final Money TenDinars = new Money(10);
    public static final Money TwentyDinars = new Money(20);
    public static final Money FiftyDinars = new Money(50);

    private int count = 0;
    private List<Money> total = new ArrayList<>();
    private double amount;

    private Money(double amount){
        count = 1;
        this.amount = amount;
        total.add(this);
    }

    public double amount() {
        return amount;
    }

    public Money times(int count) {
        if(count < 0)
            throw new IllegalArgumentException("Times cannot be negative");
        this.count+=count;
        return new Money(this.amount() * count);
    }

    public static Money sum(Money... items) {
        double sum=0;
        for (Money money:items) {
            sum += money.amount() * money.getCount();
        }
        return new Money(sum);
    }

    public Money plus(Money other) {
        return new Money(this.amount() + other.amount());
    }

    public Money minus(Money other) {
        double tmpAmount = this.amount() - other.amount();
        if(tmpAmount < 0)
            throw new IllegalArgumentException();

        return new Money(tmpAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount(), amount()) == 0;
    }
    @Override
    public String toString(){
        return String.format("%.2f", amount());
    }

    public int getCount() {
        return count;
    }

}

