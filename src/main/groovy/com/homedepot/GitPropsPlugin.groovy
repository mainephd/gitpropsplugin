package com.homedepot

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.Task

/* significant simplification based on article by Lieven Doclo
 * http://www.insaneprogramming.be/blog/2014/08/15/spring-boot-info-git/
 */

class GitPropsPlugin implements Plugin<Project> {

    void apply(Project target) {
        target.task('gitprops', type: GitPropsTask)
    }

}
