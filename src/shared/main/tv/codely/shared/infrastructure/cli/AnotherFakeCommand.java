package tv.codely.shared.infrastructure.cli;

public class AnotherFakeCommand extends ConsoleCommand{

    @Override
    public void execute(String[] args) {
        info("This is a fake command!");
    }
}
