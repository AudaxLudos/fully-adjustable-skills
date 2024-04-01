package fullyadjustableskills;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.impl.campaign.skills.Helmsmanship;
import com.fs.starfarer.api.impl.campaign.skills.SystemsExpertise;
import lunalib.lunaSettings.LunaSettings;

public class ModPlugin extends BaseModPlugin {
    @Override
    public void onApplicationLoad() {
        LunaSettings.addSettingsListener(new FASLunaSettingsListener());
    }
}
