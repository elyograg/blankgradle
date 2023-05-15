This is a blank gradle project with a pre-created source code structure that
can be changed.  I created this because when eclipse creates a new gradle
project, the structure is odd.  Everything I would have expected at the root
is in a lib directory.  There is a blank test directory structure ready for
populating.  There are resources directories where things like logging
configuration should go.  The build.gradle file is prepopulated with slf4j as
the logging framework and logback as the ultimate logging destination.  It
points at my artifactory server, with mavenCentral commented.

It is recommended that you run 'git grep changeme' after cloning this
repository so you can see all the places that will most likely need an
adjustment for you to correctly create your own project.  You should also
delete the .git directory in anticipation of using this as the starting
point of your own project and source control system.
