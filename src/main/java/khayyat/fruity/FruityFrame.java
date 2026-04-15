package khayyat.fruity;

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

        final FruityService service = new FruityServiceFactory().create();
        final Fruit initialFruit = service.getFruit("Strawberry").blockingGet();
        final Nutritions initialNutritions = initialFruit.nutritions();

        final JTextField searchField = new JTextField(initialFruit.name());
        final JButton searchButton = new JButton("Search");

        final JLabel picLabel = new JLabel();
        picLabel.setBackground(Color.BLUE);
        picLabel.setOpaque(true);

        final JLabel familyLabel = new JLabel("Family");
        final JLabel familyValueLabel = new JLabel(initialFruit.family());
        final JLabel orderLabel = new JLabel("Order");
        final JLabel orderValueLabel = new JLabel(initialFruit.order());
        final JLabel genusLabel = new JLabel("Genus");
        final JLabel genusValueLabel = new JLabel(initialFruit.genus());
        final JLabel caloriesLabel = new JLabel("Calories");
        final JLabel caloriesValueLabel = new JLabel(String.valueOf(initialNutritions.calories()));
        final JLabel fatLabel = new JLabel("Fat");
        final JLabel fatValueLabel = new JLabel(String.valueOf(initialNutritions.fat()));
        final JLabel sugarLabel = new JLabel("Sugar");
        final JLabel sugarValueLabel = new JLabel(String.valueOf(initialNutritions.sugar()));
        final JLabel carbsLabel = new JLabel("Carbohydrates");
        final JLabel carbsValueLabel = new JLabel(String.valueOf(initialNutritions.carbohydrates()));
        final JLabel proteinLabel = new JLabel("Protein");
        final JLabel proteinValueLabel = new JLabel(String.valueOf(initialNutritions.protein()));

        final FruityController controller = new FruityController(
                service, searchField, picLabel, familyValueLabel, orderValueLabel, genusValueLabel,
                caloriesValueLabel, fatValueLabel, sugarValueLabel, carbsValueLabel, proteinValueLabel);

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

        controller.doSearch();
    }

    public static void main(String[] args)
    {
        FruityFrame frame = new FruityFrame();
        frame.setVisible(true);
    }
}
