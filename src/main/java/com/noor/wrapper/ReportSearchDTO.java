package com.noor.wrapper;

import com.noor.entity.Month;

import java.util.List;

public record ReportSearchDTO (
    List<Month> months,
    Long yearID,
    String yearName,
    Long organizationID,
    String organizationName){

}
