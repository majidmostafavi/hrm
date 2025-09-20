package com.noor.wrapper;

public record PersonAttendanceReport(
        String occupationName,
        Long attendanceCount,
        Long totalWorked,
        Long overtimeTotalWorked,
        Long overtimeWithMultiplier) {
}
