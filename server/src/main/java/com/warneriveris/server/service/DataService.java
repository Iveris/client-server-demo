package com.warneriveris.server.service;

import com.warneriveris.server.data.dao.KittyRepository;
import com.warneriveris.server.data.dto.KittyDto;
import com.warneriveris.server.data.entity.Kitty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class DataService {

    private KittyRepository repo;

    @Autowired
    public DataService(KittyRepository repo){
        this.repo = repo;
    }

    public Collection<KittyDto> findKittyByName(String name) {
        return returnResult(repo.findKittyByName(name));
    }

    public Collection<KittyDto> findKittyByOwner(String owner) {
        return returnResult(repo.findKittyByOwner(owner));
    }

    public Collection<KittyDto> findKittyByNameAndOwner(String name, String owner) {
        return returnResult(repo.findKittyByNameAndOwner(name, owner));
    }

    public KittyDto saveKitty(KittyDto kittyDto){
        return convertEntityToDto(repo.save(convertDtoToEntity(kittyDto)));
    }

    public String removeKitty(KittyDto kittyDto){
        var foundCat = repo.findKittyByNameAndOwner(kittyDto.name(), kittyDto.owner()).stream().findFirst();
        repo.delete(foundCat.orElseThrow());
        return kittyDto.name() + " has been removed";
    }

    public Collection<KittyDto> returnResult(Collection<Kitty> kitties) {
        if(kitties.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return kitties.stream().map(this::convertEntityToDto).toList();
    }

    private KittyDto convertEntityToDto(Kitty kitty){
        return new KittyDto(kitty.getName(),
                kitty.getOwner(),
                kitty.getEyeColor(),
                kitty.getWeight(),
                kitty.getIntelligence(),
                kitty.getDescription());
    }

   private Kitty convertDtoToEntity(KittyDto kittyDto){
        return Kitty.builder()
                .name(kittyDto.name())
                .owner(kittyDto.owner())
                .eyeColor(kittyDto.eyeColor())
                .weight(kittyDto.weight())
                .intelligence(kittyDto.intelligence())
                .description(kittyDto.description())
                .build();
   }

}
