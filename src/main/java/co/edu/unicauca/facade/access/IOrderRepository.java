package co.edu.unicauca.facade.access;

import co.edu.unicauca.facade.domain.order.Order;

/**
 *
 * @author Kevin Alarcón, Santiago Cordoba
 */
public interface IOrderRepository {
   
    
    public void createOrder(Order order);
}
