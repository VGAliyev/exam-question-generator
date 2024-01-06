package pro.sky.java.course2.valiyev.examquestiongenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionServiceQuestionStringNullException extends RuntimeException {
    public QuestionServiceQuestionStringNullException() {
    }

    public QuestionServiceQuestionStringNullException(String message) {
        super(message);
    }

    public QuestionServiceQuestionStringNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionServiceQuestionStringNullException(Throwable cause) {
        super(cause);
    }

    public QuestionServiceQuestionStringNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
