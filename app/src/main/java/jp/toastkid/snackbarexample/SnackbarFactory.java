package jp.toastkid.snackbarexample;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * @author toastkidjp
 */
class SnackbarFactory {

    /**
     * Make Snackbar object with specified color.
     * @param v
     * @param color
     * @return
     */
    static Snackbar make(final View v, final int color) {
        final Snackbar snackbar
                = Snackbar.make(v, "ここにテキストが入ります。", Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(color);
        snackbar.setAction("Next!", new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(v.getContext(), "Why?", Toast.LENGTH_SHORT).show();
            }
        });
        return snackbar;
    }
}
