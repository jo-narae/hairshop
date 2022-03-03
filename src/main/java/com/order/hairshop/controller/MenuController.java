package com.order.hairshop.controller;

import com.order.hairshop.domain.Menu;
import com.order.hairshop.dto.MenuUpsertDTO;
import com.order.hairshop.mapper.MenuMapper;
import com.order.hairshop.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping
    List<Menu> getList() {
        return menuService.getList();
    }

    @GetMapping("/{id}")
    Menu getMenu(@PathVariable("id") int id) {
        return menuService.findById(id);
    }

    @PostMapping
    Menu saveMenu(@Valid @RequestBody MenuUpsertDTO request) {
        Menu menu = MenuMapper.INSTANCE.menuInsertRequestToMenu(request);
        return menuService.saveMenu(menu);
    }

    @PutMapping("/{id}")
    Menu updateMenu(@PathVariable("id") int id, @Valid @RequestBody MenuUpsertDTO request) {
        Menu menu = menuService.findById(id);
        MenuMapper.INSTANCE.menuUpdateRequestToMenu(request, menu);
        return menuService.saveMenu(menu);
    }

    @DeleteMapping("/{id}")
    void deleteMenu(@PathVariable("id") int id) {
        menuService.deleteMenu(id);
    }
}
