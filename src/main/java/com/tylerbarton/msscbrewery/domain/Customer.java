package com.tylerbarton.msscbrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Represents a Customer entity.
 * Persists to the database
 */
@Data                   // Getter/Setter, ToString, Equals, Hash on all fields
@AllArgsConstructor     // Creates a constructor with all args
@NoArgsConstructor      // Creates a no-arg constructor
@Builder                // Creates a builder for this object
public class Customer {
    private UUID Id;
    private String name;
}
