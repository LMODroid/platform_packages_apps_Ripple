package info.guardianproject.ripple;

import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.N)
public class PanicTileService extends TileService {
    public static final String TAG = "PanicTileService";

    @Override
    public void onClick() {
        super.onClick();

        Intent intent = new Intent(this, CountDownActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityAndCollapse(intent);
    }
}
