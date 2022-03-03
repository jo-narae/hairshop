package com.order.hairshop.service;

import com.order.hairshop.domain.Shop;
import com.order.hairshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public List<Shop> getList() {
        return shopRepository.findAll();
    }

    public Shop findById(int id) {
        return shopRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }
}
