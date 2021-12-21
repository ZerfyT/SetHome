package centrefx.util;

import centrefx.command.ReturnHomeCommand;
import centrefx.command.SetHomeCommand;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class CommandRegister {

    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);

    }
}
