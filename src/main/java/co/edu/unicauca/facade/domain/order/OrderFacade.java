package co.edu.unicauca.facade.domain.order;

import co.edu.unicauca.facade.access.IOrderRepository;

/**
 *
 * @author Kevin Alarcón, Santiago Cordoba
 */
public class OrderFacade implements IOrderService{
    private Order order;

    public OrderFacade() {
    }
     
    public void createOrder(Customer customer){
        order = new Order(customer);
    }
    
    public void addDish (Dish dish, int amount){
        this.order.addDish(dish, amount);
    }
    
    public void changeState(State state){
        this.order.setState(state);
    }
    
    public void cancelOrder(){
        this.order.setState(State.CANCELED);
    }
    
    public int calculateTotal(){
        return this.order.calculateTotal();
    }

    public Order getOrder() {
        return this.order;
    }
    
    public int totalDishes(){
        return this.order.getDetails().size();
    }
    
    /**
     * 
     * @param repo 
     */
    @Override
    public void save(IOrderRepository repo){
       repo.createOrder(order);
    }
}