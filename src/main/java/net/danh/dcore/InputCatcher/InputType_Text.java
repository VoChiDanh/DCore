package net.danh.dcore.InputCatcher;

import java.util.Arrays;
import java.util.List;

public class InputType_Text {
    private InputEnums.InputMethod method = InputEnums.InputMethod.ONE;
    private String start = "&ePlease type a text in the chat. Type cancel/stop to cancel input process.";
    private String cancel = "&cYou canceled the input process!";
    private List<String> cancels = Arrays.asList("cancel", "stop");
    private String not_a_text = "&cThe input is not a text.";

    public InputEnums.InputMethod getMethod() {
        return method;
    }

    public String getStart() {
        return start;
    }

    public String getCancel() {
        return cancel;
    }

    public List<String> getCancelList() {
        return cancels;
    }

    public String getNot_a_text() {
        return not_a_text;
    }

    public void setMethod (InputEnums.InputMethod inputMethod) {
        this.method = inputMethod ;
    }

    public void setStart (String s) {
        this.start = s;
    }

    public void setCancel(String s) {
        this.cancel = s;
    }

    public void setCancelList (List<String> cancel) {
        this.cancels = cancel;
    }

    public void setNot_a_text (String s) {
        this.not_a_text = s;
    }
}
