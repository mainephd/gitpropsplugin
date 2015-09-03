package com.homedepot

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import java.nio.file.Paths

import static org.junit.Assert.*

class GitPropsTaskTest {
    @Test
    public void canAddTaskToProject() {
        ProjectBuilder builder = ProjectBuilder.builder()
        builder.withProjectDir(Paths.get(System.getProperty('user.dir')).toFile())
        Project project = builder.build()

        def task = project.task('gitprops', type: GitPropsTask)

        assertTrue(task instanceof GitPropsTask)
    }

}
