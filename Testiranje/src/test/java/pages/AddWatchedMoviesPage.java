package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class AddWatchedMoviesPage extends BasePage {

    public AddWatchedMoviesPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "etTitle")
    public AndroidElement editTextMovieTitle;

    @AndroidFindBy(id = "etGenre")
    public AndroidElement editTextMovieGenre;

    @AndroidFindBy(id = "etRevision")
    public AndroidElement editTextMovieRevision;

    @AndroidFindBy(id = "rbGrade")
    public AndroidElement ratingBarMovieGrade;

    @AndroidFindBy(id = "btnSave")
    public AndroidElement buttonSaveMovie;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
    public AndroidElement messageTitleCantBeEmpty;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
    public AndroidElement messageGenreCantBeEmpty;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView")
    public AndroidElement messageRevisionCantBeEmpty;

    public boolean isErrorMessageTitleCantBeEmptyDisplayed(){
        return messageTitleCantBeEmpty.isDisplayed();
    }

    public boolean isErrorMessageGenreCantBeEmptyDisplayed(){
        return messageGenreCantBeEmpty.isDisplayed();
    }

    public boolean isErrorMessageRevisionCantBeEmptyDisplayed(){
        return messageRevisionCantBeEmpty.isDisplayed();
    }

    private void typeMovieTitle(String title){
        editTextMovieTitle.sendKeys(title);
    }

    private void typeMovieGenre(String genre){
        editTextMovieGenre.sendKeys(genre);
    }

    private void typeMovieRevision(String revision){
        editTextMovieRevision.sendKeys(revision);
    }

    private void gradeMovie(String grade){
        ratingBarMovieGrade.sendKeys(grade);
    }

    private void clickButtonSaveMovie(){
        buttonSaveMovie.click();
    }

    public void saveMovie(String title, String genre, String revision, String grade){
        typeMovieTitle(title);
        typeMovieGenre(genre);
        typeMovieRevision(revision);
        gradeMovie(grade);
        clickButtonSaveMovie();
    }

    public void clearAll(){
        typeMovieTitle("");
        typeMovieGenre("");
        typeMovieRevision("");
        gradeMovie("0.0");
    }
}
