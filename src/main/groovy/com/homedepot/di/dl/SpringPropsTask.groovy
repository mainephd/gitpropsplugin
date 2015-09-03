package com.homedepot.di.dl

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class SpringPropsTask extends DefaultTask {

    def git = org.ajoberstar.grgit.Grgit.open(project.file('.'))
    def lastCommit = git.head().abbreviatedId;
    def gitProps = new Properties();

    @TaskAction
    generateGitProperties() {
        try {
        def dir = new File(project.buildDir, "resources/main")
        def file = new File(project.buildDir, "resources/main/git.properties")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        if (!file.exists()) {
            file.createNewFile()
        }
        def map = [  "git.commit.id"           : git.head().id
                   , "git.commit.user"         : git.head().author.name
                   , "git.commit.user.email"   : git.head().author.email
                   , "git.commit.message"      : git.head().shortMessage
                   , "git.commit.time"         : git.head().date.toString()
                   , "git.branch"              : git.branch.current.name]
        gitProps.putAll(map)
        gitProps.store(file.newWriter(), "")
        } catch (e) {
            project.logger.error('Unable to update git.properties', e)
        }
    }
}
