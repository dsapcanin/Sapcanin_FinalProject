package tripplanner.gui;

import tripplanner.model.*;
import tripplanner.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TripPlannerGUI extends JFrame {

    private Trip trip = new Trip("standard");
    private DefaultListModel<String> model = new DefaultListModel<>();
    private JList<String> list = new JList<>(model);
    private JTextArea output = new JTextArea(6, 30);

    public TripPlannerGUI() {
        super("Trip Planner");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(topPanel(), BorderLayout.NORTH);
        add(centerPanel(), BorderLayout.CENTER);
        add(bottomPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel topPanel() {
        JPanel p = new JPanel();
        JComboBox<String> box = new JComboBox<>(new String[]{"Bosnia", "Italy", "France"});

        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            Country c = switch ((String) box.getSelectedItem()) {
                case "Bosnia" -> new Bosnia();
                case "Italy" -> new Italy();
                default -> new France();
            };
            trip.addCountry(c);
            model.addElement(c.getName());
        });

        JButton remove = new JButton("Remove");
        remove.addActionListener(e -> {
            String selected = list.getSelectedValue();
            if (selected != null) {
                trip.removeCountry(selected);
                model.removeElement(selected);
            }
        });

        p.add(box);
        p.add(add);
        p.add(remove);
        return p;
    }

    private JPanel centerPanel() {
        JPanel p = new JPanel();
        p.add(new JScrollPane(list));
        return p;
    }

    private JPanel bottomPanel() {
        JPanel p = new JPanel();

        JButton fact = new JButton("Fun Fact");
        fact.addActionListener(e -> {
            String selected = list.getSelectedValue();
            if (selected == null) return;
            Country c = switch (selected) {
                case "Bosnia" -> new Bosnia();
                case "Italy" -> new Italy();
                default -> new France();
            };
            output.setText(c.getFunFact());
        });

        JButton cost = new JButton("Cost");
        cost.addActionListener(this::calculateCost);

        JButton save = new JButton("Save");
        save.addActionListener(e -> FileManager.saveItinerary(trip.getCountries()));

        JButton load = new JButton("Load");
        load.addActionListener(e -> {
            model.clear();
            trip.clearCountries();
            for (Country c : FileManager.loadItinerary()) {
                trip.addCountry(c);
                model.addElement(c.getName());
            }
        });

        p.add(fact);
        p.add(cost);
        p.add(save);
        p.add(load);
        p.add(new JScrollPane(output));

        return p;
    }

    private void calculateCost(ActionEvent e) {
        String input = JOptionPane.showInputDialog("Days per country:");
        if (input == null || !input.matches("\\d+")) return;
        int days = Integer.parseInt(input);
        double total = trip.calculateTotalCost(days);
        output.setText("Total cost: $" + total);
    }
}
