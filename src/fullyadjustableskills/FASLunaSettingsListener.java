package fullyadjustableskills;

import lunalib.lunaSettings.LunaSettingsListener;

public class FASLunaSettingsListener implements LunaSettingsListener {
    @Override
    public void settingsChanged(String modId) {
        Utils.loadLunaSettings();
    }
}
