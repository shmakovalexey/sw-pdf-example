package com.example.sb3.demo.maven.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "User data")
public class DemoUserDto {

    @Schema(description = "User id")
    private Long id;

    @Schema(description = "User name")
    private String name;

    @Schema(description = "User age")
    private Integer age;

    @Schema(description = "User value")
    private BigDecimal value;
}
