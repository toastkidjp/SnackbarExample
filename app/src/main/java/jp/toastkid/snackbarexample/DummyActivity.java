package jp.toastkid.snackbarexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Dummy activity for using Snackbar on App-Widget.
 *
 * @author toastkidjp
 */
public class DummyActivity extends AppCompatActivity {

    /** Key of Extra. */
    public static final String KEY_COLOR = "color";

    /** Hold for using Snackbar. */
    private View view;

    /** Snackbar's color. */
    private int mColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = makeDummyView();
        setContentView(view);
        overridePendingTransition(0, 0);

        mColor = getIntent().getIntExtra(KEY_COLOR, Color.BLACK);
        setStatusBarTransparent();
        executeFinisher();
    }

    private View makeDummyView() {
        final View view = new View(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return view;
    }

    private void executeFinisher() {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        executorService.shutdown();
    }

    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(mColor);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SnackbarFactory.make(view, mColor).show();
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
