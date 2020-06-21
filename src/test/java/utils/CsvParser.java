package utils;

import com.opencsv.bean.CsvBindByName;

public class CsvParser {

    @CsvBindByName
    private String  REGISTRATION;

    @CsvBindByName
    private String MAKE;

    @CsvBindByName
    private String MODEL;

    @CsvBindByName
    private String COLOR;

    @CsvBindByName
    private String YEAR;

    public String getREGISTRATION() { return REGISTRATION; }

    public void setREGISTRATION(String REGISTRATION) {
        this.REGISTRATION = REGISTRATION;
    }

    public String getMAKE() {
        return MAKE;
    }

    public void setMAKE(String MAKE) {
        this.MAKE = MAKE;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    @Override
    public String toString() {
        return "CsvParser{" +
                "REGISTRATION='" + REGISTRATION + '\'' +
                ", MAKE='" + MAKE + '\'' +
                ", MODEL='" + MODEL + '\'' +
                ", COLOR='" + COLOR + '\'' +
                ", YEAR='" + YEAR + '\'' +
                '}';
    }
}
