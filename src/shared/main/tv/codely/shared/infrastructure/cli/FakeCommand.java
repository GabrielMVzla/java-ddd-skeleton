package tv.codely.shared.infrastructure.cli;

import tv.codely.shared.domain.Service;

@Service
public class FakeCommand extends ConsoleCommand
{
    @Override
    public void execute(String[] args) {
        info("This is a fake command!");
    }
}
