package pro.sky.java.course2.valiyev.examquestiongenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MathQuestionServiceMethodNotAllowed extends RuntimeException {
    public MathQuestionServiceMethodNotAllowed() {
    }

    public MathQuestionServiceMethodNotAllowed(String message) {
        super(message);
    }

    public MathQuestionServiceMethodNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }

    public MathQuestionServiceMethodNotAllowed(Throwable cause) {
        super(cause);
    }

    public MathQuestionServiceMethodNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
