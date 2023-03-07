package behavioral.strategy.order;

import behavioral.strategy.strategies.PayStrategy;

public class Order {
    private boolean isClosed = false;
    private int totalCost = 0;

    public boolean isClosed() {
        return isClosed;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setClosed() {
        isClosed = true;
    }
}
