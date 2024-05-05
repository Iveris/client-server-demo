package com.warneriveris.server.data.dao;

import com.warneriveris.server.data.entity.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface KittyRepository extends JpaRepository<Kitty, Long> {

    Collection<Kitty> findKittyByName(String name);

    Collection<Kitty> findKittyByOwner(String owner);

    Collection<Kitty> findKittyByNameAndOwner(String name, String owner);

//    Kitty findKitty(Kitty kitty);

}
