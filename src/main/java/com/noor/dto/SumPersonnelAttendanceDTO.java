package com.noor.dto;

public record SumPersonnelAttendanceDTO (
     Long yearID,
     String yearName,
     Long monthID,
     String monthName,
     Long organizationID,
     String organizationName,
     Long totalWorked,
     Long overtimeTotalWorked,
     Long attendanceCount){
}
