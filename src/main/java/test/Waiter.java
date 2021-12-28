package test

 @MessageEndpoint
 public class Waiter {

     @Aggregator(inputChannel = "preparedDrinks", outputChannel = "deliveries", timeout = 5 * 60 * 1000)
    public Delivery prepareDelivery(List<Drink> drinks) {
       return new Delivery(drinks);
 }

}