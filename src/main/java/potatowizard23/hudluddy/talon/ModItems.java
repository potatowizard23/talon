package potatowizard23.hudluddy.talon;

import java.util.function.Function;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
// import net.minecraft.registry.Registry;
// import net.minecraft.registry.Registries;
// import net.minecraft.registry.RegistryKey;
// import net.minecraft.registry.RegistryKeys;

// import net.minecraft.util.registry.Registries;

public class ModItems {
	public static final Item OWL_EGG = register("owl_egg", Item::new, new Item.Settings());

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Talon.MOD_ID, name));

		// Create the item instance.
		Item item = itemFactory.apply(settings.registryKey(itemKey));

		// Register the item.
		Registry.register(Registries.ITEM, itemKey, item);

		return item;
	}

	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
			.register((itemGroup) -> itemGroup.add(ModItems.OWL_EGG));
	}
}
