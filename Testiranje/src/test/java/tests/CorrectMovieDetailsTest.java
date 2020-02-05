package tests;

import constants.MovieConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddWatchedMoviesPage;
import pages.WatchedMovieDetailsPage;
import pages.WatchedMoviesPage;
import setup.BaseSetup;

public class CorrectMovieDetailsTest extends BaseSetup {

    public AndroidDriver<AndroidElement> driver;
    public AddWatchedMoviesPage addWatchedMoviesPage;
    public WatchedMoviesPage watchedMoviesPage;
    public WatchedMovieDetailsPage watchedMovieDetailsPage;

    @BeforeClass
    private void setupPagesAndDriver(){
        driver = super.getDriver();
        addWatchedMoviesPage = new AddWatchedMoviesPage(driver);
        watchedMoviesPage = new WatchedMoviesPage(driver);
        watchedMovieDetailsPage = new WatchedMovieDetailsPage(driver);
    }

    private void isRecyclerViewDisplayed(){
        if(!watchedMoviesPage.isRecyclerViewDisplayed()){
            return;
        }
    }

    private void isFirstMovieDisplayed(){
        if(!watchedMoviesPage.isFirstMovieDisplayed())
            return;
    }

    private void isSecondMovieDisplayed(){
        if(!watchedMoviesPage.isSecondMovieDisplayed())
            return;
    }

    //We first add two movies so we can check the details of the movie
    @Test(priority = 1)
    public void SaveTwoMoviesTest(){
        isRecyclerViewDisplayed();

        watchedMoviesPage.clickAddWatchedMovie();

        addWatchedMoviesPage.saveMovie(
                MovieConstants.FIRST_MOVIE_TITLE,
                MovieConstants.FIRST_MOVIE_GENRE,
                MovieConstants.FIRST_MOVIE_REVISION,
                MovieConstants.FIRST_MOVIE_GRADE
        );

        isFirstMovieDisplayed();

        watchedMoviesPage.clickAddWatchedMovie();

        addWatchedMoviesPage.saveMovie(
                MovieConstants.SECOND_MOVIE_TITLE,
                MovieConstants.SECOND_MOVIE_GENRE,
                MovieConstants.SECOND_MOVIE_REVISION,
                MovieConstants.SECOND_MOVIE_GRADE
        );

        isSecondMovieDisplayed();
    }

    @Test(priority = 2)
    public void AreDetailsOfMovieGoodTest(){
        isRecyclerViewDisplayed();

        watchedMoviesPage.clickOnFirstMovie();

        watchedMovieDetailsPage.areAllDetailsOfMovieGood(
                MovieConstants.FIRST_MOVIE_TITLE,MovieConstants.FIRST_MOVIE_GENRE,MovieConstants.FIRST_MOVIE_REVISION,MovieConstants.FIRST_MOVIE_GRADE
        );
    }

    @Test(priority = 3)
    public void DeleteMovieTest(){
        watchedMovieDetailsPage.clickDeleteMovie();

        isRecyclerViewDisplayed();
    }
}
