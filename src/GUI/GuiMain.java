package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GuiMain implements ActionListener {

    private JFrame f;
    private Panel menu, myrcp, newrcp, inspr;
    private JPanel newRcpPanel;
    private JButton myRecipes, newRecipe, inspiration, back1, back3;
    private JButton back2, save2, addIngr, rmIngr, viewGuide;            //BUTTONS FOR CREATE RECIPE
    private JTextField newRecipeTitle;
    private JScrollPane scrollPane;

    CreateButton cb = new CreateButton();

    public GuiMain(){
        createFrame("Recipe Book",360, 500);
        createMenu();
    }

    private void createFrame(String title, int width, int height) {
        f = new JFrame(title);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setIconImage(new ImageIcon("Resources/121895.png").getImage());
        f.getContentPane().setBackground(Color.decode("#D5C7BC"));
    }


    private void myrecipes() {
        myrcp = new Panel();
        myrcp.setLayout(null);
        myrcp.setVisible(true);
        myrcp.setBounds(0,0,360, 500);

        back1 = cb.createSimpleButton("Back");
        myrcp.add(back1);
        back1.setBounds(110, 410, 120, 40);
        back1.addActionListener(this);


        JLabel title = new JLabel("My Recipes");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.decode("#785964"));
        myrcp.add(title);
        title.setBounds(95, 10, 200, 50);
    }

    private void newrecipe() {

        newrcp = new Panel();
        newRecipeTitle = new JTextField();
        newRcpPanel = new JPanel();
        scrollPane = new JScrollPane();

        CreateRecipe cr = new CreateRecipe(newrcp, newRecipeTitle, newRcpPanel, scrollPane);

        back2 = cb.createSimpleButton("Back");
        back2.setBounds(25, 410, 120, 40);
        back2.addActionListener(this);
        newrcp.add(back2);

        save2 = cb.createSimpleButton("Save");
        save2.setBounds(195, 410, 120, 40);
        save2.addActionListener(this);
        newrcp.add(save2);

        addIngr = cb.createSimpleButton("+");
        addIngr.setBounds(265, 75, 30, 30);
        addIngr.addActionListener(this);
        newrcp.add(addIngr);

        rmIngr = cb.createSimpleButton("-");
        rmIngr.setBounds(300, 75, 30, 30);
        rmIngr.addActionListener(this);
        newrcp.add(rmIngr);

        viewGuide = cb.createSimpleButton("Guide");
        viewGuide.setBounds(265, 120, 65, 35);
        viewGuide.addActionListener(this);
        newrcp.add(viewGuide);
    }

    private void createMenu() {
        menu = new Panel();
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setBounds(-10, -10, 360, 500);

        ImageIcon background = new ImageIcon("Resources/resize.jpg");
        Image img = background.getImage();
        Image newImg = img.getScaledInstance(360, 500, java.awt.Image.SCALE_SMOOTH);
        background = new ImageIcon(newImg);
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 360, 500);

        myRecipes = cb.createSimpleButton("My recipes");
        newRecipe = cb.createSimpleButton("New recipe");
        inspiration = cb.createSimpleButton("Inspiration");

        menu.add(myRecipes);
        menu.add(newRecipe);
        menu.add(inspiration);

        myRecipes.setBounds(80, 75, 200, 60);
        newRecipe.setBounds(80, 170, 200, 60);
        inspiration.setBounds(80, 300, 200, 60);

        myRecipes.addActionListener(this);
        newRecipe.addActionListener(this);
        inspiration.addActionListener(this);

        menu.add(backgroundLabel);
        f.add(menu);
    }
    private void createinspiration() {
        inspr = new Panel();
        inspr.setLayout(null);
        inspr.setVisible(true);
        inspr.setBounds(0,0,360, 500);
        back3 = cb.createSimpleButton("Back");
        back3.setBounds(110, 410, 120, 40);;
        inspr.add(back3);
        back3.addActionListener(this);

        ImageIcon background1 = new ImageIcon("Resources/original.jpg");
        Image img1 = background1.getImage();
        Image newImg1 = img1.getScaledInstance(360, 500, java.awt.Image.SCALE_SMOOTH);
        background1 = new ImageIcon(newImg1);
        JLabel backgroundLabel1 = new JLabel(background1);
        backgroundLabel1.setBounds(0, 0, 360, 500);
        inspr.add(backgroundLabel1);
    }
    //NEEDED FOR ADDING INGREDIENTS WHILE CREATING RECIPE
    private int countAddIngr = 0;
    private List<JLabel> listOfLabels = new ArrayList<JLabel>();
    private List<JTextArea> listOfTextAreas = new ArrayList<JTextArea>();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==myRecipes){
            f.remove(menu);
            myrecipes();
            f.add(myrcp);
        }
        if (e.getSource()==newRecipe){
            f.remove(menu);
            newrecipe();
            f.add(newrcp);
        }
        if (e.getSource()==inspiration){
            f.remove(menu);
            createinspiration();
            f.add(inspr);
        }

        if (e.getSource()==back1){
            f.remove(myrcp);
            createMenu();
            f.add(menu);
        }
        if (e.getSource()==back2){
            f.remove(newrcp);
            createMenu();
            f.add(menu);
            countAddIngr=0;
        }
        if (e.getSource()==back3){
            f.remove(inspr);
            createMenu();
            f.add(menu);
        }
        if (e.getSource()==viewGuide){
            RecGuide rg = new RecGuide();
        }
        if (e.getSource()==addIngr){

            newRcpPanel.removeAll();

            JTextArea ingred = new JTextArea();
            ingred.setSize(100, 200);
            listOfTextAreas.add(ingred);
            listOfLabels.add(new JLabel(countAddIngr+1 + ": "));

            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            GridBagConstraints labelConstraints = new GridBagConstraints();

            // Add labels and text fields
            for(int i = 0; i <= countAddIngr ; i++)
            {
                // Text field constraints
                textFieldConstraints.gridx = 1;
                textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                textFieldConstraints.weightx = 0.5;
                textFieldConstraints.insets = new Insets(10, 10, 10, 10);
                textFieldConstraints.gridy = i;

                // Label constraints
                labelConstraints.gridx = 0;
                labelConstraints.gridy = i;
                labelConstraints.insets = new Insets(10, 10, 10, 10);

                // Add them to panel
                newRcpPanel.add(listOfLabels.get(i), labelConstraints);
                newRcpPanel.add(listOfTextAreas.get(i), textFieldConstraints);
            }

            // Align components top-to-bottom
            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = countAddIngr;
            c.weighty = 1;
            newRcpPanel.add(new JLabel(), c);

            newRcpPanel.updateUI();
            countAddIngr++;
            System.out.println("Ingredient count is: " + countAddIngr);
        }
        if (e.getSource()==rmIngr){
            countAddIngr--;
            newRcpPanel.remove(listOfLabels.get(countAddIngr));
            newRcpPanel.remove(listOfTextAreas.get(countAddIngr));
            newRcpPanel.updateUI();
        }

    }


}