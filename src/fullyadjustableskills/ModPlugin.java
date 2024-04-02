package fullyadjustableskills;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import lunalib.lunaSettings.LunaSettings;

public class ModPlugin extends BaseModPlugin {
    @Override
    public void onApplicationLoad() {
        Utils.loadSkillsStats();
        LunaSettings.addSettingsListener(new FASLunaSettingsListener());
    }
}
