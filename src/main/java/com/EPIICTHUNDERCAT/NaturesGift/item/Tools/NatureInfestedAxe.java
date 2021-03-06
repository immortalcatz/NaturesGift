package com.EPIICTHUNDERCAT.NaturesGift.item.Tools;

import com.EPIICTHUNDERCAT.NaturesGift.Misc.NGAchievement;
import com.EPIICTHUNDERCAT.NaturesGift.Misc.NGCreativeTabs;
import com.EPIICTHUNDERCAT.NaturesGift.init.NGItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.Item.ToolMaterial;

public class NatureInfestedAxe extends ItemAxe{

	public NatureInfestedAxe(String name, ToolMaterial material) {
		super(material, 6.0f, 6.0f);
		setRegistryName(name.toLowerCase());
		setUnlocalizedName(name.toLowerCase());
		addToItems(this);
		this.setCreativeTab(NGCreativeTabs.NGCombat);
	}

	private void addToItems(Item item) {

		NGItems.items.add(item);

	}

	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		if (toRepair.getItem() == NGItems.NATURE_INFESTED_AXE) {
			return repair.getItem() == NGItems.STRONG_NATURE_MATERIAL;
		}
		return false;
	}

	@Override
    public void onCreated(final ItemStack item, final World world, final EntityPlayer crafter) {
        super.onCreated(item, world, crafter);
        crafter.addStat(NGAchievement.InfestedAxe, 1);
    }
}
