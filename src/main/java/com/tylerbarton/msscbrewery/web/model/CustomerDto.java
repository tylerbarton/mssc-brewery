package com.tylerbarton.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Represents a customer data transfer object (dto).
 */
@Data                   // Getter/Setter, ToString, Equals, Hash on all fields
@AllArgsConstructor     // Creates a constructor with all args
@NoArgsConstructor      // Creates a no-arg constructor
@Builder                // Creates a builder for this object
public class CustomerDto {
    private UUID Id;
    private String name;
}
