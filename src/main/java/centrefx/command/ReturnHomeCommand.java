package centrefx.command;

import centrefx.util.IEntityDataSaver;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

public class ReturnHomeCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("home").then(CommandManager.literal("return").executes(context -> {

            IEntityDataSaver player = (IEntityDataSaver) context.getSource().getPlayer();
            int[] homePos = player.getPersistentData().getIntArray("homepos");

            if (homePos.length != 0) {
//                int[] playerPos = player.getPersistentData().getIntArray("homepos");
                context.getSource().getPlayer().requestTeleport(homePos[0], homePos[1], homePos[2]);
                context.getSource().sendFeedback(new LiteralText("Player Returned Home."), true);
                return 1;
            } else {
                context.getSource().sendFeedback(new LiteralText("No Home Position has been Set!"), true);
                return 0;
            }
        })));
    }
}
