package net.danh.dcore.Utils;

public enum Status {

    TRUE("&aTrue", true),
    FALSE("&cFalse", false);
    private final String status;
    private final Boolean type;

    Status(String s, Boolean type) {
        status = s;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getType() {
        return type;
    }
}
