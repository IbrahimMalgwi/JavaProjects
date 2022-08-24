package com.uncornWimps.store.sales;

import java.math.BigDecimal;

/**
 * Class for representing sale persons
 * @@author Sam
 */
public class SalesPerson {
    private Item[] soldItems;
    private final double WEEKLY_PAY = 200;
    private final double COMMISSION_RATE = 0.09;

    public Item[] getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(Item[] soldItems) {
        this.soldItems = soldItems;
    }

    public double calculateEarnings(){
        double commission = BigDecimal.ZERO.doubleValue();
        for(int i = 0; i < soldItems.length; i++){
            commission += soldItems[i].getValueSold() * COMMISSION_RATE;
        }
        double earnings = WEEKLY_PAY + commission;
        return earnings;
    }
}
