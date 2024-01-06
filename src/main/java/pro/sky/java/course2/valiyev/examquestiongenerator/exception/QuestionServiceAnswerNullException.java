package pro.sky.java.course2.valiyev.examquestiongenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionServiceAnswerNullException extends RuntimeException {
    public QuestionServiceAnswerNullException() {
    }

    public QuestionServiceAnswerNullException(String message) {
        super(message);
    }

    public QuestionServiceAnswerNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionServiceAnswerNullException(Throwable cause) {
        super(cause);
    }

    public QuestionServiceAnswerNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
