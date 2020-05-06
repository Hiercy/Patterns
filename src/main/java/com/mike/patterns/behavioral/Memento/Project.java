package com.mike.patterns.behavioral.Memento;

import java.util.Date;

public class Project {
    private String projectName;
    private String version;
    private String commit;
    private Date date;

    public Project() {
    }

    public void setCommitAndVersion(String commit, String version) {
        this.commit = commit;
        this.version = version;
        this.date = new Date();
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Save save() {
        return new Save(projectName, version, commit);
    }

    public void load(Save save) {
        this.projectName = save.getProjectName();
        this.version = save.getVersion();
        this.commit = save.getCommit();
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Project:\n" +
                "projectName:'" + projectName + '\'' +
                ",\nversion:'" + version + '\'' +
                ",\ncommit:'" + commit + '\'' +
                ",\ndate: " + date + "\n";
    }
}
