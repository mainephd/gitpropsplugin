package com.homedepot.di.dl

import org.gradle.api.Project
import org.gradle.api.Plugin

class SpringPropsPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task('springprops', type: SpringPropsTask)
    }
}
