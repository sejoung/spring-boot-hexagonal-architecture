package io.github.sejoung.product.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public abstract class Product<T> {
    public enum ProductStatus {
        CREATE, DELETE, TEMPORARY, PERMANENTLY_DELETE
    }

    private final Validator validator;

    private final Long productId;

    @NotNull
    private final Category category;
    @Setter
    private ProductStatus status;
    @NotEmpty
    private String productName;

    private final LocalDateTime createTime;

    Product(Long productId, Category category, ProductStatus status, String productName) {
        this.productId = productId;
        this.category = category;
        this.status = status;
        this.productName = productName;
        this.createTime = LocalDateTime.now();
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T)this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public void created() {
        this.status = ProductStatus.CREATE;
    }

    public void deleted() {
        this.status = ProductStatus.DELETE;
    }

    public void temporaryed() {
        this.status = ProductStatus.TEMPORARY;
    }

    public void permanentlyDelete() {
        this.status = ProductStatus.PERMANENTLY_DELETE;
    }
}
