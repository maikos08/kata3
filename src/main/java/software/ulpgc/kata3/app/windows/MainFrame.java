package software.ulpgc.kata3.app.windows;

import software.ulpgc.kata3.arquitecture.control.Command;
import software.ulpgc.kata3.arquitecture.view.SelectStatisticDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private JFreeBarchartDisplay display;
    private SelectStatisticDialog dialog;

    public MainFrame() {
        this.commands = new HashMap<>();
        setTitle("Kata_3");
        setSize(1800, 1000);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(BorderLayout.NORTH, toolbar());
        add(display = statisticPanel());
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Platforms Count");
        comboBox.addItem("Games per Year");
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commands.containsKey("select"))
                    commands.get("select").execute();
            }
        });

        dialog = new SelectStatisticDialog() {
            @Override
            public int getSelection() {
                return comboBox.getSelectedIndex();
            }
        };
        return comboBox;
    }

    private JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }

    public JFreeBarchartDisplay getDisplay() {
        return display;
    }

    public SelectStatisticDialog getDialog() {
        return dialog;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }
}
