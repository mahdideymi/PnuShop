package models;

public class SharedPrefUserModel {
    private String nameAndFamily;
    private String email;
    private String telNumber;
    private String field;
    private String unit;
    private String token;
    private String colligateNum;

    public String getNameAndFamily() {
        return nameAndFamily;
    }

    public void setNameAndFamily(String nameAndFamily) {
        this.nameAndFamily = nameAndFamily;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getColligateNum() {
        return colligateNum;
    }

    public void setColligateNum(String colligateNum) {
        this.colligateNum = colligateNum;
    }
}
