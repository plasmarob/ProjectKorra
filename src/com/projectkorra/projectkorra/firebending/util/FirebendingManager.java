package com.projectkorra.projectkorra.firebending.util;

import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.FireAbility;
import com.projectkorra.projectkorra.firebending.BlazeArc;

public class FirebendingManager implements Runnable {

	public ProjectKorra plugin;

	public FirebendingManager(ProjectKorra plugin) {
		this.plugin = plugin;
	}

	public void run() {
		BlazeArc.handleDissipation();
		FireDamageTimer.handleFlames();
		BlazeArc.dissipateAll();
		FireAbility.removeFire();
	}
}
