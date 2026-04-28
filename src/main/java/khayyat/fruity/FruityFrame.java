package khayyat.fruity;

import khayyat.fruity.unsplash.UnsplashService;
import khayyat.fruity.unsplash.UnsplashServiceFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FruityFrame extends JFrame
{
    public FruityFrame()
    {
        setSize(1000, 800);
        setTitle("Fruit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        final FruityService fruityService = new FruityServiceFactory().create();
        final UnsplashService unsplashService = new UnsplashServiceFactory().create();

        final String initialFruitName = "Strawberry";
        final JTextField searchField = new JTextField(initialFruitName);
        final JButton searchButton = new JButton("Search");

        final JLabel picLabel = new JLabel();

        final JLabel familyLabel = new JLabel("Family");
        final JLabel familyValueLabel = new JLabel();
        final JLabel orderLabel = new JLabel("Order");
        final JLabel orderValueLabel = new JLabel();
        final JLabel genusLabel = new JLabel("Genus");
        final JLabel genusValueLabel = new JLabel();
        final JLabel caloriesLabel = new JLabel("Calories");
        final JLabel caloriesValueLabel = new JLabel();
        final JLabel fatLabel = new JLabel("Fat");
        final JLabel fatValueLabel = new JLabel();
        final JLabel sugarLabel = new JLabel("Sugar");
        final JLabel sugarValueLabel = new JLabel();
        final JLabel carbsLabel = new JLabel("Carbohydrates");
        final JLabel carbsValueLabel = new JLabel();
        final JLabel proteinLabel = new JLabel("Protein");
        final JLabel proteinValueLabel = new JLabel();

        final FruityController controller = new FruityController(
                fruityService, unsplashService, searchField, picLabel, familyValueLabel, orderValueLabel,
                genusValueLabel, caloriesValueLabel, fatValueLabel, sugarValueLabel, carbsValueLabel,
                proteinValueLabel);

        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.doSearch();
            }
        });

        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        add(searchField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        add(searchButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 8;
        constraints.anchor = GridBagConstraints.NORTH;
        add(picLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        add(familyLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        add(familyValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        add(orderLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.NORTH;
        add(orderValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.NORTH;
        add(genusLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.NORTH;
        add(genusValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.NORTH;
        add(caloriesLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.NORTH;
        add(caloriesValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.NORTH;
        add(fatLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.NORTH;
        add(fatValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.NORTH;
        add(sugarLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.NORTH;
        add(sugarValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.NORTH;
        add(carbsLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.NORTH;
        add(carbsValueLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.NORTH;
        add(proteinLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.NORTH;
        add(proteinValueLabel, constraints);

        controller.doSearch(); //Populate labels with initial values
    }

    public static void main(String[] args)
    {
        FruityFrame frame = new FruityFrame();
        frame.setVisible(true);
    }
}
