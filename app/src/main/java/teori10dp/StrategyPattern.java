package teori10dp;

public class StrategyPattern {

  abstract class PaymentStrategy {
    abstract void pay();
  }

  class CashPayment extends PaymentStrategy {
    @Override
    void pay() {
    }
  }

  class CreditCardPayment extends PaymentStrategy {
    @Override
    void pay() {
    }
  }

  class DebitCardPayment extends PaymentStrategy {
    @Override
    void pay() {
    }
  }

  class PaymentHandler {
    private PaymentStrategy paymentStrategy;

    public PaymentHandler(PaymentStrategy paymentStrategy) {
      this.paymentStrategy = paymentStrategy;
    }

    void handlePayment(boolean isValid) throws Exception {
      if (!isValid) {
        throw new Exception("Invalid");
      }
      paymentStrategy.pay();
    }

  }

  public static void main(String[] args) {

  }

}
