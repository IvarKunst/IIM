package classes;

import java.util.Random;
import java.util.Arrays;

import org.vu.contest.ContestEvaluation;

import classes.Individual;

public class UniformCrossover 
{
	private static double p = 0.5;
	private ContestEvaluation evaluation_;
	private Individual[] individuals;
	private Individual[] parents;
	private int nrParents;

	public UniformCrossover(Individual[] individuals, ContestEvaluation evaluation)
	{
		this.individuals = individuals;
		evaluation_ = evaluation;
		parents = new Individual[this.individuals.length];
		nrParents = 0;
	}
	
	void createParents(Individual ind1, Individual ind2)
	{
		double[] genotype1 = new double[ind1.GENOTYPE_LENGTH];
		double[] genotype2 = new double[ind1.GENOTYPE_LENGTH];
		double[] random = new double[ind1.GENOTYPE_LENGTH];
		
		Arrays.fill(random,getRandom());
		
		for(int i = 0; i < random.length; i++)
		{
			if(random[i]< p)
			{
				genotype1[i]=ind1.getGene(i);
				genotype2[i]=ind2.getGene(i);
			}
			else
			{
				genotype1[i]=ind2.getGene(i);
				genotype2[i]=ind1.getGene(i);
			}
		}
		
		try
		{
			addParent(genotype1);
			addParent(genotype2);
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
	private void addParent(double[] genotype) throws Exception
	{
		if(nrParents < parents.length)
		{
			parents[nrParents] = new Individual(evaluation_, genotype);
		}
		else
		{
			throw new Exception("Populatie is al vol. Kan geen parent meer toevoegen.");
		}
	}
	
	private double getRandom()
	{
		Random rand = new Random();
		return rand.nextDouble();
	}
	
	public Individual[] getIndividuals()
	{
		return individuals;
	}
	
}
