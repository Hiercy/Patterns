package com.mike.patterns.behavioral.memento;

import java.util.Date;

public class Save {
    private final String projectName;
    private final String version;
    private final String commit;
    private final Date date;

    public Save(String projectName, String version, String commit) {
        this.projectName = projectName;
        this.version = version;
        this.commit = commit;
        this.date = new Date();
    }

    public String getProjectName() {
        return projectName;
    }

    public String getVersion() {
        return version;
    }

    public String getCommit() {
        return commit;
    }

    public Date getDate() {
        return date;
    }
}
