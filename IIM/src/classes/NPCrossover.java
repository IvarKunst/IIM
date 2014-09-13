package classes;

import java.util.Arrays;

import org.vu.contest.ContestEvaluation;

public class NPCrossover extends Combination
{
	private int nrSplits;
	private int[] splits;
	
	public NPCrossover(Individual[] individuals, ContestEvaluation evaluation, int nrSplits)
	{
		this.nrSplits = nrSplits;
		this.individuals = individuals;
		evaluation_ = evaluation;
		splits = new int[nrSplits];
		fillSplits();
	}
	
	private void fillSplits()
	{
		int rand;
		
		for (int i = 0; i < nrSplits; i++)
		{
			rand = getRandomInt(individuals.length) + 1;
			while(false)//rand nog niet in de splits array
			{
				//rand = getRandomInt(individuals.length) + 1;
			}
			splits[i] = rand;
		}
	}
	
	public Individual[] createParents()
	{
		Individual ind1;
		Individual ind2;
		
		for(int i=0; nrParents< this.individuals.length; i++)
		{
			//ind1 = getFittest();
			//ind2 = getFittest();
			//combineIndividuals(ind1, ind2);
		}
		
		return parents;
	}
	
	private void combineIndividuals(Individual ind1, Individual ind2)
	{
		double[] genotype1 = new double[ind1.GENOTYPE_LENGTH];
		double[] genotype2 = new double[ind1.GENOTYPE_LENGTH];
		int split = getRandomInt(ind1.GENOTYPE_LENGTH) + 1;
				
		for(int j = 0; j < nrSplits; j++)
		{
			for(int i = 0; i < splits[j]; i++)
			{
				genotype1[i]=ind1.getGene(i);
				genotype2[i]=ind2.getGene(i);
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

}
