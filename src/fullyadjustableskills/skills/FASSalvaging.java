package fullyadjustableskills.skills;

import com.fs.starfarer.api.characters.FleetStatsSkillEffect;
import com.fs.starfarer.api.fleet.MutableFleetStatsAPI;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class FASSalvaging {
    public static float COMBAT_SALVAGE = 20f;

    public static class Level3 implements FleetStatsSkillEffect {
        public void apply(MutableFleetStatsAPI stats, String id, float level) {
            stats.getDynamic().getStat(Stats.BATTLE_SALVAGE_MULT_FLEET).modifyFlat(id, COMBAT_SALVAGE * 0.01f);
        }

        public void unapply(MutableFleetStatsAPI stats, String id) {
            stats.getDynamic().getStat(Stats.BATTLE_SALVAGE_MULT_FLEET).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int) COMBAT_SALVAGE + "% post-battle salvage";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.FLEET;
        }
    }
}
