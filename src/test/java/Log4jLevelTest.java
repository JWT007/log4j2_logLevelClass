import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Log4jLevelTest {

  @Nested
  class InnerClass {

    @Test
    void testLogLevelWithClassName() {

      final Class<?> clazz = this.getClass();

      final Logger loggerForClass = LogManager.getLogger(clazz);
      Configurator.setLevel(loggerForClass, Level.INFO);

      System.out.println();
      System.out.println(" ==================================================================================");
      System.out.println();

      System.out.println("Class name                :: " + clazz.getName());

      System.out.println();
      System.out.println(" ==================================================================================");
      System.out.println();

      System.out.println("Logger name               :: " + loggerForClass.getName());
      System.out.println("Logger level              :: " + loggerForClass.getLevel());
      System.out.println();
      System.out.println("Configured Loggers (1)    :: ");
      System.out.println();

      for (LoggerConfig configuredLogger : LoggerContext.getContext(false).getConfiguration().getLoggers().values()) {
        System.out.println("  o " + configuredLogger + "(" + configuredLogger.getLevel() + ")");
      }

      System.out.println();
      System.out.println(" ==================================================================================");
      System.out.println();
      System.out.println(">> Configurator.setLevel(Inner.class, Level.DEBUG");
      System.out.println();
      Configurator.setLevel(InnerClass.class, Level.DEBUG);

      System.out.println("Logger name               :: " + loggerForClass.getName());
      System.out.println("Logger level              :: " + loggerForClass.getLevel());
      System.out.println();
      System.out.println("Configured Loggers (1)    :: ");
      System.out.println();
      for (LoggerConfig configuredLogger : LoggerContext.getContext(false).getConfiguration().getLoggers().values()) {
        System.out.println("  o " + configuredLogger + "(" + configuredLogger.getLevel() + ")");
      }

    }

  }

}
