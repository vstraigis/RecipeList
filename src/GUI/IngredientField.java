package GUI;

/*
    Norejau naudoti sukurti ingridientu eile, bet pagal pavyzdi
    tiesiog nukopinau viska ir palikau GuiMain action listenere

    !!!
    Siuo metu sita klase neturi jokios reiksmes
    !!!
 */


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IngredientField {

    JTextArea text = new JTextArea("New ingredient here.");
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane generalScrollPane = new JScrollPane();

    private int count;

    IngredientField(JPanel panel, Panel newrcp, int count) {

        this.count = count;


        newrcp.setLayout(null);
        newrcp.setVisible(true);
        newrcp.setBounds(0, 0, 360, 500);

        scrollPane.setBounds(0, getY(count), 200, 40);
        text.setBounds(0, getY(count), 200, 40);
        text.setFont(new Font("Arial", Font.ITALIC, 20));
        scrollPane.getViewport().add(text);

        generalScrollPane.setBounds(35, 75, 220, 300);
        generalScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setBounds(35, 75, 220, 300);
        generalScrollPane.getViewport().add(panel);


        newrcp.add(generalScrollPane);
        panel.add(scrollPane);

    }

    int getY(int count) {
        return 40 * count;
    }
}
