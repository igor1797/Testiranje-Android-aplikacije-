package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pages.base.BasePage;


public class WatchedMovieDetailsPage extends BasePage {

    public WatchedMovieDetailsPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "tvViewDataTitle")
    public AndroidElement textViewMovieTitle;

    @AndroidFindBy(id = "tvViewDataGenre")
    public AndroidElement textViewMovieGenre;

    @AndroidFindBy(id = "tvViewDataRevision")
    public AndroidElement textViewMovieRevision;

    @AndroidFindBy(id = "rbViewDataGrade")
    public AndroidElement ratingBarMovieGrade;

    @AndroidFindBy(id = "btnDelete")
    public AndroidElement buttonDeleteMovie;

    private void isTitleCorrect(String title){
        Assert.assertEquals(textViewMovieTitle.getText(),title);
    }

    private void isGenreGood(String genre){
        Assert.assertEquals(textViewMovieGenre.getText(),genre);
    }

    private void isRevisionGood(String revision){
        Assert.assertEquals(textViewMovieRevision.getText(),revision);
    }

    private void isGradeGood(String grade){
        Assert.assertEquals(ratingBarMovieGrade.getText(), grade);
    }

    public void areAllDetailsOfMovieGood(String title, String genre, String revision, String grade){
        isTitleCorrect(title);
        isGenreGood(genre);
        isRevisionGood(revision);
        isGradeGood(grade);
    }

    public void clickDeleteMovie(){
        buttonDeleteMovie.click();
    }
}
