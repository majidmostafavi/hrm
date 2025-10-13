package com.noor.wrapper;

import java.util.List;

public record RatioServiceResWrapper(String categoryName, Long categoryCode, Long categoryID, List<RatioServiceResDetailWrapper> ratioServiceResDetailWrappers) {
}
