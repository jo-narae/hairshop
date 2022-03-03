package com.order.hairshop.service;

import com.order.hairshop.domain.Menu;
import com.order.hairshop.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<Menu> getList() {
        return menuRepository.findAll();
    }

    public Menu findById(int id) {
        return menuRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }
}
