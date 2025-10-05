package com.noor.wrapper;

public record PersonAttendanceReportDetail(
        String occupationName,
        Long attendanceCount,
        Long totalWorked,
        String overtimeTotalWorked,
        String  overtimeWithMultiplier) {
}
