package main.hu.mrbarneyy.mythickoth.mcore.utils.loader;

import java.io.File;
import java.util.List;

import main.hu.mrbarneyy.mythickoth.mcore.utils.inventory.Button;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.material.MaterialData;

@SuppressWarnings("deprecation")
public class ButtonLoader extends main.hu.mrbarneyy.mythickoth.mcore.utils.MUtils implements Loader<Button> {

	@Override
	public Button load(YamlConfiguration configuration, String path, File file) {

		String name = configuration.getString(path + "name") == null ? null
				: color(configuration.getString(path + "name"));
		int slot = configuration.getInt(path + "slot", 0);
		Material item = Material.valueOf(configuration.getString(path + "item"));
		int data = configuration.getInt(path + "data", 0);
		List<String> lore = configuration.getStringList(path + "lore");

		return new Button(slot, name, item, data, lore);
	}

	@Override
	public void save(Button object, YamlConfiguration configuration, String path) {

		configuration.set(path + "name", object.getName() != null ? colorReverse(object.getName()) : null);
		configuration.set(path + "slot", object.getSlot());
		configuration.set(path + "lore", object.getLore() == null ? null : object.getLore());
		MaterialData materialData = object.getItem();
		configuration.set(path + "material", materialData == null ? null : materialData.getItemType());
		configuration.set(path + "data", materialData == null ? null : materialData.getData());

	}

}
