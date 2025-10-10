package com.noor.dto;

import com.noor.enumration.CategoryType;

public record PersonCategoryDTO (

    String categoryName,
    Long categoryCode,
    Long categoryID,
    CategoryType categoryType,
    Long countAttendance,
    Long hourAttendance,
    Long minuteAttendance){
}
