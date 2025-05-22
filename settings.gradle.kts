plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.24"
}

gitHooks {
    commitMsg { conventionalCommits() }
    hook("pre-commit") {
        from {
            """
            #!/bin/bash
            if ! git log -1 --pretty=%G? | grep -q "G"; then
              echo "Commit is not GPG-signed. Aborting."
              exit 1
            fi
            """
        }
    }
    createHooks()
}

rootProject.name = "GPGTest"