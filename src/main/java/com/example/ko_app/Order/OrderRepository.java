package com.example.ko_app.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
//   List<Order> findByCustomerId(Integer customerId);



//public List<Order> findByCustomerId(Integer customerId);

 //   @Override
 //   Optional<Order> findById(Integer customerId);
}
