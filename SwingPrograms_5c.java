//Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the countries on console whenever the countries are selected on the list.

package SwingPrograms_5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class SwingPrograms_5c extends JFrame {
    JList<String> countryList;
    HashMap<String, String> capitals;

    public SwingPrograms_5c() {
        setTitle("Country List Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Countries
        String[] countries = {
            "USA", "India", "Vietnam", "Canada", "Denmark",
            "France", "Great Britain", "Japan", "Africa",
            "Greenland", "Singapore"
        };

        // Map countries to capitals
        capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        // JList
        countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        countryList.setVisibleRowCount(6);
        JScrollPane scrollPane = new JScrollPane(countryList);

        // Add listener
        countryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = countryList.getSelectedValue();
                    String capital = capitals.get(selectedCountry);
                    System.out.println("Capital of " + selectedCountry + " is: " + capital);
                }
            }
        });

        add(scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingPrograms_5c();
    }
}