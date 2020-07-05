package id.arip.api.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Component
public class ApiErrorBuilder {

    public ApiError createDefaultApiError(String errorCode, String errorMessage) {
        return new ApiError(errorCode, errorMessage, null);
    }

    public ApiError createBindingResultApiError(String errorCode, String errorMessage, BindingResult bindingResult) {
        ApiError apiError = createDefaultApiError(errorCode, errorMessage);
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            apiError.addDetail(createApiError(fieldError, fieldError.getField()));
        }
        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            apiError.addDetail(createApiError(objectError, objectError.getObjectName()));
        }
        return apiError;
    }

    private ApiError createApiError(DefaultMessageSourceResolvable messageResolvable, String target) {
        return new ApiError(messageResolvable.getCode(), messageResolvable.getDefaultMessage(), target);
    }
}
