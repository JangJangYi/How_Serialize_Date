package feb31dealwith;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@ToString
@Slf4j
public class RequestSetterDTO {
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate date;

    public RequestSetterDTO() {
        log.info(">>>>>>>>> create RequestSetterDto");
    }

    public RequestSetterDTO(LocalDate date) {
        this.date = date;
    }
}
