package co.edu.unicauca.facade.domain.order;

import co.edu.unicauca.facade.access.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Kevin Alarcón, Santiago Cordoba
 */
public class OrderServiceLogger implements IOrderService{
    
    /**
     * Referencia al sujeto real
     */
    private OrderFacade orderFacade;
    
    /**
     * Logger
     */
   private Logger logger;

    public OrderServiceLogger() {
    }
   
    /**
     * Contructor Parametrizado
     * 
     * @param orderFacade 
     */
    public OrderServiceLogger(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
        logger = LoggerFactory.getLogger(OrderServiceLogger.class);
    }
    
    
    /**
     * Sobreescribimos la operación para poder controlar el acceso al recurso
     * original
     * 
     * En esta caso queremos sobreescribir la operación, para poder llevar logs.
     * 
     * @param repo repositorio
     */
    @Override
    public void save(IOrderRepository repo) {
        repo.createOrder(orderFacade.getOrder());
        String message = "Pedido guardado en la base de datos";
        logger.info(message);
    }

}
