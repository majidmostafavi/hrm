package com.noor.wrapper;

import java.io.Serializable;

public record MedicalPerMonthDTO  (
    Long serviceID,
    String serviceName,
    int medicalCount) implements Serializable {

}
