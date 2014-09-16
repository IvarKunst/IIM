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
			while(Arrays.asList(splits).contains(rand))
			{
				rand = getRandomInt(individuals.length) + 1;
			}
			splits[i] = rand;
		}
		
		Arrays.sort(splits);
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
		int indGenotype = 1;
		int i = 0;
		int j = 0;
		int k = 0;
		int split;
		
		while(i < genotype1.length && j < nrSplits)
		{
			split = splits[j];
			if(split == i)
			{
				indGenotype = indGenotype * -1;
				j++;
			}
			
			if (indGenotype == 1)
			{
				genotype1[i]=ind1.getGene(i);
				genotype2[i]=ind2.getGene(i);
			}
			else
			{
				genotype1[i]=ind2.getGene(i);
				genotype2[i]=ind1.getGene(i);
			}
			i++;
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
