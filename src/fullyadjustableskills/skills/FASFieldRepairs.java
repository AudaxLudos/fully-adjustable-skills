package fullyadjustableskills.skills;

import com.fs.starfarer.api.campaign.FleetDataAPI;
import com.fs.starfarer.api.characters.*;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.fleet.MutableFleetStatsAPI;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.ui.TooltipMakerAPI;

public class FASFieldRepairs {
    public static float MIN_HULL = 30f;
    public static float MAX_HULL = 40f;
    public static float MIN_CR = 30f;
    public static float MAX_CR = 40f;
    public static float REPAIR_RATE_BONUS = 50f;
    public static float INSTA_REPAIR_PERCENT = 25f;


    public static class Level5A implements FleetStatsSkillEffect {
        public void apply(MutableFleetStatsAPI stats, String id, float level) {
            stats.getDynamic().getMod(Stats.RECOVERED_HULL_MIN).modifyFlat(id, MIN_HULL * 0.01f);
            stats.getDynamic().getMod(Stats.RECOVERED_HULL_MAX).modifyFlat(id, MAX_HULL * 0.01f);
        }

        public void unapply(MutableFleetStatsAPI stats, String id) {
            stats.getDynamic().getMod(Stats.RECOVERED_HULL_MIN).unmodify(id);
            stats.getDynamic().getMod(Stats.RECOVERED_HULL_MAX).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Recovered ships start with " + (int) MIN_HULL + "-" + (int) MAX_HULL + "% hull integrity";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.FLEET;
        }
    }

    public static class Level5B implements FleetStatsSkillEffect {
        public void apply(MutableFleetStatsAPI stats, String id, float level) {
            stats.getDynamic().getMod(Stats.RECOVERED_CR_MIN).modifyFlat(id, MIN_CR * 0.01f);
            stats.getDynamic().getMod(Stats.RECOVERED_CR_MAX).modifyFlat(id, MAX_CR * 0.01f);
        }

        public void unapply(MutableFleetStatsAPI stats, String id) {
            stats.getDynamic().getMod(Stats.RECOVERED_CR_MIN).unmodify(id);
            stats.getDynamic().getMod(Stats.RECOVERED_CR_MAX).unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "Recovered ships start with " + (int) MIN_CR + "-" + (int) MAX_CR + "% combat readiness";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.FLEET;
        }
    }

    public static class Level1 extends BaseSkillEffectDescription implements CharacterStatsSkillEffect, FleetTotalSource {
        public FleetTotalItem getFleetTotalItem() {
            return getOPTotal();
        }

        public void apply(MutableCharacterStatsAPI stats, String id, float level) {
            FleetDataAPI data = null;
            if (stats != null && stats.getFleet() != null) {
                data = stats.getFleet().getFleetData();
            }
            float repBonus = computeAndCacheThresholdBonus(data, stats, "fr_repRate", REPAIR_RATE_BONUS, ThresholdBonusType.OP_ALL);
            if (stats != null) {
                stats.getRepairRateMult().modifyPercent(id, repBonus);
            }
        }

        public void unapply(MutableCharacterStatsAPI stats, String id) {
            stats.getRepairRateMult().unmodify(id);
        }

        public void createCustomDescription(MutableCharacterStatsAPI stats, SkillSpecAPI skill, TooltipMakerAPI info, float width) {
            init(stats, skill);

            FleetDataAPI data = null;
            if (stats != null && stats.getFleet() != null) {
                data = stats.getFleet().getFleetData();
            }
            float damBonus = computeAndCacheThresholdBonus(data, stats, "fr_repRate", REPAIR_RATE_BONUS, ThresholdBonusType.OP_ALL);

            info.addPara("+%s ship repair rate outside of combat (maximum: %s)", 0f, hc, hc,
                    (int) damBonus + "%",
                    (int) REPAIR_RATE_BONUS + "%");
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }

    public static class Level2 extends BaseSkillEffectDescription implements ShipSkillEffect, FleetTotalSource {

        public FleetTotalItem getFleetTotalItem() {
            return getOPTotal();
        }

        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            float instaRep = computeAndCacheThresholdBonus(stats, "fr_instaRep", INSTA_REPAIR_PERCENT, ThresholdBonusType.OP_ALL);
            stats.getDynamic().getMod(Stats.INSTA_REPAIR_FRACTION).modifyFlat(id, instaRep * 0.01f);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDynamic().getMod(Stats.INSTA_REPAIR_FRACTION).unmodifyFlat(id);
        }

        public void createCustomDescription(MutableCharacterStatsAPI stats, SkillSpecAPI skill,
                                            TooltipMakerAPI info, float width) {
            init(stats, skill);

            FleetDataAPI data = getFleetData(null);
            float instaRep = computeAndCacheThresholdBonus(data, stats, "fr_instaRep", INSTA_REPAIR_PERCENT, ThresholdBonusType.OP_ALL);

            info.addPara("%s of hull and armor damage taken repaired after combat ends, at no cost (maximum: %s)", 0f, hc, hc,
                    (int) instaRep + "%",
                    (int) INSTA_REPAIR_PERCENT + "%");
            addOPThresholdAll(info, data, stats, OP_ALL_THRESHOLD);

            info.addSpacer(5f);
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.ALL_SHIPS;
        }
    }
}
