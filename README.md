# Blank Grade Java project

This is a blank gradle java project with a pre-created source code structure
that can be changed.  When eclipse creates a new gradle project, the
structure is odd.  Everything expected at the root is in a lib directory.
Created this as a quick starting point for new projects so no surgery is
required.

The overall design of this project is for a commandline program.  If you
want to write a server-type program, the shell script will need extensive
changes.

You should run `git grep -i changeme` and `find . | grep -i changeme` after
cloning this repository so you can see all the places that will most likely
need an adjustment for you to correctly create your own project.  You should
also delete the .git directory after looking over the output of the above
commands in anticipation of using this as the starting point for your own
project and source control system.  Importing the gradle project works
correctly with eclipse and intellij.  Other IDEs were not attempted.

The project comes with the gradle wrapper, version 8.1.1.  All the things
that say `changeme` are very easy to change in a good IDE.

## Demo on a bash environment

- Clone the project.
- cd to the new directory.
- `./gradlew clean jar`
- `./changeme`

## To use for your own project:

- Clone this to a new directory, or clone and then rename.
- Change to the new directrory.
- `rm -rf .git` to remove this git repo.  You'll probably want to keep the .gitignore file.
- `grep -rl changeme` to find content within the files that needs adjustment.
- Change the package names and directories that contain 'changeme'.  A good IDE will do both at the same time.
- If you're going to put your project in a git repo, follow normal git procedures.
- Build your project!

## Structure

- A complete project structure ready to be populated.
  - `src/main/java/org/elyograg/changeme`
    - `Main.java`
      - A mostly empty template class.
      - Sets up a picocli framework for handling commandline options.
    - `StaticStuff.java`
    -  A class to put static methods, constants, etc.
  - `src/main/resources`
    - A place to put resources.
      - Includes a `logback.xml` config file as a starting point for a logging config.
      - One common thing found here is properties files like `application.properties`
  - `src/test/java/org/elyograg/changeme`
    - `MainTests.java`
      - A mostly empty template class.
  - `src/test/resources`
    - A place to put resources for test code.
  - `build.gradle`
    - Uses mavenCentral for dependency downloads.
    - Configured to build for Java 11.
    - Includes picocli.
    - Uses slf4j as the logging framework.
    - Uses logback as the final logging destination.
    - Uses JUnit4 for a test framework.
    - Automatically gets new minor and point releases of dependencies.  Adjust build.gradle if you don't want this.
    - Has a "jar" target that builds a jar with dependencies.  The build.gradle file specifies the class with a `main` method so it can be started with `java -jar filename.jar`.
  - `settings.gradle`
    - Just defines the project name.
  - `changeme`
    - A bash script that can handle `JAVA_HOME`, finds the jar, and starts it with all commandline options sent to script.  Validates that the provided Java is new enough to run the program and alerts if not.  You'll want to rename and edit this script if you plan to use it.
