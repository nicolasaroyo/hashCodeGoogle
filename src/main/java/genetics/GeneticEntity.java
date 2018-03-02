package genetics;

import java.util.AbstractMap.SimpleEntry;

public interface GeneticEntity {
	public GeneticEntity createRandom();
	public int calculateScore();
	public SimpleEntry<GeneticEntity, GeneticEntity> crossWith(GeneticEntity entity);
	public void mutateEntity();
}
