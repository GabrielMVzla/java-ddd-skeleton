package tv.codely.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import tv.codely.app.mooc.backend.MoocBackendApplication;
import tv.codely.shared.infrastructure.cli.ConsoleCommand;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;

import java.util.Map;

public class Starter {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("There are not enough arguments");
        }

        String  applicationName = "mooc_backend"; //args[0];
        String  commandName     = "api";//args[1];
        boolean isApiCommand    = commandName.equals("api");

        System.out.println(applicationName);
        System.out.println(commandName);

        ensureApplicationExist(applicationName);
        ensureCommandExist(applicationName, commandName);

        Class<?> applicationClass = applications().get(applicationName);

        SpringApplication app = new SpringApplication(applicationClass);

        if (!isApiCommand) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        ConfigurableApplicationContext context = app.run(args);

        if (!isApiCommand) {
            ConsoleCommand command = (ConsoleCommand) context.getBean(
                commands().get(applicationName).get(commandName)
            );

            command.execute(Arrays.copyOfRange(args, 2, args.length));
        }
    }

    private static void ensureApplicationExist(String applicationName) {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(String.format(
                "The application <%s> doesn't exist. Valids:\n- %s",
                applicationName,
                String.join("\n- ", applications().keySet())
            ));
        }
    }
    private static void ensureCommandExist(String applicationName, String commandName) {
        if (!"api".equals(commandName) && !existCommand(applicationName, commandName)) {
            throw new RuntimeException(String.format(
                "The command <%s> for application <%s> doesn't exist. Valids (application.command):\n- api\n- %s",
                commandName,
                applicationName,
                String.join("\n- ", commands().keySet())
            ));
        }
    }

    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();

        applications.put("mooc_backend", MoocBackendApplication.class);

        return applications;
    }

    private static Map<String, Map<String, Class<?>>> commands() {
        Map<String, Map<String, Class<?>>> commands = new HashMap<>();

        commands.put("mooc_backend", MoocBackendApplication.commands());

        return commands;
    }

    private static Boolean existCommand(String applicationName, String commandName) {
        Map<String, Map<String, Class<?>>> commands = commands();

        return commands.containsKey(applicationName) && commands.get(applicationName).containsKey(commandName);
    }

}
