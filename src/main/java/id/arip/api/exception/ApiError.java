package id.arip.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiError {

    private String code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String target;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ApiError> details = new ArrayList<>();

    public ApiError(String code, String message) {
        this(code, message, null);
    }

    public ApiError(String code, String message, String target) {
        this.code = code;
        this.message = message;
        this.target = target;
    }

    public void addDetail(ApiError detail) {
        details.add(detail);
    }
}
