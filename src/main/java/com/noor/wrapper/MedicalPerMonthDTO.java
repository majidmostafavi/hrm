package com.noor.wrapper;

import java.io.Serializable;

public record MedicalPerMonthDTO  (
    Long serviceID,
    String serviceName,
    Long medicalCount) implements Serializable {

}
