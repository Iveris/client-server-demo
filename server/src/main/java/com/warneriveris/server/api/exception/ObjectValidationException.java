package com.warneriveris.server.exception;

import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException{
    @Getter
    private final Set<String> errorMessages;
}
