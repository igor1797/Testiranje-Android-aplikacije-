package tests;

import constants.MovieConstants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import setup.BaseSetup;

public class AddingMovieTest extends BaseSetup {

    public WatchedMoviesPage watchedMoviesPage;
    public AddWatchedMoviesPage addWatchedMoviesPage;

    @BeforeClass
    private void setupPages(){
        watchedMoviesPage = new WatchedMoviesPage(super.getDriver());
        addWatchedMoviesPage = new AddWatchedMoviesPage(super.getDriver());
    }

    private void isErrorMessageDisplayed(boolean errorMessageDisplayed){
        if(errorMessageDisplayed)
            return;
    }

    @Test(priority = 1)
    public void EmptyMovieTitleTest(){
        if(!watchedMoviesPage.isRecyclerViewDisplayed()){
            return;
        }

        watchedMoviesPage.clickAddWatchedMovie();

        addWatchedMoviesPage.saveMovie("", MovieConstants.FIRST_MOVIE_GENRE, MovieConstants.FIRST_MOVIE_REVISION,MovieConstants.FIRST_MOVIE_GRADE);

        isErrorMessageDisplayed(!addWatchedMoviesPage.isErrorMessageTitleCantBeEmptyDisplayed());

        addWatchedMoviesPage.clearAll();
    }

    @Test(priority = 2)
    public void EmptyMovieGenreTest(){
        addWatchedMoviesPage.saveMovie(MovieConstants.FIRST_MOVIE_TITLE, "", MovieConstants.FIRST_MOVIE_REVISION,MovieConstants.FIRST_MOVIE_GRADE);

        isErrorMessageDisplayed(!addWatchedMoviesPage.isErrorMessageGenreCantBeEmptyDisplayed());

        addWatchedMoviesPage.clearAll();
    }

    @Test(priority = 3)
    public void EmptyMovieRevisionTest(){

        addWatchedMoviesPage.saveMovie(MovieConstants.FIRST_MOVIE_TITLE, MovieConstants.FIRST_MOVIE_GENRE, "",MovieConstants.FIRST_MOVIE_GRADE);

        isErrorMessageDisplayed(!addWatchedMoviesPage.isErrorMessageRevisionCantBeEmptyDisplayed());

        addWatchedMoviesPage.clearAll();
    }

    @Test(priority = 4)
    public void SaveMovieTest(){

        addWatchedMoviesPage.saveMovie(MovieConstants.FIRST_MOVIE_TITLE,MovieConstants.FIRST_MOVIE_GENRE,MovieConstants.FIRST_MOVIE_REVISION,MovieConstants.FIRST_MOVIE_GRADE);

        if(!watchedMoviesPage.isFirstMovieDisplayed()){
            return;
        }
    }
}