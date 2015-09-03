package com.homedepot.di.dl

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class generateSpringProperties extends DefaultTask {

def repo
def dir
def file

    @TaskAction
    generateGitProperties() {
        try {
        def repo = org.ajoberstar.grgit.Grgit.open(project.file('.'))
        def dir = new File(project.buildDir, "resources/main")
        def file = new File(project.buildDir, "resources/main/git.properties")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        if (!file.exists()) {
            file.createNewFile()
        }
        def map = ["git.branch"                : repo.branch.current.name
                   , "git.commit.id"           : repo.head().id
                   , "git.commit.id.abbrev"    : repo.head().abbreviatedId
                   , "git.commit.user"         : repo.head().author.name
                   , "git.commit.user.email"   : repo.head().author.email
                   , "git.commit.message"      : repo.head().shortMessage
                   , "git.commit.message.full" : repo.head().fullMessage
                   , "git.commit.time"         : repo.head().date.toString()]
        def props = new Properties()
        props.putAll(map)
        props.store(file.newWriter(), "")
        } catch (e) {
            project.logger.error('Unable to generate Git properties file.', e)
        }
    }


}
