package at.sudo200.school_rich_presence;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class GUI {
    public GUI(DiscordRichPresence presence) {

        JFrame frame = new JFrame();
        JButton[] buttons = {
                new JButton("Deaktivieren"),
                new JButton("Englisch"),
                new JButton("GGP"),
                new JButton("HWE"),
                new JButton("MTRS"),
                new JButton("Werkst\u00E4tte"),
                new JButton("Chemie"),
                new JButton("Deutsch"),
                new JButton("Ethik"),
                new JButton("Physik"),
                new JButton("FSST"),
                new JButton("Mathe"),
                new JButton("Religion"),
                new JButton("SOPK"),
                new JButton("DIC"),
                new JButton("Sport")
        };
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
        panel.setLayout(new GridLayout());

        buttons[0].setSize(32, 32);
        buttons[0].addActionListener(e -> {
            presence.clear();
            presence.largeImageKey = "default";
            presence.largeImageText = "Schule";
            DiscordRPC.discordUpdatePresence(presence);
        });
        panel.add(buttons[0]);

        for(int i = 1; i < buttons.length; i++) {
            int finalI = i;
            buttons[i].setSize(32, 32);
            buttons[i].addActionListener(e -> {
                presence.details = buttons[finalI].getText();
                presence.largeImageText = buttons[finalI].getText();
                presence.smallImageKey = "default";
                presence.largeImageKey = buttons[finalI].getText().toLowerCase(Locale.ROOT);
                presence.startTimestamp = System.currentTimeMillis()/1000;
                DiscordRPC.discordUpdatePresence(presence);
            });
            panel.add(buttons[i]);
        }

        panel.setForeground(new Color(194, 194, 194));
        panel.setBackground(new Color(57, 57, 57));

        frame.add(panel, BorderLayout.CENTER);
        frame.setIconImage(new ImageIcon(getClass().getResource("resources/icon.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 120);
        frame.setResizable(false);
        frame.setTitle("Schule Rich Presence");
        frame.setVisible(true);

    }
}
