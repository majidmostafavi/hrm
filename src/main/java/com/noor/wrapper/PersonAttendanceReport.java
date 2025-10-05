package com.noor.wrapper;

import com.noor.entity.Occupation;

import java.util.List;

public record PersonAttendanceReport (Occupation occupation,Long occupationID, List<PersonAttendanceReportDetail> reportDetail){
}
