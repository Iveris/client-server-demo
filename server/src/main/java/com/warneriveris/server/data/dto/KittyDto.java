package com.warneriveris.server.data.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record KittyDto(
        @NotNull(message = "Kitty must have a name")
        @NotEmpty(message = "Kitty must have a name")
        String name,
        String owner,
        String eyeColor,
        @NotNull(message = "Kitty must have a weight")
        Double weight,
        @NotNull(message = "Kitty intelligence rating required")
        Integer intelligence,
        String description) {
}
