package com.warneriveris.server.controller;

import com.warneriveris.server.data.dto.KittyDto;
import com.warneriveris.server.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/kitties")
public class KittyController {

    private final DataService dataService;

    @Autowired
    public KittyController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(path = "/name")
    @ResponseBody
    public Collection<KittyDto> findKitty(@RequestParam String name){
        return dataService.findKittyByName(name).stream().toList();
    }

    @GetMapping(path = "/kitty")
    public Collection<KittyDto> findKitty(@RequestParam String name,
                                          @RequestParam String owner){
        return dataService.findKittyByNameAndOwner(name, owner);
    }

    @GetMapping(path = "/owner")
    public Collection<KittyDto> findKittyByOwner(@RequestParam String owner){
        return dataService.findKittyByOwner(owner);
    }

    @PostMapping(path = "/hello-kitty")
    public KittyDto helloKitty(@RequestBody KittyDto kitty){
        return dataService.saveKitty(kitty);
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping(path = "/goodbye-kitty")
    public String deleteKitty(@RequestBody KittyDto kitty) {
        return dataService.removeKitty(kitty);
    }
}
