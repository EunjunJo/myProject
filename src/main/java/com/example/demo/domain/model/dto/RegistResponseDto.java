package com.example.demo.domain.model.dto;

import com.example.demo.global.config.CommonDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistResponseDto {

    private RegistRequestDto registRequestDto;

    @JsonUnwrapped
    private CommonDto commonDto;
}
