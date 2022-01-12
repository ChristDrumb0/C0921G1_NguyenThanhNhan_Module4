package vn.codegym.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryImp implements IRepository{
    @Override
    public double convert(double usd, double rate) {
        return usd*rate;
    }
}
