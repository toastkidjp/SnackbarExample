package jp.toastkid.snackbarexample;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * @author toastkidjp
 */
public class SnackbarFactory {

    public static Snackbar make(final View v, final int color) {
        final Snackbar snackbar
                = Snackbar.make(v, "ここにテキストが入ります。", Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(color);
        snackbar.setAction("再表示", new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                snackbar.show();
            }
        });
        return snackbar;
    }
}
