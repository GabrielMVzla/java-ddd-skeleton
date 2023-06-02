package tv.codely.shared.infrastructure.cli;

import tv.codely.shared.domain.Service;

@Service
public class AnotherFakeCommand extends ConsoleCommand{

    @Override
    public void execute(String[] args) {
        info("This is another fake command!");
    }
}
