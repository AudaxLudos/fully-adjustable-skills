package fullyadjustableskills.skills;

import com.fs.starfarer.api.characters.FleetStatsSkillEffect;
import com.fs.starfarer.api.fleet.MutableFleetStatsAPI;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class FASTacticalDrills {
    public static float CASUALTIES_MULT = 0.25f;

    public static class Level3 implements FleetStatsSkillEffect {
        public void apply(MutableFleetStatsAPI stats, String id, float level) {
            stats.getDynamic().getStat(Stats.PLANETARY_OPERATIONS_CASUALTIES_MULT).modifyMult(id, 1f - CASUALTIES_MULT, "Tactical drills");
        }

        public void unapply(MutableFleetStatsAPI stats, String id) {
            stats.getDynamic().getStat(Stats.PLANETARY_OPERATIONS_CASUALTIES_MULT).unmodifyMult(id);
        }

        public String getEffectDescription(float level) {
            return "-" + Math.round(CASUALTIES_MULT * 100f) + "% marine casualties suffered during ground operations such as raids";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.FLEET;
        }
    }
}
