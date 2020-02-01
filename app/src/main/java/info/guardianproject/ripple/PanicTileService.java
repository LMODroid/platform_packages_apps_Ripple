package info.guardianproject.ripple;

import android.content.Intent;
import android.service.quicksettings.TileService;

public class PanicTileService extends TileService {
	public static final String TAG = "PanicTileService";

	@Override
	public void onClick () {
		super.onClick();

		Intent intent = new Intent(this, CountDownActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivityAndCollapse(intent);
	}
}