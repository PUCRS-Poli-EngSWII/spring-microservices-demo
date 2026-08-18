package br.pucrs.microdemo.microservico3.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollmentRequest {
    private Long studentId;
    private Long courseScheduleId;
}
