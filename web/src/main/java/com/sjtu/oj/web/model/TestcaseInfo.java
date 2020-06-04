package com.sjtu.oj.web.model;

public class TestcaseInfo {
    public TestcaseInfo(String inputName, String outputName, double score) {
        this.inputName = inputName;
        this.outputName = outputName;
        this.score = score;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private String inputName;
    private String outputName;
    private double score;
}