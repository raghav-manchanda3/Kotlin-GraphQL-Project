buildscript {
    dependencies {
        classpath("com.apollographql.apollo3:apollo-gradle-plugin:3.8.1")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
}