package x3.benjamin.playground.apiserver.model;


public class ErrorMessageDto {

    private String message;
    private String clazzName;

    public ErrorMessageDto(String message, Exception e) {
        this.message = message;
        this.clazzName = e.getClass().getCanonicalName();
    }

    public String getMessage() {
        return message;
    }

    public String getClazzName() {
        return clazzName;
    }
}
