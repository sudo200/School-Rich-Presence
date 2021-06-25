package at.sudo200.school_rich_presence;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.Objects;

public class GUI {
    public GUI(DiscordRichPresence presence) {

        JFrame frame = new JFrame();
        JButton[] buttons = {
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
                new JButton("DIC"),
                new JButton("Sport"),
                new JButton("Labor"),
        };
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
        panel.setLayout(new GridLayout());

        JButton button = new JButton("Deaktivieren");
        button.setSize(32, 32);
        button.addActionListener(e -> {
            presence.clear();
            presence.largeImageKey = "default";
            presence.largeImageText = "Schule";
            DiscordRPC.discordUpdatePresence(presence);
        });
        panel.add(button);

        for (JButton jButton : buttons) {
            jButton.setSize(32, 32);
            jButton.addActionListener(e -> {
                presence.details = jButton.getText();
                presence.largeImageText = jButton.getText();
                presence.smallImageKey = "default";
                presence.largeImageKey = jButton.getText().toLowerCase(Locale.ROOT);
                presence.startTimestamp = System.currentTimeMillis() / 1000;
                DiscordRPC.discordUpdatePresence(presence);
            });
            panel.add(jButton);
        }

        panel.setForeground(new Color(194, 194, 194));
        panel.setBackground(new Color(57, 57, 57));

        frame.add(panel, BorderLayout.CENTER);
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("resources/icon.png"))).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 120);
        frame.setResizable(false);
        frame.setTitle("School Rich Presence");
        frame.setVisible(true);

    }
}
