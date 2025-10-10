package com.noor.wrapper;

import com.noor.entity.Month;
import com.noor.enumration.RatioReportType;

import java.util.List;

public record RatioServiceSearchWrapper(Long yearID, Long organizationID, List<Month> months, RatioReportType ratioReportType) {
}
