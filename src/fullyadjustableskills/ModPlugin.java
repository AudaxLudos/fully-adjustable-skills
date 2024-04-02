package fullyadjustableskills;

import com.fs.starfarer.api.BaseModPlugin;
import lunalib.lunaSettings.LunaSettings;

public class ModPlugin extends BaseModPlugin {
    @Override
    public void onApplicationLoad() {
        Utils.loadLunaSettings();
        LunaSettings.addSettingsListener(new FASLunaSettingsListener());
    }
}
