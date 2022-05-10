package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GuiMain implements ActionListener {

    JFrame f;
    Panel menu, myrcp, newrcp;
    JButton myRecipes, newRecipe, inspiration, back1, back2, back3;

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
        back1 = new JButton("Back");
        myrcp.add(back1);
        back1.setBounds(110, 100, 120, 40);
        back1.setBackground(Color.decode("#F1FFFA"));
        back1.addActionListener(this);


    }

    private void newrecipe() {
        newrcp = new Panel();
        newrcp.setLayout(null);
        newrcp.setVisible(true);
        newrcp.setBounds(0,0,360, 500);
        back2 = new JButton("Back");
        newrcp.add(back2);
        back2.setBounds(110, 100, 120, 40);
        back2.setBackground(Color.decode("#F1FFFA"));
        back2.addActionListener(this);

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


        myRecipes = new JButton("My Recipes");
        newRecipe = new JButton("New Recipe");
        inspiration = new JButton("Inspiration");



        menu.add(myRecipes);
        menu.add(newRecipe);
        menu.add(inspiration);


        myRecipes.setBounds(120, 100, 120, 40);
        newRecipe.setBounds(120, 200, 120, 40);
        inspiration.setBounds(120, 300, 120, 40);

        myRecipes.setBackground(Color.decode("#F1FFFA"));
        newRecipe.setBackground(Color.decode("#F1FFFA"));
        inspiration.setBackground(Color.decode("#F1FFFA"));

        myRecipes.addActionListener(this);
        newRecipe.addActionListener(this);
        inspiration.addActionListener(this);

        menu.add(backgroundLabel);
        f.add(menu);

    }


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

        if (e.getSource()==back1){
            f.remove(myrcp);
            createMenu();
            f.add(menu);
        }
        if (e.getSource()==back2){
            f.remove(newrcp);
            createMenu();
            f.add(menu);
        }



}


    }
