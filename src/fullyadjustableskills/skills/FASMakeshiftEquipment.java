package fullyadjustableskills.skills;

import com.fs.starfarer.api.characters.FleetStatsSkillEffect;
import com.fs.starfarer.api.fleet.MutableFleetStatsAPI;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class FASMakeshiftEquipment {
    public static float SURVEY_COST_MULT = 0.5f;

    public static class Level1 implements FleetStatsSkillEffect {
        public void apply(MutableFleetStatsAPI stats, String id, float level) {
            String desc = "Surveying skill";
            stats.getDynamic().getStat(Stats.SURVEY_COST_MULT).modifyMult(id, 1f - SURVEY_COST_MULT, desc);
        }

        public void unapply(MutableFleetStatsAPI stats, String id) {
            stats.getDynamic().getStat(Stats.SURVEY_COST_MULT).unmodifyMult(id);
        }

        public String getEffectDescription(float level) {
            return "-" + Math.round(SURVEY_COST_MULT * 100f) + "% resources required to survey planets";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.FLEET;
        }
    }
}
