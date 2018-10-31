package x3.benjamin.playground.apiserver.model;

public class ErrorMessageDto {

    private String message;
    private String clazzName;

    public ErrorMessageDto(String message, Exception e) {
        this.setMessage(message);
        this.setClazzName(e.getClass().getCanonicalName());
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
}
