package khayyat.fruity;

import com.andrewoid.apikeys.ApiKey;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import khayyat.fruity.unsplash.Photos;
import khayyat.fruity.unsplash.UnsplashService;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FruityController
{
    private final FruityService fruityService;
    private final UnsplashService unsplashService;

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
            FruityService fruityService, UnsplashService unsplashService, JTextField searchField, JLabel picLabel,
            JLabel familyValueLabel, JLabel orderValueLabel, JLabel genusValueLabel, JLabel caloriesValueLabel,
            JLabel fatValueLabel, JLabel sugarValueLabel, JLabel carbsValueLabel, JLabel proteinValueLabel)
    {
        this.fruityService = fruityService;
        this.unsplashService = unsplashService;
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
        Disposable disposableFruit = fruityService.getFruit(fruitName)
                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())
                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                    (this::handleResponseFruit),
                    Throwable::printStackTrace);

        ApiKey apiKey = new ApiKey();
        String keyString = apiKey.get();
        Disposable disposablePhoto = unsplashService.search(keyString,
                fruitName)
                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())
                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                        (this::handleResponsePhotos),
                        Throwable::printStackTrace);
    }

    private void handleResponseFruit(Fruit fruit)
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
    }

    private void handleResponsePhotos(Photos photos)
    {
        try
        {
            ImageIcon imageIcon = new ImageIcon(new URL(photos.results()[0].urls().small()));
            picLabel.setIcon(imageIcon);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
}
