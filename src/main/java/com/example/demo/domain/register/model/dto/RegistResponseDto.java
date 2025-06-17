package com.example.demo.domain.register.model.dto;

import com.example.demo.global.common.CommonDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistResponseDto {

    private RegistRequestDto registRequestDto;

    @JsonUnwrapped
    private CommonDto commonDto;
}
