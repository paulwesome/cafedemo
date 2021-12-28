package test;

@MessageEndpoint
public class OrderSplitter {

     @Splitter(inputChannel="orders", outputChannel="drinks")
     public List<OrderItem> split(Order order) {
         return order.getItems();
     }
}
