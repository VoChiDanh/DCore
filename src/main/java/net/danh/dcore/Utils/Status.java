package net.danh.dcore.Utils;

public enum Status {

    TRUE("&aTrue"),
    FALSE("&cFalse");
    private final String status;

    Status(String s) {
        status = s;
    }

    public String getStatus() {
        return status;
    }
}
