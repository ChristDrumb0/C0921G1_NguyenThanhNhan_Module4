package vn.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryImp implements IRepository{

    @Override
    public String dictionary(String word) {
        Map<String,String> map =new HashMap<>();
        map.put("Learn","Học");
        map.put("Language","Ngôn ngữ");

        if(map.containsKey(word)) {
            return  map.get(word);
        }
        return "didn't exist";
    }
}
