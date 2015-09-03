package com.homedepot

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import java.nio.file.Paths;
import static org.junit.Assert.*

class GitPropsPluginTest {

    @Test
    public void gitPropsPluginAddsGitPropsToProject() {
        ProjectBuilder builder = ProjectBuilder.builder()
        builder.withProjectDir(Paths.get(System.getProperty('user.dir')).toFile())
        Project project = builder.build()

        project.pluginManager.apply 'com.homedepot.gitprops'
        assertTrue(project.tasks.gitprops instanceof GitPropsTask)
    }
}

