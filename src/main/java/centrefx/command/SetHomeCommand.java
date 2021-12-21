package centrefx.command;

import centrefx.util.IEntityDataSaver;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;

public class SetHomeCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(CommandManager.literal("home").then(CommandManager.literal("set").executes(context -> {

            IEntityDataSaver player = (IEntityDataSaver) context.getSource().getPlayer();
            BlockPos playerPos = context.getSource().getPlayer().getBlockPos();
            int[] pos = {playerPos.getX(), playerPos.getY(), playerPos.getZ()};
//            String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";
            player.getPersistentData().putIntArray("homepos", pos);
            context.getSource().sendFeedback(new LiteralText("Set Home at (" + pos[0] + ", " + pos[1] + ", " + pos[2] + ")"), true);
            return 1;
        })));
    }
}

