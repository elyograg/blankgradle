This is a blank gradle project with a pre-created source code structure that can be changed.
I created this because when eclipse creates a new gradle project, the structure is odd.
Everything I would have expected at the root is in a lib directory.  There is a blank test
directory structure ready for populating.  There are resources directories where things
like logging configuration should go.  The build.gradle file is prepopulated with slf4j as
the logging framework and logback as the ultimate logging destination.  It points at my
artifactory server, with mavenCentral commented.
