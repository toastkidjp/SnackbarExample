package jp.toastkid.snackbarexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author toastkidjp
 */
public class DummyActivity extends AppCompatActivity {

    public static final String KEY_COLOR = "color";
    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new View(this);
        setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final int color = getIntent().getIntExtra(KEY_COLOR, Color.BLACK);
        SnackbarFactory.make(view, color).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public static Intent makeIntent(final Context context, final int color) {
        final Intent intent = new Intent(context, DummyActivity.class);
        intent.putExtra(KEY_COLOR, color);
        return intent;
    }
}
