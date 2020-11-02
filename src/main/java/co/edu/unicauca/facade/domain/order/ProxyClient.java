package co.edu.unicauca.facade.domain.order;

import co.edu.unicauca.facade.access.Factory;
import co.edu.unicauca.facade.access.IOrderRepository;

/**
 *
 * @author Kevin Alarcón, Santiago Cordoba
 */
public class ProxyClient {
    
    /**
     * Atributo de interfaz IOrderService
     */
    IOrderService orderService;

    /**
     * Constructor parametrizado.
     * @param orderService 
     */
    public ProxyClient(IOrderService orderService) {
        this.orderService = orderService;
    }
    
    /**
     * Metodo encargado de crear y guardar una orden.
     */
    public void createOrder(){
        IOrderRepository repo = Factory.getInstance().getRepository("default");
        orderService.save(repo);
    }
}
