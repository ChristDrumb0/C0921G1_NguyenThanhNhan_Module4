package vn.codegym.repository;

import org.springframework.stereotype.Repository;


public interface IRepository {
    String calculate(double first, double second, String operator);
}
