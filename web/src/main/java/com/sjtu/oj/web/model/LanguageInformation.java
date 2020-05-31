package com.sjtu.oj.web.model;

public class LanguageInformation {
    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageDescription() {
        return languageDescription;
    }

    public void setLanguageDescription(String languageDescription) {
        this.languageDescription = languageDescription;
    }

    public String getCompileCommand() {
        return compileCommand;
    }

    public void setCompileCommand(String compileCommand) {
        this.compileCommand = compileCommand;
    }

    private String languageName;
    private String languageDescription;
    private String compileCommand;
    public LanguageInformation() {}
    public LanguageInformation(String languageName, String languageDescription, String compileCommand) {
        this.languageName = languageName;
        this.languageDescription = languageDescription;
        this.compileCommand = compileCommand;
    }
}
