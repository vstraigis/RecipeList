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

    RecipeList recipeList = new RecipeList();

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


    private JFrame mainWindowFrame, guideFrame;
    // TODO: refactor naming. Names should speak for themselves, "f" or similar names should not be present
    // TODO: remove unused code, console.logs
    private Panel menu, recipe, newRecipe, inspiration;
    private JPanel newRecipePanel;
    private JButton myRecipesButton, newRecipeButton, inspirationButton;
    private JButton backButton1, backButton2, backButton3;
    private JButton saveButton, addIngredientButton, removeIngredientButton, viewGuideButton, saveGuideButton;
    private JScrollPane scrollPane, scrollingRecipesPane;
    private String guide;
    private JTextArea guideArea, recipeTextArea, newRecipeTitle;

    CreateButton createButton = new CreateButton();


    public GuiMain() {
        createFrame("Recipe Book", 360, 500);
        createMenu();
    }

    private void createFrame(String title, int width, int height) {
        mainWindowFrame = new JFrame(title);
        mainWindowFrame.setLayout(null);
        mainWindowFrame.setVisible(true);
        mainWindowFrame.setSize(width, height);
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setResizable(false);
        mainWindowFrame.setIconImage(new ImageIcon("Resources/121895.png").getImage());
        mainWindowFrame.getContentPane().setBackground(Color.decode("#D5C7BC"));
    }

    //ViewRecipes frame
    private void createMyRecipesFrame() {
        recipe = new Panel();
        recipeTextArea = new JTextArea();
        scrollingRecipesPane = new JScrollPane(recipeTextArea);

        recipe.setLayout(null);
        recipe.setVisible(true);
        recipe.setBounds(0, 0, 360, 500);

        scrollingRecipesPane.setBounds(25, 70, 250, 300);
        scrollingRecipesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        recipeTextArea.setBounds(25, 70, 250, 300);
        recipeTextArea.setBorder(new LineBorder(Color.BLACK));
        scrollingRecipesPane.getViewport().setBackground(Color.WHITE);
        scrollingRecipesPane.getViewport().add(recipeTextArea);

        recipe.add(scrollingRecipesPane);


        backButton1 = createButton.createSimpleButton("Back");
        recipe.add(backButton1);
        backButton1.setBounds(110, 410, 120, 40);
        backButton1.addActionListener(this);

        JLabel title = new JLabel("My Recipes");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.decode("#785964"));
        recipe.add(title);
        title.setBounds(95, 10, 200, 50);
        for (int i = 1; i <= recipeList.getAllRecipes().size(); i++) {
            recipeTextArea.append(recipeList.getRecipe(i).toString());
        }
    }

    //CreateRecipe frame
    private void createNewRecipe() {
        newRecipe = new Panel();
        newRecipeTitle = new JTextArea("<enter title>");
        newRecipePanel = new JPanel();
        scrollPane = new JScrollPane();

        CreateRecipe cr = new CreateRecipe(newRecipe, newRecipeTitle, newRecipePanel, scrollPane);

        backButton2 = createButton.createSimpleButton("Back");
        backButton2.setBounds(25, 410, 120, 40);
        backButton2.addActionListener(this);
        newRecipe.add(backButton2);

        saveButton = createButton.createSimpleButton("Save");
        saveButton.setBounds(195, 410, 120, 40);
        saveButton.addActionListener(this);
        newRecipe.add(saveButton);

        addIngredientButton = createButton.createSimpleButton("+");
        addIngredientButton.setBounds(265, 75, 30, 30);
        addIngredientButton.addActionListener(this);
        newRecipe.add(addIngredientButton);

        removeIngredientButton = createButton.createSimpleButton("-");
        removeIngredientButton.setBounds(300, 75, 30, 30);
        removeIngredientButton.addActionListener(this);
        newRecipe.add(removeIngredientButton);

        viewGuideButton = createButton.createSimpleButton("Guide");
        viewGuideButton.setBounds(265, 120, 65, 35);
        viewGuideButton.addActionListener(this);
        newRecipe.add(viewGuideButton);
    }

    private void createGuide() {
        guideFrame = new JFrame();
        guideArea = new JTextArea("Explain how to cook here!");

        RecGuide rg = new RecGuide(guideFrame, guideArea);

        saveGuideButton = createButton.createSimpleButton("Save");
        saveGuideButton.setBounds(280, 300, 75, 30);
        saveGuideButton.addActionListener(this);
        guideFrame.add(saveGuideButton);
    }


    private void createMenu() {
        menu = new Panel();
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setBounds(-10, -10, 360, 500);

        ImageIcon background = new ImageIcon("Resources/resize.jpg");
        Image backgroundImage = background.getImage();
        Image newImage = backgroundImage.getScaledInstance(360, 500, java.awt.Image.SCALE_SMOOTH);
        background = new ImageIcon(newImage);
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 360, 500);

        myRecipesButton = createButton.createSimpleButton("My recipes");
        newRecipeButton = createButton.createSimpleButton("New recipe");
        inspirationButton = createButton.createSimpleButton("Inspiration");

        menu.add(myRecipesButton);
        menu.add(newRecipeButton);
        menu.add(inspirationButton);

        myRecipesButton.setBounds(80, 75, 200, 60);
        newRecipeButton.setBounds(80, 170, 200, 60);
        inspirationButton.setBounds(80, 300, 200, 60);

        myRecipesButton.addActionListener(this);
        newRecipeButton.addActionListener(this);
        inspirationButton.addActionListener(this);

        menu.add(backgroundLabel);
        mainWindowFrame.add(menu);
    }

    private void createInsipirationFrame() {
        inspiration = new Panel();
        inspiration.setLayout(null);
        inspiration.setVisible(true);
        inspiration.setBounds(0, 0, 360, 500);
        backButton3 = createButton.createSimpleButton("Back");
        backButton3.setBounds(110, 410, 120, 40);
        inspiration.add(backButton3);
        backButton3.addActionListener(this);

        ImageIcon background = new ImageIcon("Resources/original.jpg");
        Image backgroundImage = background.getImage();
        Image newImg1 = backgroundImage.getScaledInstance(360, 500, java.awt.Image.SCALE_SMOOTH);
        background = new ImageIcon(newImg1);
        JLabel backgroundLabel1 = new JLabel(background);
        backgroundLabel1.setBounds(0, 0, 360, 500);
        inspiration.add(backgroundLabel1);
    }

    private int ingredientCount = 0;
    private List<JLabel> listOfLabels = new ArrayList<JLabel>();
    private List<JTextArea> listOfTextAreas = new ArrayList<JTextArea>();


    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO: refactor this part, too many if statements (map / switch)
        if (e.getSource() == myRecipesButton) {
            mainWindowFrame.remove(menu);
            createMyRecipesFrame();
            mainWindowFrame.add(recipe);
        }
        if (e.getSource() == newRecipeButton) {
            mainWindowFrame.remove(menu);
            createNewRecipe();
            mainWindowFrame.add(newRecipe);

        }
        if (e.getSource() == inspirationButton) {
            mainWindowFrame.remove(menu);
            createInsipirationFrame();
            mainWindowFrame.add(inspiration);
        }

        if (e.getSource() == backButton1) {
            mainWindowFrame.remove(recipe);
            createMenu();
            mainWindowFrame.add(menu);
        }
        if (e.getSource() == backButton2) {
            mainWindowFrame.remove(newRecipe);
            createMenu();
            mainWindowFrame.add(menu);
            for (int i = 0; i < ingredientCount; i++) {
                listOfTextAreas.get(i).setText("");
            }
            listOfLabels.clear();
            ingredientCount = 0;
        }
        if (e.getSource() == backButton3) {
            mainWindowFrame.remove(inspiration);
            createMenu();
            mainWindowFrame.add(menu);
        }
        if (e.getSource() == viewGuideButton) {
            createGuide();
        }
        if (e.getSource() == saveGuideButton) {
            guide = guideArea.getText();
        }
        if (e.getSource() == addIngredientButton) {

            newRecipePanel.removeAll();

            JTextArea ingredient = new JTextArea();
            ingredient.setSize(100, 200);
            listOfTextAreas.add(ingredient);
            System.out.println(ingredientCount);
            listOfLabels.add(new JLabel(ingredientCount + 1 + ": "));

            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            GridBagConstraints labelConstraints = new GridBagConstraints();

            for (int i = 0; i <= ingredientCount; i++) {

                textFieldConstraints.gridx = 1;
                textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                textFieldConstraints.weightx = 0.5;
                textFieldConstraints.insets = new Insets(10, 10, 10, 10);
                textFieldConstraints.gridy = i;

                labelConstraints.gridx = 0;
                labelConstraints.gridy = i;
                labelConstraints.insets = new Insets(10, 10, 10, 10);

                newRecipePanel.add(listOfLabels.get(i), labelConstraints);
                newRecipePanel.add(listOfTextAreas.get(i), textFieldConstraints);
            }

            GridBagConstraints c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = ingredientCount;
            c.weighty = 1;
            newRecipePanel.add(new JLabel(), c);

            newRecipePanel.updateUI();
            ingredientCount++;
        }
        if (e.getSource() == removeIngredientButton) {
            ingredientCount--;
            newRecipePanel.remove(listOfLabels.get(ingredientCount));
            newRecipePanel.remove(listOfTextAreas.get(ingredientCount));
            newRecipePanel.updateUI();
        }
        if (e.getSource() == saveButton) {
            ArrayList<String> listOfIngredients = new ArrayList<String>();
            for (int i = 0; i < ingredientCount; i++) {
                listOfIngredients.add(listOfTextAreas.get(i).getText());
            }

            Recipe recipe = new Recipe(newRecipeTitle.getText(), listOfIngredients, guide);
            recipeList.addRecipe(recipe);
            System.out.println(recipeList.getAllRecipes());
        }
    }
}