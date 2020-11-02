package co.edu.unicauca.facade.domain.order;



import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin Alarcón
 */
public class OrderFacadeTest {
  
    @Test
    public void testCreateOrder() {
        OrderFacade facade = new OrderFacade();
        //Orderfacade facade = new Orderfacade();
        facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
        facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        facade.addDish(new Dish(2, "Hamburguesa sencilla ", 4000), 3);
        facade.addDish(new Dish(3, "Jugo hit ", 1000), 2);
        assertEquals("Hamburguesa vegetariana",
        facade.getOrder().getDetails().get(0).getDish().getName());
        assertEquals(State.NEW, facade.getOrder().getState());
        facade.changeState(State.FINALIZED);
        assertEquals(State.FINALIZED, facade.getOrder().getState());
        assertEquals(3, facade.totalDishes());
        assertEquals(24000, facade.calculateTotal());
        facade.cancelOrder();
        facade.changeState(State.CANCELED);
    }

    
}
