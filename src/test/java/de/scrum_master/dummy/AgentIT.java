package de.scrum_master.dummy;

import org.junit.Test;

import java.io.PrintStream;
import java.lang.instrument.UnmodifiableClassException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AgentIT {
  @Test
  public void test() throws UnmodifiableClassException {
    System.out.println("[Test OUT] Before manual JRE bootstrap class retransformation");
    System.err.println("[Test ERR] Before manual JRE bootstrap class retransformation");
    // Just for fun, manually apply dummy class transformation to some JRE bootstrap classes. This is unrelated to the
    // Surefire issue, but produces a few more log lines with 'loader = null', signifying the boot loader.
    Agent.INSTRUMENTATION.retransformClasses(AgentIT.class, String.class, URL.class, PrintStream.class, Integer.class);
    System.out.println("[Test OUT] After manual JRE bootstrap class retransformation");
    System.err.println("[Test ERR] After manual JRE bootstrap class retransformation");
    assertTrue(true);
  }
}
