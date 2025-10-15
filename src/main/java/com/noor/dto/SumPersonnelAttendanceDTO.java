package com.noor.dto;

public record SumPersonnelAttendanceDTO (
     Long yearID,
     String yearName,
     Long monthID,
     String monthName,
     Long organizationID,
     String organizationName,
     Long overtimeHoursWorked,
     Long overtimeMinutesWorked,
     Long overtimeWithHoursWorked,
     Long overtimeWithMinutesWorked,
     Long attendanceCount){
}
