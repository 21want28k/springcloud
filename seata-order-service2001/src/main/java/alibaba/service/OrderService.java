package alibaba.service;


import domain.Order;

public interface OrderService {

    void create(Order order);

    Order getById(Long id);
}
