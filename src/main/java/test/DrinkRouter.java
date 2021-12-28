package test;


@MessageEndpoint
 public class DrinkRouter {

    @Router(inputChannel="drinks")
    public String resolveOrderItemChannel(OrderItem orderItem) {
         return (orderItem.isIced()) ? "coldDrinks" : "hotDrinks";
     }
 
}

