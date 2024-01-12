package pro.sky.java.course2.valiyev.examquestiongenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionServiceQuestionNullException extends RuntimeException {
    public QuestionServiceQuestionNullException() {
    }

    public QuestionServiceQuestionNullException(String message) {
        super(message);
    }

    public QuestionServiceQuestionNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionServiceQuestionNullException(Throwable cause) {
        super(cause);
    }

    public QuestionServiceQuestionNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
