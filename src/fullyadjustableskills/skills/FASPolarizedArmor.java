package fullyadjustableskills.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;

public class FASPolarizedArmor {
    public static float MAX_ARMOR_DAMAGE_REDUCTION_BONUS = 5f;

    public static class Level1 implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            stats.getMaxArmorDamageReduction().modifyFlat(id, MAX_ARMOR_DAMAGE_REDUCTION_BONUS / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getMaxArmorDamageReduction().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Maximum damage reduction by armor increased from 85% to " + Math.round(85f + MAX_ARMOR_DAMAGE_REDUCTION_BONUS) + "%";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }
}
