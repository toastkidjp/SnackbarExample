package jp.toastkid.snackbarexample.appwidget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

import jp.toastkid.snackbarexample.DummyActivity;
import jp.toastkid.snackbarexample.R;

/**
 * App Widget's RemoteViews factory.
 *
 * @author toastkidjp
 */
class RemoteViewsFactory {

    /**
     * Make RemoteViews.
     * @param context
     * @return RemoteViews
     */
    @NonNull
    static RemoteViews make(final Context context) {
        final RemoteViews remoteViews
                = new RemoteViews(context.getPackageName(), R.layout.appwidget);
        remoteViews.setOnClickPendingIntent(R.id.green, makeIntent(context, Color.GREEN));
        remoteViews.setOnClickPendingIntent(R.id.white, makeIntent(context, Color.WHITE));
        remoteViews.setOnClickPendingIntent(R.id.red,   makeIntent(context, Color.RED));
        remoteViews.setOnClickPendingIntent(R.id.black, makeIntent(context, Color.BLACK));
        remoteViews.setOnClickPendingIntent(R.id.clear_blue, makeIntent(context, Color.argb(128, 0, 16, 128)));
        return remoteViews;
    }

    /**
     * Make launch search intent.
     * @param context
     * @return
     */
    static PendingIntent makeIntent(final Context context, final int color) {
        final Intent intent = DummyActivity.makeIntent(context, color);
        return PendingIntent.getActivity(context, color, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
