package tv.codely.shared.infrastructure.cli;

//@Command
public class FakeCommand extends ConsoleCommand
{
    @Override
    public void execute(String[] args) {
        info("This is a fake command!");
    }
}
