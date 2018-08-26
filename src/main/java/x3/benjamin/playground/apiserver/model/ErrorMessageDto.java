package x3.benjamin.playground.apiserver.model;

import lombok.Getter;

@Getter
public class ErrorMessageDto {

    private String message;
    private String clazzName;

    public ErrorMessageDto(String message, Exception e) {
        this.message = message;
        this.clazzName = e.getClass().getCanonicalName();
    }
}
