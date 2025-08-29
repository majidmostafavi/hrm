package com.noor.dto;
public record MedicalPerMonthReportSearchDTO (

    Long monthID,
    String monthName,
    Long yearID,
    String yearName,
    Long organizationID,
    String organizationName){

}
