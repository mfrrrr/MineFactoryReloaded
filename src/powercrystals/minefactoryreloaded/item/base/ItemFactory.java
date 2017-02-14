package powercrystals.minefactoryreloaded.item.base;

import cofh.api.core.IInitializer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import powercrystals.minefactoryreloaded.MFRRegistry;
import powercrystals.minefactoryreloaded.core.MFRUtil;
import powercrystals.minefactoryreloaded.gui.MFRCreativeTab;
import powercrystals.minefactoryreloaded.setup.MFRThings;

public class ItemFactory extends Item implements IInitializer{

	protected boolean _hasIcons = true;

	public ItemFactory() {

		setCreativeTab(MFRCreativeTab.tab);
		MFRThings.registerInitializer(this);
	}

	public Item setHasIcons(boolean icons) {

		_hasIcons = icons;
		return this;
	}

	public void getSubItems(Item item, List<ItemStack> subTypes) {

		subTypes.add(new ItemStack(item, 1, 0));
	}

	public void addInfo(ItemStack stack, EntityPlayer player, List<String> infoList, boolean advancedTooltips) {

		String str = "tip.info" + getUnlocalizedName(stack).substring(4);
		str = MFRUtil.localize(str, true, null);
		if (str != null)
			infoList.add(str);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List infoList, boolean advancedTooltips) {

		super.addInformation(stack, player, infoList, advancedTooltips);
		addInfo(stack, player, infoList, advancedTooltips);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List subTypes) {

		getSubItems(item, subTypes);
	}

	@Override
	public String toString() {

		StringBuilder b = new StringBuilder(getClass().getName());
		b.append('@').append(System.identityHashCode(this)).append('{');
		b.append("l:").append(getUnlocalizedName());
		b.append('}');
		return b.toString();
	}

	@Override
	public boolean preInit() {

		MFRRegistry.registerItem(this, getUnlocalizedName()); //TODO change to separate registry name
		return true;
	}

	@Override
	public boolean initialize() {

		return true;
	}

	@Override
	public boolean postInit() {

		return true;
	}
}
