package io.github.sejoung.product.exception;

import lombok.Getter;

@Getter
public enum ProductExceptionCode {
    P0100("상품이 존재하지 않습니다.");

    private final String code;
    private final String message;

    ProductExceptionCode(String message) {
        this.code = this.name();
        this.message = message;
    }
}
