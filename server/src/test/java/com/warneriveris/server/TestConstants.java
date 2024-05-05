package com.warneriveris.server;

import com.warneriveris.server.data.dto.KittyDto;
import com.warneriveris.server.data.entity.Kitty;

public class TestConstants {

    public static final String OWNER = "Warner and Aiden";

    public static Kitty Bob() {
        return Kitty.builder()
                .name("Bobson")
                .owner(OWNER)
                .eyeColor("green")
                .weight(13.0)
                .intelligence(9)
                .description("Very sweet, but with sharp corners")
                .build();
    }

    public static KittyDto BobDto() {
        return new KittyDto("Bobson", OWNER, "green", 13.0, 9, "Very sweet, but with sharp corners");
    }

    public static Kitty Belle(){
        return Kitty.builder()
                .name("Belle")
                .owner(OWNER)
                .eyeColor("green")
                .weight(5.0)
                .intelligence(6)
                .description("Cute and always looking for mischief!")
                .build();
    }

    public static KittyDto BelleDto() {
        return new KittyDto("Belle", OWNER, "green", 5.0, 6, "Cute and always looking for mischief!");
    }
}
