package net.danh.dcore.InputCatcher;

import java.util.Arrays;
import java.util.List;

public class InputType_Number {
    private InputEnums.InputMethod method = InputEnums.InputMethod.ONE;
    private InputEnums.NumberType numberType = InputEnums.NumberType.POSITIVE;
    private InputEnums.NumberFormat numberFormat = InputEnums.NumberFormat.INTEGER;
    private String start = "&ePlease type a number in the chat. Type cancel/stop to cancel input process.";
    private String cancel = "&cYou canceled the input process!";
    private List<String> cancels = Arrays.asList("cancel", "stop");
    private String not_a_number = "&cThe input is not a number.";
    private String invalid_number = "&cYou must enter a positive number";
    private String invalid_format_number = "&cThe number you typed is to big or not a integer";

    public InputEnums.InputMethod getMethod() {
        return method;
    }

    public InputEnums.NumberType getNumberType() {
        return numberType;
    }

    public InputEnums.NumberFormat getNumberFormat() {
        return numberFormat;
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

    public String getNot_a_number() {
        return not_a_number;
    }

    public String getInvalid_number() {
        return invalid_number;
    }

    public String getInvalid_format_number() {
        return invalid_format_number;
    }

    public void setMethod (InputEnums.InputMethod inputMethod) {
        this.method = inputMethod ;
    }

    public void setNumberType (InputEnums.NumberType numberType) {
        this.numberType = numberType;
    }

    public void setNumberFormat (InputEnums.NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
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

    public void setNot_a_number (String s) {
        this.not_a_number = s;
    }

    public void setInvalid_number (String s) {
        this.invalid_number = s;
    }

    public void setInvalid_format_number (String s) {
        this.invalid_format_number = s;
    }
}
