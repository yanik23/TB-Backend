package com.bokafood.tbbackend.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
            super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in the database");
    }

    public EntityNotFoundException(String name, Class<?> entity) {
            super("The " + entity.getSimpleName().toLowerCase() + " with name '" + name + "' does not exist in the database");
    }

}
