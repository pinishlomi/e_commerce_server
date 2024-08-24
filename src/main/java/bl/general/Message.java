package bl.general;

public enum Message {
    SUCCESS("success"),
    INVALID_INT("Invalid number"),
    INVAliD_FLOAT("Invalid price"),
    INVALID_NAME("Invalid name"),
    INVALID_CATEGORY("there is no such category");

    private final String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}