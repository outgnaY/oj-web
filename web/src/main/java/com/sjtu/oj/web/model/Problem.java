package com.sjtu.oj.web.model;

import java.util.Date;

public class Problem {
    public long getProblemId() {
        return problemId;
    }

    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getProblemInputDescription() {
        return problemInputDescription;
    }

    public void setProblemInputDescription(String problemInputDescription) {
        this.problemInputDescription = problemInputDescription;
    }

    public String getProblemOutputDescription() {
        return problemOutputDescription;
    }

    public void setProblemOutputDescription(String problemOutputDescription) {
        this.problemOutputDescription = problemOutputDescription;
    }

    public String getProblemSamples() {
        return problemSamples;
    }

    public void setProblemSamples(String problemSamples) {
        this.problemSamples = problemSamples;
    }

    public String getProblemTestCaseScore() {
        return problemTestCaseScore;
    }

    public void setProblemTestCaseScore(String problemTestCaseScore) {
        this.problemTestCaseScore = problemTestCaseScore;
    }

    public String getProblemHint() {
        return problemHint;
    }

    public void setProblemHint(String problemHint) {
        this.problemHint = problemHint;
    }

    public Date getProblemCreateTime() {
        return problemCreateTime;
    }

    public void setProblemCreateTime(Date problemCreateTime) {
        this.problemCreateTime = problemCreateTime;
    }

    public Date getProblemLastUpdate() {
        return problemLastUpdate;
    }

    public void setProblemLastUpdate(Date problemLastUpdate) {
        this.problemLastUpdate = problemLastUpdate;
    }

    public String getProblemCreateBy() {
        return problemCreateBy;
    }

    public void setProblemCreateBy(String problemCreateBy) {
        this.problemCreateBy = problemCreateBy;
    }

    public int getProblemTimeLimit() {
        return problemTimeLimit;
    }

    public void setProblemTimeLimit(int problemTimeLimit) {
        this.problemTimeLimit = problemTimeLimit;
    }

    public int getProblemMemoryLimit() {
        return problemMemoryLimit;
    }

    public void setProblemMemoryLimit(int problemMemoryLimit) {
        this.problemMemoryLimit = problemMemoryLimit;
    }

    public long getProblemAC() {
        return problemAC;
    }

    public void setProblemAC(long problemAC) {
        this.problemAC = problemAC;
    }

    public long getProblemWA() {
        return problemWA;
    }

    public void setProblemWA(long problemWA) {
        this.problemWA = problemWA;
    }

    private long problemId;
    private String problemTitle;
    private String problemDescription;
    private String problemInputDescription;
    private String problemOutputDescription;
    private String problemSamples;
    private String problemTestCaseScore;
    private String problemHint;
    private Date problemCreateTime;
    private Date problemLastUpdate;
    private String problemCreateBy;
    private int problemTimeLimit;
    private int problemMemoryLimit;
    private long problemAC;
    private long problemWA;
}