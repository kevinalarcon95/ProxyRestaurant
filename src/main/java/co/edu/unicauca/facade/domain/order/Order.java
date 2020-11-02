package co.edu.unicauca.facade.domain.order;

import static co.edu.unicauca.facade.domain.order.State.NEW;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin Alarcón, Santiago Cordoba
 */
public class Order {

    public int dispatch;
    private Customer customer;
    private LocalDate date;
    private State state;
    private List<Item> details;

    public Order(Customer customer) {
        this.customer = customer;
        this.state = NEW;
        this.details = new ArrayList<Item>();
    }

    public Order(int dispatch, Customer customer, LocalDate date) {
        this.dispatch = dispatch;
        this.customer = customer;
        this.date = date;
        this.state = state;
        this.details = new ArrayList<Item>();
    }
    
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Item> getDetails() {
        return details;
    }

    public void setDetails(List<Item> details) {
        this.details = details;
    }

    public void addDish(Dish dish, int amount) {
        Item item = new Item(dish, amount);
        this.details.add(item);
    }

    public int calculateTotal() {
        int valueTotal = 0;
        for (Item item : details) {
         valueTotal += item.getDish().getPrice() * item.getAmount();
        }
        return valueTotal;
    }
}
