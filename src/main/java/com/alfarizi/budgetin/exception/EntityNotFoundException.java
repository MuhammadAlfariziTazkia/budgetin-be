package com.alfarizi.budgetin.exception;

import java.util.UUID;

public class EntityNotFoundException extends Exception {

    String name;
    UUID id;

     public EntityNotFoundException(String name, UUID id) {
         super(String.format("%s:%s is not found", name, id.toString()));
     }
}
