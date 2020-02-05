package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class WatchedMoviesPage extends BasePage {

    public WatchedMoviesPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "circle_button_plus")
    public AndroidElement addMovieButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")
    public AndroidElement firstMovie;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")
    public AndroidElement secondMovie;

    @AndroidFindBy(id = "recyclerView")
    public AndroidElement recyclerView;

    public void clickAddWatchedMovie(){
        addMovieButton.click();
    }

    public void clickOnFirstMovie(){
        firstMovie.click();
    }

    public boolean isFirstMovieDisplayed(){
        return firstMovie.isDisplayed();
    }

    public void clickOnSecondMovie(){
        firstMovie.click();
    }

    public boolean isSecondMovieDisplayed(){
        return firstMovie.isDisplayed();
    }

    public boolean isRecyclerViewDisplayed(){
        return recyclerView.isDisplayed();
    }
}
