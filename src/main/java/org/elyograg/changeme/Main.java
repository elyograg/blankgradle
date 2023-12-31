package org.elyograg.changeme;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ScopeType;

@Command(name = "changeme", sortOptions = false, scope = ScopeType.INHERIT, description = ""
    + "changeme: A sample program.", footer = StaticStuff.USAGE_OPTION_SEPARATOR_TEXT)
public final class Main implements Runnable {
  /**
   * A logger object. Gets the fully qualified class name so this can be used
   * as-is for any class.
   */
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  /** Verbose option. */
  @Option(names = { "-v" }, arity = "0", scope = ScopeType.INHERIT, description = ""
      + "Log any available debug messages.")
  private static boolean verbose;

  /**
   * An argument group in which one of the options is required. The way the shell
   * script is set up, only one required option is allowed. Recommendation is that
   * other options that might be called 'required' should have default values
   * instead of being required ... to do otherwise will require adjustments to the
   * shell script.
   */
  @ArgGroup(multiplicity = "1")
  private static RequiredOpts requiredOpts;

  private static final class RequiredOpts {
    @Option(names = { "--req" }, arity = "0", scope = ScopeType.INHERIT, description = ""
        + "changeme: a required option.")
    private static boolean required;

    /** A hidden --exit option used by the shell script. */
    @Option(names = {
        "--exit" }, arity = "0", hidden = true, scope = ScopeType.INHERIT, description = ""
            + "Exit the program as soon as it starts.")
    private static boolean exitFlag;

    /** Help option. */
    @Option(names = {
        "-h" }, arity = "0", usageHelp = true, scope = ScopeType.INHERIT, description = ""
            + "Display this command usage.")
    private static boolean help;
  }

  /** Optional option. */
  @Option(names = { "-oo",
      "--optional-option" }, arity = "1", defaultValue = "test", scope = ScopeType.INHERIT, description = ""
          + "An optional option. Default '${DEFAULT-VALUE}'")
  private static String optional;

  public static final void main(final String[] args) {
    final CommandLine cmd = new CommandLine(new Main());
    cmd.setHelpFactory(StaticStuff.createLeftAlignedUsageHelp());
    final int exitCode = cmd.execute(args);
    System.exit(exitCode);
  }

  @Override
  public void run() {
    log.info("Program starting");

    if (RequiredOpts.exitFlag) {
      System.exit(0);
    }
  }
}
