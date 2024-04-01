package fullyadjustableskills;

import com.fs.starfarer.api.impl.campaign.skills.*;
import lunalib.lunaSettings.LunaSettings;
import lunalib.lunaSettings.LunaSettingsListener;

public class FASLunaSettingsListener implements LunaSettingsListener {
    @Override
    public void settingsChanged(String modId) {
        // Helmsmanship skill
        Helmsmanship.MANEUVERABILITY_BONUS = getSettingsFloat(modId, "helmsmanship_stat1");
        Helmsmanship.SPEED_BONUS = getSettingsFloat(modId, "helmsmanship_stat2");
        Helmsmanship.ELITE_SPEED_BONUS_FLAT = getSettingsFloat(modId, "helmsmanship_stat3");

        // Combat Endurance skill
        CombatEndurance.PEAK_TIME_BONUS = getSettingsFloat(modId, "combat_endurance_stat1");
        CombatEndurance.DEGRADE_REDUCTION_PERCENT = getSettingsFloat(modId, "combat_endurance_stat2");
        CombatEndurance.MAX_CR_BONUS = getSettingsFloat(modId, "combat_endurance_stat3");
        CombatEndurance.REGEN_RATE = getSettingsFloat(modId, "combat_endurance_stat4") / 100f;
        CombatEndurance.TOTAL_REGEN_MAX_POINTS = getSettingsFloat(modId, "combat_endurance_stat5");
        CombatEndurance.TOTAL_REGEN_MAX_HULL_FRACTION = getSettingsFloat(modId, "combat_endurance_stat6");

        // Impact Mitigation skill
        ImpactMitigation.ARMOR_DAMAGE_REDUCTION = getSettingsFloat(modId, "impact_mitigation_stat1");
        ImpactMitigation.DAMAGE_TO_MODULES_REDUCTION = getSettingsFloat(modId, "impact_mitigation_stat2");
        ImpactMitigation.MANEUVERABILITY_BONUS_LARGE = getSettingsFloat(modId, "impact_mitigation_stat3");
        ImpactMitigation.MANEUVERABILITY_BONUS_SMALL = getSettingsFloat(modId, "impact_mitigation_stat4");

        // Damage Control skill
        DamageControl.HULL_DAMAGE_REDUCTION = getSettingsFloat(modId, "damage_control_stat1");
        DamageControl.CREW_LOSS_REDUCTION = getSettingsFloat(modId, "damage_control_stat2");
        DamageControl.MODULE_REPAIR_BONUS = getSettingsFloat(modId, "damage_control_stat3");

        // Shield Modulation skill
        FieldModulation.SHIELD_DAMAGE_REDUCTION = getSettingsFloat(modId, "field_modulation_stat1");
        FieldModulation.PHASE_FLUX_UPKEEP_REDUCTION = getSettingsFloat(modId, "field_modulation_stat2");
        FieldModulation.FLUX_SHUNT_DISSIPATION = getSettingsFloat(modId, "field_modulation_stat3");
        FieldModulation.PHASE_COOLDOWN_REDUCTION = getSettingsFloat(modId, "field_modulation_stat4");
        FieldModulation.OVERLOAD_REDUCTION = getSettingsFloat(modId, "field_modulation_stat5");

        // Point Defense skill
        PointDefense.FIGHTER_DAMAGE_BONUS = getSettingsFloat(modId, "point_defense_stat1");
        PointDefense.MISSILE_DAMAGE_BONUS = getSettingsFloat(modId, "point_defense_stat2");
        PointDefense.PD_RANGE_BONUS_FLAT = getSettingsFloat(modId, "point_defense_stat3");

        // Target Analysis skill
        TargetAnalysis.DAMAGE_TO_CRUISERS = getSettingsFloat(modId, "target_analysis_stat1");
        TargetAnalysis.DAMAGE_TO_CAPITALS = getSettingsFloat(modId, "target_analysis_stat2");
        TargetAnalysis.DAMAGE_TO_FRIGATES = getSettingsFloat(modId, "target_analysis_stat3");
        TargetAnalysis.DAMAGE_TO_DESTROYERS = getSettingsFloat(modId, "target_analysis_stat4");
        TargetAnalysis.DAMAGE_TO_MODULES_BONUS = getSettingsFloat(modId, "target_analysis_stat5");

        // Ballistic Mastery skill
        BallisticMastery.DAMAGE_BONUS = getSettingsFloat(modId, "ballistic_mastery_stat1");
        BallisticMastery.RANGE_BONUS = getSettingsFloat(modId, "ballistic_mastery_stat2");
        BallisticMastery.DAMAGE_ELITE = getSettingsFloat(modId, "ballistic_mastery_stat3");
        BallisticMastery.PROJ_SPEED_BONUS = getSettingsFloat(modId, "ballistic_mastery_stat4");

        // Systems Expertise skill
        SystemsExpertise.BONUS_CHARGES = getSettingsFloat(modId, "systems_expertise_stat1");
        SystemsExpertise.REGEN_PERCENT = getSettingsFloat(modId, "systems_expertise_stat2");
        SystemsExpertise.RANGE_PERCENT = getSettingsFloat(modId, "systems_expertise_stat3");
        SystemsExpertise.SYSTEM_COOLDOWN_REDUCTION_PERCENT = getSettingsFloat(modId, "systems_expertise_stat4");
        SystemsExpertise.ELITE_DAMAGE_REDUCTION = getSettingsFloat(modId, "systems_expertise_stat5");

        // Missile Specialization skill
        // MissileSpecialization.MISSILE_AMMO_BONUS = getSettingsFloat(modId, "missile_specialization_stat1");
        // MissileSpecialization.MISSILE_SPEC_PERK_HEALTH_BONUS = getSettingsFloat(modId, "missile_specialization_stat2");
        // MissileSpecialization.MISSILE_SPEC_ROF_BONUS = getSettingsFloat(modId, "missile_specialization_stat3");
        // MissileSpecialization.MISSILE_SPEC_AMMO_REGEN_BONUS = getSettingsFloat(modId, "missile_specialization_stat4");
        // MissileSpecialization.MISSILE_SPEC_DAMAGE_BONUS = getSettingsFloat(modId, "missile_specialization_stat5");
    }

    public float getSettingsFloat(String modId, String fieldId) {
        Float val = LunaSettings.getFloat(modId, fieldId);
        if (val == null)
            return 1f;

        return val;
    }
}
