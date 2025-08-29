package com.noor.dto;

public record SumPersonnelAttendanceDTO (
     Long yearID,
     String yearName,
     Long monthID,
     String monthName,
     Long organizationID,
     String organizationName,
     int totalWorked,
     int overtimeTotalWorked,
     int attendanceCount){
}
