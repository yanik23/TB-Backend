package com.bokafood.tbbackend.exception;


/**
 * EntityNotFoundException class representing the exception thrown when an entity is not found in the database.
 * This class extends the RuntimeException class.
 * Inspired and adapted from https://www.udemy.com/course/the-complete-spring-boot-development-bootcamp/
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
            super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in the database");
    }

    public EntityNotFoundException(Long id1, Long id2, Class<?> entity) {
            super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id1 + "' and '" + id2 + "' does not exist in the database");
    }

    public EntityNotFoundException(String name, Class<?> entity) {
            super("The " + entity.getSimpleName().toLowerCase() + " with name '" + name + "' does not exist in the database");
    }

}
