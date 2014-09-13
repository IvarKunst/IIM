package classes;

import java.util.Arrays;
import java.util.Random;

import classes.Individual;

import org.vu.contest.ContestEvaluation;

public class Combination 
{
	protected ContestEvaluation evaluation_;
	protected Individual[] individuals;
	protected Individual[] parents = new Individual[this.individuals.length];
	protected int nrParents = 0;
	
	public Combination()
	{
		
	}
	
	protected void addParent(double[] genotype) throws Exception
	{
		if(nrParents < parents.length)
		{
			parents[nrParents] = new Individual(evaluation_, genotype);
			nrParents++;
		}
		else
		{
			throw new Exception("Populatie is al vol. Kan geen parent meer toevoegen.");
		}
	}
	
	protected double getRandomDouble()
	{
		Random rand = new Random();
		return rand.nextDouble();
	}
	
	protected int getRandomInt(int maxValue)
	{
		Random rand = new Random();
		return rand.nextInt(maxValue);
	}
	
	public Individual[] getParents()
	{
		return parents;
	}
}
