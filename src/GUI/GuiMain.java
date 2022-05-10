package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMain implements ActionListener {

    JFrame f;
    Panel menu, myrcp, newrcp, inspr;
    JButton myRecipes, newRecipe, inspiration, back1, back2, back3;

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
        newrcp.setLayout(null);
        newrcp.setVisible(true);
        newrcp.setBounds(0,0,360, 500);

        back2 = cb.createSimpleButton("Back");
        back2.setBounds(110, 410, 120, 40);
        back2.addActionListener(this);
        newrcp.add(back2);
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

        myRecipes.setBounds(120, 100, 120, 40);
        newRecipe.setBounds(120, 200, 120, 40);
        inspiration.setBounds(120, 300, 120, 40);

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
        }
        if (e.getSource()==back3){
            f.remove(inspr);
            createMenu();
            f.add(menu);
        }



}


    }
