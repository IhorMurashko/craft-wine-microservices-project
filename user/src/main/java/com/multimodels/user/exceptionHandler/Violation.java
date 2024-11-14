package com.multimodels.user.exceptionHandler;

public record Violation(
        String field,
        String message
) {
}
