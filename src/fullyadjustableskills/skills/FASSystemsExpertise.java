package fullyadjustableskills.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.impl.campaign.skills.SystemsExpertise;

public class FASSystemsExpertise {
    public static class Level1 implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            stats.getSystemUsesBonus().modifyFlat(id, SystemsExpertise.BONUS_CHARGES);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getSystemUsesBonus().unmodifyPercent(id);
        }

        public String getEffectDescription(float level) {
            String chargeOrCharges = SystemsExpertise.BONUS_CHARGES <= 1f ? " charge" : " charges";
            return "If the ship's system has charges: +" + Math.round(SystemsExpertise.BONUS_CHARGES) + chargeOrCharges;
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }
}
