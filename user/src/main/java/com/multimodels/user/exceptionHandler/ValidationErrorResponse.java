package com.multimodels.user.exceptionHandler;

import java.util.List;

public record ValidationErrorResponse(
        List<Violation> violations
) {
}
