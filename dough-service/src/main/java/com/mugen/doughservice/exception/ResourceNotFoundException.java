package com.mugen.doughservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;
    private final List<ResourceField> resourceFields;

    public ResourceNotFoundException(String resourceName, List<ResourceField> resourceFields) {
        super(String.format("%s not found with %s", resourceName, resourceFields));
        this.resourceName = resourceName;
        this.resourceFields = resourceFields;
    }

}