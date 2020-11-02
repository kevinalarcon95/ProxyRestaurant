package co.edu.unicauca.facade.access;

/**
 * Fabrica que se encarga de instanciar OrderRepository o cualquier otro que
 * se cree en el futuro. Debido a que en esta aplicación se usa inyección de
 * dependencias con el framework de JavaEE, no se utiliza esta clase.F
 *
 * @author Kevin Alarcon, Santiago Cordoba
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type tipo de repositorio
     * @return una clase hija de la abstracción IProductRepository
     */
    public OrderRepository getRepository(String type) {
        OrderRepository repo = null;

        switch (type) {
            case "default":
                repo = new OrderRepository();
                break;
        }
        return repo;
    }
}
