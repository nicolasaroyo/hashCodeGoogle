package genetics;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneticSolver {
	private final float crossingProbability;
	private final float mutationProbability;
	private final int nbGenerations;
	private final int nbEntitiesPerGeneration;

	private final Random rand = new Random();

	public GeneticSolver(final float crossingProbability, final float mutationProbability, final int nbGenerations,
			final int nbEntitiesPerGeneration) {
		assert nbEntitiesPerGeneration % 4 == 0;
		this.crossingProbability = crossingProbability;
		this.mutationProbability = mutationProbability;
		this.nbGenerations = nbGenerations;
		this.nbEntitiesPerGeneration = nbEntitiesPerGeneration;
	}

	public GeneticEntity solve() {
		List<GeneticEntity> population = this.generateInitialPopulation();

		for (int i = 0; i < nbGenerations; i++) {
			population = this.selectBestCandidates(population);
			final List<SimpleEntry<GeneticEntity, GeneticEntity>> couples = this.selectCouplesRandomly(population);
			final List<SimpleEntry<GeneticEntity, GeneticEntity>> sons = couples.stream().map(this::crossCouple).collect(Collectors.toList());
			population.addAll(sons.stream().map(SimpleEntry::getKey).collect(Collectors.toList()));
			population.addAll(sons.stream().map(SimpleEntry::getValue).collect(Collectors.toList()));
			population.stream().forEach(this::mutateEntity);
		}
		
		population.sort(this::compareTwoEntities);
		return population.get(0);
	}

	private int compareTwoEntities(GeneticEntity e1, GeneticEntity e2) {
		return e1.calculateScore() - e2.calculateScore();
	}

	private void mutateEntity(GeneticEntity entity) {
		if (rand.nextFloat() < mutationProbability) {
			entity.mutateEntity();
		}
	}

	private SimpleEntry<GeneticEntity, GeneticEntity> crossCouple(SimpleEntry<GeneticEntity, GeneticEntity> couple) {
		if (rand.nextFloat() < crossingProbability) {
			return couple.getKey().crossWith(couple.getValue());
		} else {
			// What do I do in that case ???
			return null;
		}
	}

	private List<SimpleEntry<GeneticEntity, GeneticEntity>> selectCouplesRandomly(List<GeneticEntity> population) {
		// TODO
		return new ArrayList<>();
	}

	private List<GeneticEntity> selectBestCandidates(List<GeneticEntity> population) {
		// TODO
		return new ArrayList<>();
	}

	private List<GeneticEntity> generateInitialPopulation() {
		// TODO
		return new ArrayList<>();
	}
}
