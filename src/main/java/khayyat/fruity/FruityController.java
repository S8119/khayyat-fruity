package khayyat.fruity;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FruityController
{
    private final FruityService service;

    private final JTextField searchField;
    private final JLabel picLabel;
    private final JLabel familyValueLabel;
    private final JLabel orderValueLabel;
    private final JLabel genusValueLabel;
    private final JLabel caloriesValueLabel;
    private final JLabel fatValueLabel;
    private final JLabel sugarValueLabel;
    private final JLabel carbsValueLabel;
    private final JLabel proteinValueLabel;

    public FruityController(
            FruityService service, JTextField searchField, JLabel picLabel, JLabel familyValueLabel,
            JLabel orderValueLabel, JLabel genusValueLabel, JLabel caloriesValueLabel, JLabel fatValueLabel,
            JLabel sugarValueLabel, JLabel carbsValueLabel, JLabel proteinValueLabel)
    {
        this.service = service;
        this.searchField = searchField;
        this.picLabel = picLabel;
        this.familyValueLabel = familyValueLabel;
        this.orderValueLabel = orderValueLabel;
        this.genusValueLabel = genusValueLabel;
        this.caloriesValueLabel = caloriesValueLabel;
        this.fatValueLabel = fatValueLabel;
        this.sugarValueLabel = sugarValueLabel;
        this.carbsValueLabel = carbsValueLabel;
        this.proteinValueLabel = proteinValueLabel;
    }

    public void doSearch()
    {
        String fruitName = searchField.getText();
        Disposable disposable = service.getFruit(fruitName)
                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())
                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                    (this::handleResponse),
                    Throwable::printStackTrace);
    }

    private void handleResponse(Fruit fruit)
    {
        picLabel.setBackground(picLabel.getBackground());
        familyValueLabel.setText(fruit.family());
        orderValueLabel.setText(fruit.order());
        genusValueLabel.setText(fruit.genus());
        Nutritions nutritions = fruit.nutritions();
        caloriesValueLabel.setText(String.valueOf(nutritions.calories()));
        fatValueLabel.setText(String.valueOf(nutritions.fat()));
        sugarValueLabel.setText(String.valueOf(nutritions.sugar()));
        carbsValueLabel.setText(String.valueOf(nutritions.carbohydrates()));
        proteinValueLabel.setText(String.valueOf(nutritions.protein()));

        try
        {
            ImageIcon imageIcon = new ImageIcon(new URL("https://picsum.photos/800/600"));
            picLabel.setIcon(imageIcon);
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
}
