package com.noor.wrapper;



import java.io.Serializable;
import java.util.List;

public record MedicalPerMonthReportResponseDTO (

    Long monthID,
    String monthName,
     Long yearID,
    String yearName,
    Long organizationID,
    String organizationName,
    int totalPerson,
    int totalOverTime,
    List<MedicalPerMonthDTO> medicalPerMonthDTOList) implements Serializable {

}
