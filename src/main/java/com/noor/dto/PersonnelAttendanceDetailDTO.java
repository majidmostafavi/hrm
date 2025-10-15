package com.noor.dto;

public record PersonnelAttendanceDetailDTO(
        Long occupationId,
        String occupationName,
        Long totalWorked,
        Long totalAttended,
        Long totalHoursWorked,
        Long totalMinutesWorked,
        Long overtimeHoursWorked,
        Long overtimeMinutesWorked
) {
}
