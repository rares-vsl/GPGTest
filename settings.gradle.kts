plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.24"
}

gitHooks {
    commitMsg { conventionalCommits() } // Applies the default conventional commits configuration
    createHooks()
}

rootProject.name = "GPGTest"