package com.tylerbarton.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    @Size(min=3, max=100)
    private String name;
}
