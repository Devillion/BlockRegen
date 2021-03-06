package nl.Aurorion.BlockRegen.Particles.breaking;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;

import nl.Aurorion.BlockRegen.Events.BlockBreak;

public class WitchSpell implements Runnable {
	
	int points = 40;
    double radius = 0.5d;
	Block block = BlockBreak.block;

	@Override
	public void run() {
		
		Location loc = block.getLocation();
		loc.add(0.5,0.5,0.5);
		World world = block.getWorld();
		for (int i = 0; i < points; i++) {
            double angle = 2 * Math.PI * i / points;
            Location point = loc.clone().add(radius * Math.sin(angle), 0.0d, radius * Math.cos(angle));
            world.spawnParticle(Particle.SPELL_WITCH, point, 1, 0,0,0);
        }
		loc.subtract(0.5,0.5,0.5);
		
	}
}
