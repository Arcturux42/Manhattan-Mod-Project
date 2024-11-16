package dev.manhattan.mods.entity;

// Imports for custom entity behavior, spawning, and attributes
import dev.manhattan.mods.init.EntitiesInit;
import dev.manhattan.mods.init.ItemsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

// Custom entity class for "Nuclebug"
public class NuclebugEntity extends Animal {

    // Constructor to initialize the entity with its type and level
    public NuclebugEntity(EntityType<NuclebugEntity> type, Level level) {
        super(type, level);
    }

    // Overloaded constructors for specific positions
    public NuclebugEntity(Level level, double x, double y, double z) {
        this(EntitiesInit.NUCLEBUG_ENTITY.get(), level);
        setPos(x, y, z);
    }

    public NuclebugEntity(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    // Define the behavior for offspring when breeding
    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return new NuclebugEntity(level, this.blockPosition());
    }

    // Register AI goals for the entity's behavior
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this)); // Entity floats in water
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D)); // Panic when in danger
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D)); // Breeding behavior
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1)); // Follow parent
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D)); // Random strolling
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F)); // Look at nearby players
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this)); // Random head movements
    }

    // Define attributes for the entity (based on Pig)
    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createAttributes();
    }

    // Spawn rule: check if the entity can spawn at a given position
    public static boolean canSpaw(EntityType<NuclebugEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }
}
