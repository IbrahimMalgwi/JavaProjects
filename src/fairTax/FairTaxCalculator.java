package fairTax;

public class FairTaxCalculator {
        private final double FAIR_TAX_RATE = 23.00;
        private double totalPrice = 0.0;

        public double calculateTax(double price) {
            return (FAIR_TAX_RATE/100) * price;
        }

        public double calculateTotalPrice(double price) {
            totalPrice +=price;
            return totalPrice;
        }

        public double getFairTaxRate() {
            return FAIR_TAX_RATE;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
}


