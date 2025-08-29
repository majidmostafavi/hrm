package com.noor.dto;

import java.io.Serializable;

public record MedicalPerMonthDTO  (
    Long serviceID,
    String serviceName,
    int medicalCount) implements Serializable {

}
