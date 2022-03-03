package com.order.hairshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MenuUpsertDTO {

    @NotNull
    private int shopId;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private int price;
}
