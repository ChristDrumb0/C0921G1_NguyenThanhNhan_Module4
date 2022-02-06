package com.codegym.cart.dto;

import com.codegym.cart.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CartDto {
    private Map<Product, Integer> productMap = new HashMap<Product, Integer>();  //chỉ cần 1 thuộc tính

    public CartDto() {
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    //thêm vào giỏ hàng
    public void addCart(Product product) {
        if (this.productMap.containsKey(product)) {
            productMap.put(product, productMap.get(product) + 1);
        } else {
            productMap.put(product, 1);
        }
    }
    //chỉnh sửa giỏ hàng: giảm  (SL)
    public void subCart(Product product) {
        if (this.productMap.containsKey(product)) {
            Integer value = productMap.get(product);
            if (value == 0) {
                productMap.remove(product);
            }else {
                productMap.put(product, productMap.get(product) - 1);
            }
        }
    }

    //findById:
    public Optional<Product> findById(Long id) {
        Optional<Product> product = Optional.empty();
        for (Product item : this.productMap.keySet()) {
            if (item.getId().equals(id)) {
                product = Optional.of(item);
            }
        }
        return product;
    }

    //Delete:
    public void deleteById(Long id) {
        Product product = findById(id).get();
        //xoa:
        this.productMap.remove(product);
    }

    //tính tổng tiền:
    public double sumPrice() {
        double sumPrice = 0;
        for (Map.Entry<Product,Integer> item: productMap.entrySet()) {
            sumPrice += item.getKey().getPrice()*item.getValue();
        }
        return sumPrice;
    }
}
