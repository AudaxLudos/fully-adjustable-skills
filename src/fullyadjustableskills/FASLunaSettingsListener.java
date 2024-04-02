package fullyadjustableskills;

import com.fs.starfarer.api.impl.campaign.skills.*;
import fullyadjustableskills.skills.*;
import lunalib.lunaSettings.LunaSettings;
import lunalib.lunaSettings.LunaSettingsListener;

public class FASLunaSettingsListener implements LunaSettingsListener {
    @Override
    public void settingsChanged(String modId) {
        // GENERAL MODIFIABLE STATS
        BaseSkillEffectDescription.OP_THRESHOLD = getSettingsFloat(modId, "ordnance_point_threshold");
        BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD = getSettingsFloat(modId, "fighter_bay_threshold");
        BaseSkillEffectDescription.PHASE_OP_THRESHOLD = getSettingsFloat(modId, "phase_ordnance_point_threshold");
        BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD = getSettingsFloat(modId, "automated_points_threshold");

        // COMBAT SKILL TREE
        Helmsmanship.MANEUVERABILITY_BONUS = getSettingsFloat(modId, "helmsmanship_stat1");
        Helmsmanship.SPEED_BONUS = getSettingsFloat(modId, "helmsmanship_stat2");
        Helmsmanship.ELITE_SPEED_BONUS_FLAT = getSettingsFloat(modId, "helmsmanship_stat3");

        CombatEndurance.PEAK_TIME_BONUS = getSettingsFloat(modId, "combat_endurance_stat1");
        CombatEndurance.DEGRADE_REDUCTION_PERCENT = getSettingsFloat(modId, "combat_endurance_stat2");
        CombatEndurance.MAX_CR_BONUS = getSettingsFloat(modId, "combat_endurance_stat3");
        CombatEndurance.REGEN_RATE = getSettingsFloat(modId, "combat_endurance_stat4") / 100f;
        CombatEndurance.TOTAL_REGEN_MAX_POINTS = getSettingsFloat(modId, "combat_endurance_stat5");
        CombatEndurance.TOTAL_REGEN_MAX_HULL_FRACTION = getSettingsFloat(modId, "combat_endurance_stat6");

        ImpactMitigation.ARMOR_DAMAGE_REDUCTION = getSettingsFloat(modId, "impact_mitigation_stat1");
        ImpactMitigation.DAMAGE_TO_MODULES_REDUCTION = getSettingsFloat(modId, "impact_mitigation_stat2");
        ImpactMitigation.MANEUVERABILITY_BONUS_LARGE = getSettingsFloat(modId, "impact_mitigation_stat3");
        ImpactMitigation.MANEUVERABILITY_BONUS_SMALL = getSettingsFloat(modId, "impact_mitigation_stat4");

        DamageControl.HULL_DAMAGE_REDUCTION = getSettingsFloat(modId, "damage_control_stat1");
        DamageControl.CREW_LOSS_REDUCTION = getSettingsFloat(modId, "damage_control_stat2");
        DamageControl.MODULE_REPAIR_BONUS = getSettingsFloat(modId, "damage_control_stat3");

        FieldModulation.SHIELD_DAMAGE_REDUCTION = getSettingsFloat(modId, "field_modulation_stat1");
        FieldModulation.PHASE_FLUX_UPKEEP_REDUCTION = getSettingsFloat(modId, "field_modulation_stat2");
        FieldModulation.FLUX_SHUNT_DISSIPATION = getSettingsFloat(modId, "field_modulation_stat3");
        FieldModulation.PHASE_COOLDOWN_REDUCTION = getSettingsFloat(modId, "field_modulation_stat4");
        FieldModulation.OVERLOAD_REDUCTION = getSettingsFloat(modId, "field_modulation_stat5");

        PointDefense.FIGHTER_DAMAGE_BONUS = getSettingsFloat(modId, "point_defense_stat1");
        PointDefense.MISSILE_DAMAGE_BONUS = getSettingsFloat(modId, "point_defense_stat2");
        PointDefense.PD_RANGE_BONUS_FLAT = getSettingsFloat(modId, "point_defense_stat3");

        TargetAnalysis.DAMAGE_TO_CRUISERS = getSettingsFloat(modId, "target_analysis_stat1");
        TargetAnalysis.DAMAGE_TO_CAPITALS = getSettingsFloat(modId, "target_analysis_stat2");
        TargetAnalysis.DAMAGE_TO_FRIGATES = getSettingsFloat(modId, "target_analysis_stat3");
        TargetAnalysis.DAMAGE_TO_DESTROYERS = getSettingsFloat(modId, "target_analysis_stat4");
        TargetAnalysis.DAMAGE_TO_MODULES_BONUS = getSettingsFloat(modId, "target_analysis_stat5");

        BallisticMastery.DAMAGE_BONUS = getSettingsFloat(modId, "ballistic_mastery_stat1");
        BallisticMastery.RANGE_BONUS = getSettingsFloat(modId, "ballistic_mastery_stat2");
        BallisticMastery.DAMAGE_ELITE = getSettingsFloat(modId, "ballistic_mastery_stat3");
        BallisticMastery.PROJ_SPEED_BONUS = getSettingsFloat(modId, "ballistic_mastery_stat4");

        SystemsExpertise.BONUS_CHARGES = getSettingsFloat(modId, "systems_expertise_stat1");
        SystemsExpertise.REGEN_PERCENT = getSettingsFloat(modId, "systems_expertise_stat2");
        SystemsExpertise.RANGE_PERCENT = getSettingsFloat(modId, "systems_expertise_stat3");
        SystemsExpertise.SYSTEM_COOLDOWN_REDUCTION_PERCENT = getSettingsFloat(modId, "systems_expertise_stat4");
        SystemsExpertise.ELITE_DAMAGE_REDUCTION = getSettingsFloat(modId, "systems_expertise_stat5");

        FASMissileSpecialization.MISSILE_AMMO_BONUS = getSettingsFloat(modId, "missile_specialization_stat1");
        FASMissileSpecialization.MISSILE_SPEC_PERK_HEALTH_BONUS = getSettingsFloat(modId, "missile_specialization_stat2");
        FASMissileSpecialization.MISSILE_SPEC_ROF_BONUS = getSettingsFloat(modId, "missile_specialization_stat3");
        FASMissileSpecialization.MISSILE_SPEC_AMMO_REGEN_BONUS = getSettingsFloat(modId, "missile_specialization_stat4");
        FASMissileSpecialization.MISSILE_SPEC_DAMAGE_BONUS = getSettingsFloat(modId, "missile_specialization_stat5");

        // FLEET SKILL TREE
        TacticalDrills.DAMAGE_PERCENT = getSettingsFloat(modId, "tactical_drills_stat1");
        TacticalDrills.ATTACK_BONUS = getSettingsInt(modId, "tactical_drills_stat2");
        FASTacticalDrills.CASUALTIES_MULT = getSettingsFloat(modId, "tactical_drills_stat3") / 100f;

        CoordinatedManeuvers.NAV_FRIGATES = getSettingsFloat(modId, "coordinated_maneuvers_stat1");
        CoordinatedManeuvers.NAV_DESTROYERS = getSettingsFloat(modId, "coordinated_maneuvers_stat2");
        CoordinatedManeuvers.NAV_OTHER = getSettingsFloat(modId, "coordinated_maneuvers_stat3");
        CoordinatedManeuvers.CP_REGEN_FRIGATES = getSettingsFloat(modId, "coordinated_maneuvers_stat4");
        CoordinatedManeuvers.CP_REGEN_DESTROYERS = getSettingsFloat(modId, "coordinated_maneuvers_stat5");

        WolfpackTactics.DAMAGE_TO_LARGER_BONUS = getSettingsFloat(modId, "wolfpack_tactics_stat1");
        WolfpackTactics.DAMAGE_TO_LARGER_BONUS_DEST = getSettingsFloat(modId, "wolfpack_tactics_stat2");
        WolfpackTactics.PEAK_TIME_BONUS = getSettingsFloat(modId, "wolfpack_tactics_stat3");
        WolfpackTactics.PEAK_TIME_BONUS_DEST = getSettingsFloat(modId, "wolfpack_tactics_stat4");

        CrewTraining.CR_PERCENT = getSettingsFloat(modId, "crew_training_stat1");

        CarrierGroup.REPLACEMENT_RATE_PERCENT = getSettingsFloat(modId, "carrier_group_stat1");
        CarrierGroup.OFFICER_MULT = getSettingsFloat(modId, "carrier_group_stat2");

        FighterUplink.CREW_LOSS_PERCENT = getSettingsFloat(modId, "fighter_uplink_stat1");
        FighterUplink.MAX_SPEED_PERCENT = getSettingsFloat(modId, "fighter_uplink_stat2");
        FighterUplink.TARGET_LEADING_BONUS = getSettingsFloat(modId, "fighter_uplink_stat3");
        FighterUplink.OFFICER_MULT = getSettingsFloat(modId, "fighter_uplink_stat4");

        FASOfficerTraining.MAX_LEVEL_BONUS = getSettingsFloat(modId, "officer_training_stat1");
        FASOfficerTraining.MAX_ELITE_SKILLS_BONUS = getSettingsFloat(modId, "officer_training_stat2");
        FASOfficerTraining.CP_BONUS = getSettingsFloat(modId, "officer_training_stat3");

        OfficerManagement.NUM_OFFICERS_BONUS = getSettingsFloat(modId, "officer_management_stat1");
        OfficerManagement.CP_BONUS = getSettingsFloat(modId, "officer_management_stat2");

        BestOfTheBest.EXTRA_MODS = getSettingsInt(modId, "best_of_the_best_stat1");
        BestOfTheBest.DEPLOYMENT_BONUS = getSettingsFloat(modId, "best_of_the_best_stat2") / 100f;

        SupportDoctrine.DP_REDUCTION = getSettingsFloat(modId, "support_doctrine_stat1") / 100f;
        SupportDoctrine.DP_REDUCTION_MAX = getSettingsFloat(modId, "support_doctrine_stat2");
        SupportDoctrine.COMMAND_POINT_REGEN_PERCENT = getSettingsFloat(modId, "support_doctrine_stat3");

        // TECHNOLOGY SKILL TREE
        Navigation.TERRAIN_PENALTY_REDUCTION = getSettingsFloat(modId, "navigation_stat1");
        Navigation.FLEET_BURN_BONUS = getSettingsFloat(modId, "navigation_stat2");
        Navigation.SB_BURN_BONUS = getSettingsFloat(modId, "navigation_stat3");

        Sensors.DETECTED_BONUS = getSettingsFloat(modId, "sensors_stat1");
        Sensors.SENSOR_BONUS = getSettingsFloat(modId, "sensors_stat2");
        Sensors.SLOW_BURN_BONUS = getSettingsFloat(modId, "sensors_stat3");

        GunneryImplants.TARGET_LEADING_BONUS = getSettingsFloat(modId, "gunnery_implants_stat1");
        GunneryImplants.RANGE_BONUS = getSettingsFloat(modId, "gunnery_implants_stat2");
        GunneryImplants.RECOIL_BONUS = getSettingsFloat(modId, "gunnery_implants_stat3");
        GunneryImplants.EW_FRIGATES = getSettingsFloat(modId, "gunnery_implants_stat4");
        GunneryImplants.EW_DESTROYERS = getSettingsFloat(modId, "gunnery_implants_stat5");
        GunneryImplants.EW_OTHER = getSettingsFloat(modId, "gunnery_implants_stat6");

        EnergyWeaponMastery.ENERGY_DAMAGE_PERCENT = getSettingsFloat(modId, "energy_weapon_mastery_stat1");
        EnergyWeaponMastery.MIN_RANGE = getSettingsFloat(modId, "energy_weapon_mastery_stat2");
        EnergyWeaponMastery.MAX_RANGE = getSettingsFloat(modId, "energy_weapon_mastery_stat3");
        FASEnergyWeaponMastery.FLUX_COST_MULT = getSettingsFloat(modId, "energy_weapon_mastery_stat4") / 100f;

        ElectronicWarfare.PER_SHIP_BONUS = getSettingsFloat(modId, "electronic_warfare_stat1");

        FluxRegulation.CAPACITORS_BONUS = getSettingsInt(modId, "flux_regulation_stat1");
        FluxRegulation.VENTS_BONUS = getSettingsInt(modId, "flux_regulation_stat2");
        FluxRegulation.DISSIPATION_PERCENT = getSettingsFloat(modId, "flux_regulation_stat3");
        FluxRegulation.CAPACITY_PERCENT = getSettingsFloat(modId, "flux_regulation_stat4");

        PhaseCorps.PEAK_TIME_BONUS = getSettingsFloat(modId, "phase_coil_tuning_stat1");
        PhaseCorps.PHASE_SPEED_BONUS = getSettingsFloat(modId, "phase_coil_tuning_stat2");
        PhaseCorps.PHASE_SHIP_SENSOR_BONUS_PERCENT = getSettingsFloat(modId, "phase_coil_tuning_stat3");

        // Neural Link - No Modifiable Stat

        CyberneticAugmentation.MAX_ELITE_SKILLS_BONUS = getSettingsFloat(modId, "cybernetic_augmentation_stat1");
        CyberneticAugmentation.BONUS_PER_ELITE_SKILL = getSettingsFloat(modId, "cybernetic_augmentation_stat2");

        AutomatedShips.MAX_CR_BONUS = getSettingsFloat(modId, "automated_ships_stat1");

        // INDUSTRY SKILL TREE
        BulkTransport.CARGO_CAPACITY_MAX_PERCENT = getSettingsFloat(modId, "bulk_transport_stat1");
        BulkTransport.CARGO_CAPACITY_THRESHOLD = getSettingsFloat(modId, "bulk_transport_stat2");
        BulkTransport.FUEL_CAPACITY_MAX_PERCENT = getSettingsFloat(modId, "bulk_transport_stat3");
        BulkTransport.FUEL_CAPACITY_THRESHOLD = getSettingsFloat(modId, "bulk_transport_stat4");
        BulkTransport.PERSONNEL_CAPACITY_MAX_PERCENT = getSettingsFloat(modId, "bulk_transport_stat5");
        BulkTransport.PERSONNEL_CAPACITY_THRESHOLD = getSettingsFloat(modId, "bulk_transport_stat6");
        BulkTransport.BURN_BONUS = getSettingsFloat(modId, "bulk_transport_stat7");

        Salvaging.SALVAGE_BONUS = getSettingsFloat(modId, "salvaging_stat1");
        FASSalvaging.COMBAT_SALVAGE = getSettingsFloat(modId, "salvaging_stat2");
        Salvaging.CREW_LOSS_REDUCTION = getSettingsFloat(modId, "salvaging_stat3");

        FASFieldRepairs.REPAIR_RATE_BONUS = getSettingsFloat(modId, "field_repairs_stat1");
        FASFieldRepairs.INSTA_REPAIR_PERCENT = getSettingsFloat(modId, "field_repairs_stat2");
        FASFieldRepairs.MIN_HULL = getSettingsFloat(modId, "field_repairs_stat3");
        FASFieldRepairs.MAX_HULL = getSettingsFloat(modId, "field_repairs_stat4");
        FASFieldRepairs.MIN_CR = getSettingsFloat(modId, "field_repairs_stat5");
        FASFieldRepairs.MAX_CR = getSettingsFloat(modId, "field_repairs_stat6");

        OrdnanceExpertise.FLUX_PER_OP = getSettingsFloat(modId, "ordnance_expertise_stat1");
        OrdnanceExpertise.CAP_PER_OP = getSettingsFloat(modId, "ordnance_expertise_stat2");

        FASPolarizedArmor.MAX_ARMOR_DAMAGE_REDUCTION_BONUS = getSettingsFloat(modId, "polarized_armor_stat1");
        PolarizedArmor.EFFECTIVE_ARMOR_BONUS = getSettingsFloat(modId, "polarized_armor_stat2");
        PolarizedArmor.EMP_BONUS_PERCENT = getSettingsFloat(modId, "polarized_armor_stat3");
        PolarizedArmor.VENT_RATE_BONUS = getSettingsFloat(modId, "polarized_armor_stat4");

        ContainmentProcedures.CREW_LOSS_REDUCTION = getSettingsFloat(modId, "containment_procedures_stat1");
        ContainmentProcedures.FUEL_USE_REDUCTION_MAX_PERCENT = getSettingsFloat(modId, "containment_procedures_stat2");
        ContainmentProcedures.FUEL_USE_REDUCTION_MAX_FUEL = getSettingsFloat(modId, "containment_procedures_stat3");
        ContainmentProcedures.FUEL_SALVAGE_BONUS = getSettingsFloat(modId, "containment_procedures_stat4");

        MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_PERCENT = getSettingsFloat(modId, "makeshift_equipment_stat1");
        MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_UNITS = getSettingsFloat(modId, "makeshift_equipment_stat2");
        FASMakeshiftEquipment.SURVEY_COST_MULT = getSettingsFloat(modId, "makeshift_equipment_stat3") / 100f;

        IndustrialPlanning.SUPPLY_BONUS = getSettingsInt(modId, "industrial_planning_stat1");
        IndustrialPlanning.CUSTOM_PRODUCTION_BONUS = getSettingsFloat(modId, "industrial_planning_stat2");

        HullRestoration.DMOD_AVOID_MIN = getSettingsFloat(modId, "hull_restoration_stat1");
        HullRestoration.DMOD_AVOID_MAX = getSettingsFloat(modId, "hull_restoration_stat2");
        HullRestoration.DMOD_AVOID_MAX_DP = getSettingsFloat(modId, "hull_restoration_stat3");
        HullRestoration.DMOD_AVOID_MIN_DP = getSettingsFloat(modId, "hull_restoration_stat4");
        HullRestoration.CR_MAX_BONUS = getSettingsFloat(modId, "hull_restoration_stat5");
        HullRestoration.CR_MINUS_PER_DMOD = getSettingsFloat(modId, "hull_restoration_stat6");

        DerelictContingent.MINUS_DP_PERCENT_PER_DMOD = getSettingsFloat(modId, "derelict_operations_stat1");
    }

    public float getSettingsFloat(String modId, String fieldId) {
        Float val = LunaSettings.getFloat(modId, fieldId);
        if (val == null)
            return 1f;

        return val;
    }

    public int getSettingsInt(String modId, String fieldId) {
        Integer val = LunaSettings.getInt(modId, fieldId);
        if (val == null)
            return 1;

        return val;
    }
}
