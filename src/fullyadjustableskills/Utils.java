package fullyadjustableskills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.skills.*;
import fullyadjustableskills.skills.*;
import lunalib.lunaSettings.LunaSettings;

public class Utils {
    public static String modId = "fullyadjustableskills";
    public static boolean hasNex = Global.getSettings().getModManager().isModEnabled("nexerelin");

    public static void loadLunaSettings() {
        /* GENERAL SKILL STATS */
        BaseSkillEffectDescription.OP_THRESHOLD = getSettingsFloat("ordnance_point_threshold");
        BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD = getSettingsFloat("fighter_bay_threshold");
        BaseSkillEffectDescription.PHASE_OP_THRESHOLD = getSettingsFloat("phase_ordnance_point_threshold");
        BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD = getSettingsFloat("automated_points_threshold");

        /* COMBAT SKILL TREE STATS */
        Helmsmanship.MANEUVERABILITY_BONUS = getSettingsFloat("helmsmanship_stat1");
        Helmsmanship.SPEED_BONUS = getSettingsFloat("helmsmanship_stat2");
        Helmsmanship.ELITE_SPEED_BONUS_FLAT = getSettingsFloat("helmsmanship_stat3");

        CombatEndurance.PEAK_TIME_BONUS = getSettingsFloat("combat_endurance_stat1");
        CombatEndurance.DEGRADE_REDUCTION_PERCENT = getSettingsFloat("combat_endurance_stat2");
        CombatEndurance.MAX_CR_BONUS = getSettingsFloat("combat_endurance_stat3");
        CombatEndurance.REGEN_RATE = getSettingsFloat("combat_endurance_stat4") / 100f;
        CombatEndurance.TOTAL_REGEN_MAX_POINTS = getSettingsFloat("combat_endurance_stat5");
        CombatEndurance.TOTAL_REGEN_MAX_HULL_FRACTION = getSettingsFloat("combat_endurance_stat6");

        ImpactMitigation.ARMOR_DAMAGE_REDUCTION = getSettingsFloat("impact_mitigation_stat1");
        ImpactMitigation.DAMAGE_TO_MODULES_REDUCTION = getSettingsFloat("impact_mitigation_stat2");
        ImpactMitigation.MANEUVERABILITY_BONUS_LARGE = getSettingsFloat("impact_mitigation_stat3");
        ImpactMitigation.MANEUVERABILITY_BONUS_SMALL = getSettingsFloat("impact_mitigation_stat4");

        DamageControl.HULL_DAMAGE_REDUCTION = getSettingsFloat("damage_control_stat1");
        DamageControl.CREW_LOSS_REDUCTION = getSettingsFloat("damage_control_stat2");
        DamageControl.MODULE_REPAIR_BONUS = getSettingsFloat("damage_control_stat3");

        FieldModulation.SHIELD_DAMAGE_REDUCTION = getSettingsFloat("field_modulation_stat1");
        FieldModulation.PHASE_FLUX_UPKEEP_REDUCTION = getSettingsFloat("field_modulation_stat2");
        FieldModulation.FLUX_SHUNT_DISSIPATION = getSettingsFloat("field_modulation_stat3");
        FieldModulation.PHASE_COOLDOWN_REDUCTION = getSettingsFloat("field_modulation_stat4");
        FieldModulation.OVERLOAD_REDUCTION = getSettingsFloat("field_modulation_stat5");

        PointDefense.FIGHTER_DAMAGE_BONUS = getSettingsFloat("point_defense_stat1");
        PointDefense.MISSILE_DAMAGE_BONUS = getSettingsFloat("point_defense_stat2");
        PointDefense.PD_RANGE_BONUS_FLAT = getSettingsFloat("point_defense_stat3");

        TargetAnalysis.DAMAGE_TO_CRUISERS = getSettingsFloat("target_analysis_stat1");
        TargetAnalysis.DAMAGE_TO_CAPITALS = getSettingsFloat("target_analysis_stat2");
        TargetAnalysis.DAMAGE_TO_FRIGATES = getSettingsFloat("target_analysis_stat3");
        TargetAnalysis.DAMAGE_TO_DESTROYERS = getSettingsFloat("target_analysis_stat4");
        TargetAnalysis.DAMAGE_TO_MODULES_BONUS = getSettingsFloat("target_analysis_stat5");

        BallisticMastery.DAMAGE_BONUS = getSettingsFloat("ballistic_mastery_stat1");
        BallisticMastery.RANGE_BONUS = getSettingsFloat("ballistic_mastery_stat2");
        BallisticMastery.DAMAGE_ELITE = getSettingsFloat("ballistic_mastery_stat3");
        BallisticMastery.PROJ_SPEED_BONUS = getSettingsFloat("ballistic_mastery_stat4");

        SystemsExpertise.BONUS_CHARGES = getSettingsFloat("systems_expertise_stat1");
        SystemsExpertise.REGEN_PERCENT = getSettingsFloat("systems_expertise_stat2");
        SystemsExpertise.RANGE_PERCENT = getSettingsFloat("systems_expertise_stat3");
        SystemsExpertise.SYSTEM_COOLDOWN_REDUCTION_PERCENT = getSettingsFloat("systems_expertise_stat4");
        SystemsExpertise.ELITE_DAMAGE_REDUCTION = getSettingsFloat("systems_expertise_stat5");

        FASMissileSpecialization.MISSILE_AMMO_BONUS = getSettingsFloat("missile_specialization_stat1");
        FASMissileSpecialization.MISSILE_SPEC_PERK_HEALTH_BONUS = getSettingsFloat("missile_specialization_stat2");
        FASMissileSpecialization.MISSILE_SPEC_ROF_BONUS = getSettingsFloat("missile_specialization_stat3");
        FASMissileSpecialization.MISSILE_SPEC_AMMO_REGEN_BONUS = getSettingsFloat("missile_specialization_stat4");
        FASMissileSpecialization.MISSILE_SPEC_DAMAGE_BONUS = getSettingsFloat("missile_specialization_stat5");

        /* LEADERSHIP SKILL TREE STATS */
        TacticalDrills.DAMAGE_PERCENT = getSettingsFloat("tactical_drills_stat1");
        TacticalDrills.ATTACK_BONUS = getSettingsInt("tactical_drills_stat2");
        FASTacticalDrills.CASUALTIES_MULT = getSettingsFloat("tactical_drills_stat3") / 100f;

        CoordinatedManeuvers.NAV_FRIGATES = getSettingsFloat("coordinated_maneuvers_stat1");
        CoordinatedManeuvers.NAV_DESTROYERS = getSettingsFloat("coordinated_maneuvers_stat2");
        CoordinatedManeuvers.NAV_OTHER = getSettingsFloat("coordinated_maneuvers_stat3");
        CoordinatedManeuvers.CP_REGEN_FRIGATES = getSettingsFloat("coordinated_maneuvers_stat4");
        CoordinatedManeuvers.CP_REGEN_DESTROYERS = getSettingsFloat("coordinated_maneuvers_stat5");

        WolfpackTactics.DAMAGE_TO_LARGER_BONUS = getSettingsFloat("wolfpack_tactics_stat1");
        WolfpackTactics.DAMAGE_TO_LARGER_BONUS_DEST = getSettingsFloat("wolfpack_tactics_stat2");
        WolfpackTactics.PEAK_TIME_BONUS = getSettingsFloat("wolfpack_tactics_stat3");
        WolfpackTactics.PEAK_TIME_BONUS_DEST = getSettingsFloat("wolfpack_tactics_stat4");

        CrewTraining.CR_PERCENT = getSettingsFloat("crew_training_stat1");

        CarrierGroup.REPLACEMENT_RATE_PERCENT = getSettingsFloat("carrier_group_stat1");
        CarrierGroup.OFFICER_MULT = getSettingsFloat("carrier_group_stat2");

        FighterUplink.CREW_LOSS_PERCENT = getSettingsFloat("fighter_uplink_stat1");
        FighterUplink.MAX_SPEED_PERCENT = getSettingsFloat("fighter_uplink_stat2");
        FighterUplink.TARGET_LEADING_BONUS = getSettingsFloat("fighter_uplink_stat3");
        FighterUplink.OFFICER_MULT = getSettingsFloat("fighter_uplink_stat4");

        FASOfficerTraining.MAX_LEVEL_BONUS = getSettingsFloat("officer_training_stat1");
        FASOfficerTraining.MAX_ELITE_SKILLS_BONUS = getSettingsFloat("officer_training_stat2");
        FASOfficerTraining.CP_BONUS = getSettingsFloat("officer_training_stat3");

        OfficerManagement.NUM_OFFICERS_BONUS = getSettingsFloat("officer_management_stat1");
        OfficerManagement.CP_BONUS = getSettingsFloat("officer_management_stat2");

        BestOfTheBest.EXTRA_MODS = getSettingsInt("best_of_the_best_stat1");
        BestOfTheBest.DEPLOYMENT_BONUS = getSettingsFloat("best_of_the_best_stat2") / 100f;

        SupportDoctrine.DP_REDUCTION = getSettingsFloat("support_doctrine_stat1") / 100f;
        SupportDoctrine.DP_REDUCTION_MAX = getSettingsFloat("support_doctrine_stat2");
        SupportDoctrine.COMMAND_POINT_REGEN_PERCENT = getSettingsFloat("support_doctrine_stat3");

        /* TECHNOLOGY SKILL TREE STATS */
        Navigation.TERRAIN_PENALTY_REDUCTION = getSettingsFloat("navigation_stat1");
        Navigation.FLEET_BURN_BONUS = getSettingsFloat("navigation_stat2");
        Navigation.SB_BURN_BONUS = getSettingsFloat("navigation_stat3");

        Sensors.DETECTED_BONUS = getSettingsFloat("sensors_stat1");
        Sensors.SENSOR_BONUS = getSettingsFloat("sensors_stat2");
        Sensors.SLOW_BURN_BONUS = getSettingsFloat("sensors_stat3");

        GunneryImplants.TARGET_LEADING_BONUS = getSettingsFloat("gunnery_implants_stat1");
        GunneryImplants.RANGE_BONUS = getSettingsFloat("gunnery_implants_stat2");
        GunneryImplants.RECOIL_BONUS = getSettingsFloat("gunnery_implants_stat3");
        GunneryImplants.EW_FRIGATES = getSettingsFloat("gunnery_implants_stat4");
        GunneryImplants.EW_DESTROYERS = getSettingsFloat("gunnery_implants_stat5");
        GunneryImplants.EW_OTHER = getSettingsFloat("gunnery_implants_stat6");

        EnergyWeaponMastery.ENERGY_DAMAGE_PERCENT = getSettingsFloat("energy_weapon_mastery_stat1");
        EnergyWeaponMastery.MIN_RANGE = getSettingsFloat("energy_weapon_mastery_stat2");
        EnergyWeaponMastery.MAX_RANGE = getSettingsFloat("energy_weapon_mastery_stat3");
        FASEnergyWeaponMastery.FLUX_COST_MULT = getSettingsFloat("energy_weapon_mastery_stat4") / 100f;

        ElectronicWarfare.PER_SHIP_BONUS = getSettingsFloat("electronic_warfare_stat1");

        FluxRegulation.CAPACITORS_BONUS = getSettingsInt("flux_regulation_stat1");
        FluxRegulation.VENTS_BONUS = getSettingsInt("flux_regulation_stat2");
        FluxRegulation.DISSIPATION_PERCENT = getSettingsFloat("flux_regulation_stat3");
        FluxRegulation.CAPACITY_PERCENT = getSettingsFloat("flux_regulation_stat4");

        PhaseCorps.PEAK_TIME_BONUS = getSettingsFloat("phase_coil_tuning_stat1");
        PhaseCorps.PHASE_SPEED_BONUS = getSettingsFloat("phase_coil_tuning_stat2");
        PhaseCorps.PHASE_SHIP_SENSOR_BONUS_PERCENT = getSettingsFloat("phase_coil_tuning_stat3");

        // Neural Link - No Modifiable Stat

        CyberneticAugmentation.MAX_ELITE_SKILLS_BONUS = getSettingsFloat("cybernetic_augmentation_stat1");
        CyberneticAugmentation.BONUS_PER_ELITE_SKILL = getSettingsFloat("cybernetic_augmentation_stat2");

        AutomatedShips.MAX_CR_BONUS = getSettingsFloat("automated_ships_stat1");

        /* INDUSTRY SKILL TREE STATS */
        BulkTransport.CARGO_CAPACITY_MAX_PERCENT = getSettingsFloat("bulk_transport_stat1");
        BulkTransport.CARGO_CAPACITY_THRESHOLD = getSettingsFloat("bulk_transport_stat2");
        BulkTransport.FUEL_CAPACITY_MAX_PERCENT = getSettingsFloat("bulk_transport_stat3");
        BulkTransport.FUEL_CAPACITY_THRESHOLD = getSettingsFloat("bulk_transport_stat4");
        BulkTransport.PERSONNEL_CAPACITY_MAX_PERCENT = getSettingsFloat("bulk_transport_stat5");
        BulkTransport.PERSONNEL_CAPACITY_THRESHOLD = getSettingsFloat("bulk_transport_stat6");
        BulkTransport.BURN_BONUS = getSettingsFloat("bulk_transport_stat7");

        Salvaging.SALVAGE_BONUS = getSettingsFloat("salvaging_stat1");
        FASSalvaging.COMBAT_SALVAGE = getSettingsFloat("salvaging_stat2");
        Salvaging.CREW_LOSS_REDUCTION = getSettingsFloat("salvaging_stat3");

        FASFieldRepairs.REPAIR_RATE_BONUS = getSettingsFloat("field_repairs_stat1");
        FASFieldRepairs.INSTA_REPAIR_PERCENT = getSettingsFloat("field_repairs_stat2");
        FASFieldRepairs.MIN_HULL = getSettingsFloat("field_repairs_stat3");
        FASFieldRepairs.MAX_HULL = getSettingsFloat("field_repairs_stat4");
        FASFieldRepairs.MIN_CR = getSettingsFloat("field_repairs_stat5");
        FASFieldRepairs.MAX_CR = getSettingsFloat("field_repairs_stat6");

        OrdnanceExpertise.FLUX_PER_OP = getSettingsFloat("ordnance_expertise_stat1");
        OrdnanceExpertise.CAP_PER_OP = getSettingsFloat("ordnance_expertise_stat2");

        FASPolarizedArmor.MAX_ARMOR_DAMAGE_REDUCTION_BONUS = getSettingsFloat("polarized_armor_stat1");
        PolarizedArmor.EFFECTIVE_ARMOR_BONUS = getSettingsFloat("polarized_armor_stat2");
        PolarizedArmor.EMP_BONUS_PERCENT = getSettingsFloat("polarized_armor_stat3");
        PolarizedArmor.VENT_RATE_BONUS = getSettingsFloat("polarized_armor_stat4");

        ContainmentProcedures.CREW_LOSS_REDUCTION = getSettingsFloat("containment_procedures_stat1");
        ContainmentProcedures.FUEL_USE_REDUCTION_MAX_PERCENT = getSettingsFloat("containment_procedures_stat2");
        ContainmentProcedures.FUEL_USE_REDUCTION_MAX_FUEL = getSettingsFloat("containment_procedures_stat3");
        ContainmentProcedures.FUEL_SALVAGE_BONUS = getSettingsFloat("containment_procedures_stat4");

        MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_PERCENT = getSettingsFloat("makeshift_equipment_stat1");
        MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_UNITS = getSettingsFloat("makeshift_equipment_stat2");
        FASMakeshiftEquipment.SURVEY_COST_MULT = getSettingsFloat("makeshift_equipment_stat3") / 100f;

        IndustrialPlanning.SUPPLY_BONUS = getSettingsInt("industrial_planning_stat1");
        IndustrialPlanning.CUSTOM_PRODUCTION_BONUS = getSettingsFloat("industrial_planning_stat2");

        HullRestoration.DMOD_AVOID_MIN = getSettingsFloat("hull_restoration_stat1");
        HullRestoration.DMOD_AVOID_MAX = getSettingsFloat("hull_restoration_stat2");
        HullRestoration.DMOD_AVOID_MAX_DP = getSettingsFloat("hull_restoration_stat3");
        HullRestoration.DMOD_AVOID_MIN_DP = getSettingsFloat("hull_restoration_stat4");
        HullRestoration.CR_MAX_BONUS = getSettingsFloat("hull_restoration_stat5");
        HullRestoration.CR_MINUS_PER_DMOD = getSettingsFloat("hull_restoration_stat6");

        DerelictContingent.MINUS_DP_PERCENT_PER_DMOD = getSettingsFloat("derelict_operations_stat1");
    }

    public static float getSettingsFloat(String fieldId) {
        Float val = LunaSettings.getFloat(modId, fieldId);
        if (val == null)
            return 1f;
        return val;
    }

    public static int getSettingsInt(String fieldId) {
        Integer val = LunaSettings.getInt(modId, fieldId);
        if (val == null)
            return 1;
        return val;
    }
}
