package vn.codegym.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryImp implements IRepository{

    @Override
    public String calculate(double first, double second, String operator) {
        double result = 0;
        if (operator.equals("+")) {
            result = first+second;
        }else if (operator.equals("-")) {
            result = first-second;
        }else if (operator.equals("*")) {
            result = first*second;
        }else {
            if (second==0) {
                return "invalid division while denominator = 0";
            }else {
                result = first/second;
            }
        }
        return Double.toString(result);
    }
}
