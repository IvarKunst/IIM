package classes;

import java.util.Random;
import java.util.Arrays;

import org.vu.contest.ContestEvaluation;

public class Parent extends Individual 
{
	private static double p = 0.5;
	private Individual ind1;
	private Individual ind2;
	private Individual parent;
	private ContestEvaluation evaluation_;
	
	
	public Parent(Individual ind1, Individual ind2, ContestEvaluation evaluation)
	{
		this.ind1 = ind1;
		this.ind2 = ind2;
		evaluation_ = evaluation;
	}
	
	public Individual createParent()
	{
		double[] genotype = new double[GENOTYPE_LENGTH];
		double[] random = new double[GENOTYPE_LENGTH];
		
		Arrays.fill(random,getRandom());
		
		for(int i = 0; i < genotype.length; i++)
		{
			if(random[i]< p)
			{
				genotype[i]=ind1.getGene(i);
			}
			else
			{
				genotype[i]=ind2.getGene(i);
			}
		}
		
		return parent;
	}
	
	private double getRandom()
	{
		Random rand = new Random();
		return rand.nextDouble();
	}
}
