package com.noor.wrapper;

import java.util.List;

public record ReportSearchDTO (

    Long monthID,
    List<Long> monthIDs,
    String monthName,
    Long yearID,
    String yearName,
    Long organizationID,
    String organizationName){

}
