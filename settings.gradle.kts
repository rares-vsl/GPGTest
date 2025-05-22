plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.24"
}

gitHooks {
    commitMsg { conventionalCommits() }
    hook("pre-commit") {
        from("#!/bin/sh") {
            """
            if git log --pretty="%G?" origin/HEAD..HEAD | grep -qv "G"; then
                echo "Push rejected: All commits must be signed."
                exit 1
            fi
            """
        }
    }
    hook("post-commit") {
        from("#!/bin/sh") {
            """
            if ! git log -1 --pretty="%G?" HEAD | grep -q "G"; then
                echo "Commit is not GPG-signed. Please use 'git commit -S'."
                exit 1
            fi
            """
        }
    }
    createHooks()
}

rootProject.name = "GPGTest"