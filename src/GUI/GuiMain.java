package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class GuiMain implements ActionListener {

//    TODO: UX improvements:
//    Success message after save of recipe/ ingredient
//    Implement recipe updating functionality
//    when adding new recipe it should be clear how to add one more, now i have to go back and forth
//    clear ingredients after recipe creation (shows ingredients of recipe saved before when creating a new one)
//    After adding comments, there is no button for going back, unclear what to do, no success message after save

//    TODO: UI improvements:
//    Main window: button text is not clearly visible, maybe update colors or add background for buttons
//    Update naming. It is not really clear what a 'guide' is, or that + and - buttons add new ingredients


//    TODO: general code improvements
//    Refactor naming: all methods should be camel-cased, all classes- pascal-cased. Names should be clear without any additional comments
//    Folder structure - separate folders for backend, visual components
//    Remove unused code, leave only useful comments. All comments should follow the same structure


    private JFrame f, guideFrame;
    // TODO: refactor naming. Names should speak for themselves, "f" or similar names should not be present
    // TODO: remove unused code, console.logs
    //f - frame of the main window
    //guideFrame - frame of the popup window when writing comments for a recipe
    private Panel menu, myrcp, newrcp, inspr;
    //menu - main panel in frame
    //myrcp - ViewRecipe panel
    //newrcp - CreateRecipe panel
    //insp - Inspiration panel
    private JPanel newRcpPanel;
    //newRcpPanel - jpanel for adding ingridients in CreateRecipe panel
    private JButton myRecipes, newRecipe, inspiration;
    //Main three buttons in our main menu
    private JButton back1, back2, back3;
    //back1 is back from ViewRecipes to the main menu
    //back2 is back from CreateRecipe to the main menu
    //back3 is back from Inspiration to main menu
    private JButton save2, addIngr, rmIngr, viewGuide, saveGuide;
    //save2 is to store all info in CreateRecipe to our Recipe class
    //addIngr (+) is to add a text field to write an ingredient
    //rmIngr (-) is to remove last text field
    //viewGuide is to open a new frame where comments can be written
    //saveGuide is to store whatever we write in guide text area into a string "guide"
    private JTextField newRecipeTitle;
    //newRecipeTitle - texd field for the name of a recipe in newrcp panel
    private JScrollPane scrollPane, scrollingRecipes;
    //scrollPane - scrolling pane where newRcpPanel is stored, where ingredients are stored
    //scrollingRecipes - scrolling pane where data about recipes is stored
    private String guide;
    //guide - string where contents of text area of viewGuide are stored
    private JTextArea guideArea, recipeTextArea;
    //guideArea - text area in viewGuide
    //recipeTextArea - text area in ViewRecipes

    CreateButton cb = new CreateButton(); //for default any button creation


    public GuiMain() {
        createFrame("Recipe Book", 360, 500);
        createMenu();
    }

    //Main menu frame
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

    //ViewRecipes frame
    private void myrecipes() {
        myrcp = new Panel();
        recipeTextArea = new JTextArea();
        scrollingRecipes = new JScrollPane(recipeTextArea);

        myrcp.setLayout(null);
        myrcp.setVisible(true);
        myrcp.setBounds(0, 0, 360, 500);

        scrollingRecipes.setBounds(25, 70, 250, 300);
        scrollingRecipes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        recipeTextArea.setBounds(25, 70, 250, 300);
        recipeTextArea.setBorder(new LineBorder(Color.BLACK));
        scrollingRecipes.getViewport().setBackground(Color.WHITE);
        scrollingRecipes.getViewport().add(recipeTextArea);

        myrcp.add(scrollingRecipes);


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

    //CreateRecipe frame
    private void newrecipe() {
        newrcp = new Panel();
        newRecipeTitle = new JTextField("<enter title>");
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

    //Guide frame when creating a recipe
    private void createGuide() {
        guideFrame = new JFrame();
        guideArea = new JTextArea("Explain how to cook here!");
        RecGuide rg = new RecGuide(guideFrame, guideArea);

        saveGuide = cb.createSimpleButton("Save");
        saveGuide.setBounds(280, 300, 75, 30);
        saveGuide.addActionListener(this);
        guideFrame.add(saveGuide);
    }

    //Main menu frame
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

    //Insipration frame
    // TODO: all names for methods should be camel cased here and in other places
    private void createinspiration() {
        inspr = new Panel();
        inspr.setLayout(null);
        inspr.setVisible(true);
        inspr.setBounds(0, 0, 360, 500);
        back3 = cb.createSimpleButton("Back");
        back3.setBounds(110, 410, 120, 40);
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
    private int countAddIngr = 0;  //Counts how many ingredients we are using
    private List<JLabel> listOfLabels = new ArrayList<JLabel>(); //List of numbers of the ingredients (1,2,...)
    private List<JTextArea> listOfTextAreas = new ArrayList<JTextArea>(); //List of text areas of ingredients


    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: refactor this part, too many if statements (map / switch)
        if (e.getSource() == myRecipes) {
            f.remove(menu);
            myrecipes();
            f.add(myrcp);
        }
        if (e.getSource() == newRecipe) {
            f.remove(menu);
            newrecipe();
            f.add(newrcp);
        }
        if (e.getSource() == inspiration) {
            f.remove(menu);
            createinspiration();
            f.add(inspr);
        }

        if (e.getSource() == back1) {
            f.remove(myrcp);
            createMenu();
            f.add(menu);
        }
        if (e.getSource() == back2) {
            f.remove(newrcp);
            createMenu();
            f.add(menu);
            countAddIngr = 0;
        }
        if (e.getSource() == back3) {
            f.remove(inspr);
            createMenu();
            f.add(menu);
        }
        if (e.getSource() == viewGuide) {
            createGuide();
        }
        if (e.getSource() == saveGuide) {
            guide = guideArea.getText();
        }
        if (e.getSource() == addIngr) {

            newRcpPanel.removeAll();

            JTextArea ingred = new JTextArea();
            ingred.setSize(100, 200);
            listOfTextAreas.add(ingred);
            listOfLabels.add(new JLabel(countAddIngr + 1 + ": "));

            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            GridBagConstraints labelConstraints = new GridBagConstraints();

            // Add labels and text fields
            for (int i = 0; i <= countAddIngr; i++) {
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
            // System.out.println("Ingredient count is: " + countAddIngr);
        }
        if (e.getSource() == rmIngr) {
            countAddIngr--;
            newRcpPanel.remove(listOfLabels.get(countAddIngr));
            newRcpPanel.remove(listOfTextAreas.get(countAddIngr));
            newRcpPanel.updateUI();
        }
        if (e.getSource() == save2) {
            //  System.out.println("Save is pressed");
            ArrayList<String> listOfIngredients = new ArrayList<String>();
            for (int i = 0; i < countAddIngr; i++) {
                listOfIngredients.add(listOfTextAreas.get(i).getText());
            }

            Recipe recipe = new Recipe(newRecipeTitle.getText(), listOfIngredients, guide);
            RecipeList recipeList = new RecipeList();
            recipeList.addRecipe(recipe);
            System.out.println(recipeList.getAllRecipes());
        }
    }
}