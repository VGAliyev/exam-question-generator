package pro.sky.java.course2.valiyev.examquestiongenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExaminerServiceImplAmountOutOfRange extends RuntimeException {
    public ExaminerServiceImplAmountOutOfRange() {
    }

    public ExaminerServiceImplAmountOutOfRange(String message) {
        super(message);
    }

    public ExaminerServiceImplAmountOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }

    public ExaminerServiceImplAmountOutOfRange(Throwable cause) {
        super(cause);
    }

    public ExaminerServiceImplAmountOutOfRange(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
