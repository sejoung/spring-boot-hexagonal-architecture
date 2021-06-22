package io.github.sejoung.product.exception;

import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {
    private final ProductExceptionCode exceptionCode;

    public ProductException(ProductExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
