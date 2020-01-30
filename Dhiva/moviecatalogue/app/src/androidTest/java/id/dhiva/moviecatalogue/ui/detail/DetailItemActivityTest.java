package id.dhiva.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.Intent;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import id.dhiva.moviecatalogue.R;
import id.dhiva.moviecatalogue.utils.DataDummy;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class DetailItemActivityTest {
    private DataDummy dataDummy = new DataDummy();
    @Rule
    public ActivityTestRule<DetailItemActivity> activityRule = new ActivityTestRule<DetailItemActivity>(DetailItemActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailItemActivity.class);
            result.putExtra(DetailItemActivity.EXTRA_POSITION, 0);
            result.putExtra(DetailItemActivity.EXTRA_FROM,DetailItemActivity.VAL_MOVIE);
            return result;
        }
    };

    @Test
    public void loadDetail() {
        onView(withId(R.id.bg_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.poster_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.title)).check(matches(withText(dataDummy.data().getTitle())));
        onView(withId(R.id.date)).check(matches(isDisplayed()));
        onView(withId(R.id.date)).check(matches(withText(dataDummy.data().getDate())));
        onView(withId(R.id.rating)).check(matches(isDisplayed()));
        onView(withId(R.id.rating)).check(matches(withText(dataDummy.data().getRating())));
        onView(withId(R.id.genre)).check(matches(isDisplayed()));
        onView(withId(R.id.genre)).check(matches(withText(dataDummy.data().getGenre())));
        onView(withId(R.id.desc)).check(matches(isDisplayed()));
        onView(withId(R.id.desc)).check(matches(withText(dataDummy.data().getDesc())));
    }


}