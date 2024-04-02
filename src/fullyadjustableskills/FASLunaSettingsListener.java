package fullyadjustableskills;

import com.fs.starfarer.api.impl.campaign.skills.*;
import fullyadjustableskills.skills.*;
import lunalib.lunaSettings.LunaSettings;
import lunalib.lunaSettings.LunaSettingsListener;

public class FASLunaSettingsListener implements LunaSettingsListener {
    @Override
    public void settingsChanged(String modId) {
        Utils.loadSkillsStats();
    }
}
