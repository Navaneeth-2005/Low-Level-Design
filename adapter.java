interface paymentGateWay{
    void pay(String orderid,double amount);
}

class payUGateway implements paymentGateWay{
    @Override
    public void pay(String orderid, double amount) {
        System.out.println("Paying " + amount + " for order " + orderid + " using PayU Gateway.");
    }
}

class razorpayAdapter implements paymentGateWay{
    private razorPayAPI razorpayAPI;

    razorpayAdapter() {
        this.razorpayAPI = new razorPayAPI();
    }

    @Override
    public void pay(String orderId,double amount){
        razorpayAPI.makePayment(orderId,amount);
    }
}



class razorPayAPI{
    void makePayment(String orderid,double amount){
        System.out.println("Making payment of " + amount + " for order " + orderid + " using RazorPay API.");
    }
}


class checkOutService{
    private paymentGateWay paymentgateWay;

    public checkOutService(paymentGateWay paymentgateWay) {
        this.paymentgateWay = paymentgateWay;
    }

    void checkout(String orderid, double amount) {
        paymentgateWay.pay(orderid, amount);
    }
}

public class adapter {

    public static void main(String[] args) {

        checkOutService checkoutService = 
            new checkOutService(new razorpayAdapter());
            
        checkoutService.checkout("12", 1780);
        // Your code here
    }
}
