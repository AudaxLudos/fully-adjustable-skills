package fullyadjustableskills.skills;

import com.fs.starfarer.api.characters.CharacterStatsSkillEffect;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import exerelin.utilities.StringHelper;
import fullyadjustableskills.Utils;

public class FASNexSkills {
    public static int BONUS_AGENTS = 1;

    public static class AgentBonus implements CharacterStatsSkillEffect {
        public void apply(MutableCharacterStatsAPI stats, String id, float level) {
            if (Utils.hasNex)
                stats.getDynamic().getStat("nex_max_agents").modifyFlat(id, BONUS_AGENTS);
        }

        public void unapply(MutableCharacterStatsAPI stats, String id) {
            if (Utils.hasNex)
                stats.getDynamic().getStat("nex_max_agents").unmodify(id);
        }

        public String getEffectDescription(float level) {
            if (Utils.hasNex)
                return "+" + BONUS_AGENTS + " " + StringHelper.getString("nex_agents", "skillBonusAgents");
            return "";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.NONE;
        }
    }
}
