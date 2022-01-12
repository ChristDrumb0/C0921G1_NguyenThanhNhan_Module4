package vn.codegym.repository;

import org.springframework.stereotype.Repository;


public interface IRepository {
    double convert(double usd,double rate);
}
