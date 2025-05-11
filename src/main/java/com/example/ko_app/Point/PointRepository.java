package com.example.ko_app.Point;

import com.example.ko_app.Report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
    List<Point> findByCustomerId(Integer customerId);

}
