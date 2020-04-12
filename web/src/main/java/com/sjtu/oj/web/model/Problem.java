package com.sjtu.oj.web.model;

public class Problem {
    /**
     * 试题id
     */
    private long problemId;

    /**
     * 试题名
     */
    private String problemName;

    /**
     * 时间限制(ms)
     */
    private int timeLimit;

    /**
     * 运行时内存限制
     */
    private int memoryLimit;

    /**
     * 试题描述
     */
    private String description;

    /**
     * 输入格式描述
     */
    private String inputFormat;

    /**
     * 输出格式描述
     */
    private String outputFormat;

    /**
     * 输入样例
     */
    private String sampleInput;

    /**
     * 输出样例
     */
    private String sampleOutput;

    /**
     * 提示
     */
    private String hint;
    public Problem() { }
    public Problem(long problemId, String problemName, int timeLimit, int memoryLimit, String description,
                   String inputFormat, String outputFormat, String sampleInput, String sampleOutput, String hint) {

    }
    public long getProblemId() {
        return problemId;
    }

    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
