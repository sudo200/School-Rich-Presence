package at.sudo200.school_rich_presence;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

public class Main {

    public static void main(String[] args) {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        DiscordRPC.discordInitialize("815818215682867211", handlers, true);

        DiscordRichPresence presence = new DiscordRichPresence();
        DiscordRPC.discordRunCallbacks();
        new GUI(presence);
    }
}
