package com.homedepot

import org.ajoberstar.grgit.Grgit
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/* significant simplification based on article by Lieven Doclo
 * http://www.insaneprogramming.be/blog/2014/08/15/spring-boot-info-git/
 */

class GitPropsTask extends DefaultTask {

    def git = Grgit.open()
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
                   , "git.branch"              : git.branch.current.name
                   , "git.branch.fullName"     : git.branch.current.fullName
        ]
        gitProps.putAll(map)
        gitProps.store(file.newWriter(), "")
        } catch (e) {
            project.logger.error('Unable to update git.properties', e)
        }
    }
}
