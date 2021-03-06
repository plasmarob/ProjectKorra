package com.projectkorra.projectkorra.ability;

import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.ProjectKorra;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public abstract class AvatarAbility extends ElementalAbility {

	public AvatarAbility(Player player) {
		super(player);
	}

	@Override
	public boolean isIgniteAbility() {
		return false;
	}

	@Override
	public boolean isExplosiveAbility() {
		return false;
	}

	@Override
	public final Element getElement() {
		return Element.AVATAR;
	}

	public static void playAvatarSound(Location loc) {
		if (getConfig().getBoolean("Abilities.Avatar.AvatarState.PlaySound")) {
			float volume = (float) getConfig().getDouble("Abilities.Avatar.AvatarState.Sound.Volume");
			float pitch = (float) getConfig().getDouble("Abilities.Avatar.AvatarState.Sound.Pitch");
			
			Sound sound = Sound.BLOCK_ANVIL_LAND;
			
			try {
				sound = Sound.valueOf(getConfig().getString("Properties.Avatar.AvatarState.Sound.Sound"));
			} catch (IllegalArgumentException exception) {
				ProjectKorra.log.warning("Your current value for 'Properties.Avatar.AvatarState.Sound.Sound' is not valid.");
			} finally {
				loc.getWorld().playSound(loc, sound, volume, pitch);	
			}
		}
	}

	/**
	 * Determines whether the ability requires the user to be an avatar in order
	 * to be able to use it. Set this to <tt>false</tt> for moves that should be
	 * able to be used without players needing to have the avatar element
	 */
	public boolean requireAvatar() {
		return true;
	}

}