package com.noor.wrapper;

import com.noor.entity.Occupation;

import java.util.List;

public record PersonAttendanceReport (String occupationName,Long occupationID, List<PersonAttendanceReportDetail> reportDetail){
}
