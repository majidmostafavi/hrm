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
    Long attendance,
    Long overtimeHoursWorked,
    Long overtimeMinutesWorked,
    Long overtimeWithHoursWorked,
    Long overtimeWithMinutesWorked,
    List<MedicalPerMonthDTO> medicalPerMonthDTOList) implements Serializable {

}
