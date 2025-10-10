package com.noor.wrapper;

import com.noor.enumration.RatioReportType;

public record RatioServiceSearchWrapper(Long yearID, Long organizationID, Long monthID, RatioReportType ratioReportType) {
}
