package classes;

import java.util.Arrays;
import org.vu.contest.ContestEvaluation;

public class UniformCrossover extends Combination
{
	//p misschien af laten hangen van de fittness van de twee Individuals?
	private static double p = 0.5;
	
	public UniformCrossover(Individual[] individuals, ContestEvaluation evaluation)
	{
		this.individuals = individuals;
		evaluation_ = evaluation;
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
		double[] random = new double[ind1.GENOTYPE_LENGTH];
		
		Arrays.fill(random,getRandomDouble());
		
		for(int i = 0; i < random.length; i++)
		{
			if(random[i] <= p)
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
}
