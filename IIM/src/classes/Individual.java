package classes;

import java.util.Random;
import java.util.Arrays;

import org.vu.contest.ContestEvaluation;

public class Individual 
{
	protected static int GENOTYPE_LENGTH = 10;
	static private double MIN_VALUE_DIM = -5;
	static private double MAX_VALUE_DIM = 5;
		
	private ContestEvaluation evaluation_;
	private double[] genotype;
	private double fenotype;
	
	public Individual()
	{
	}
	
	public Individual(ContestEvaluation evaluation)
	{
		evaluation_ = evaluation;
		genotype = new double[GENOTYPE_LENGTH];
		Arrays.fill(genotype, getRandomGenotype());
	}
	
	public Individual(ContestEvaluation evaluation, double[] genotype)
	{
		evaluation_ = evaluation;
		this.genotype = genotype;
	}
	
	public void evaluate()
	{
		fenotype = ((Double) evaluation_.evaluate(genotype)).doubleValue();
	}
	
	private double getRandomGenotype()
	{
		Random rand = new Random();
		return MIN_VALUE_DIM + (MAX_VALUE_DIM - MIN_VALUE_DIM) * rand.nextDouble();
	}
	
	public double getGene(int i)
	{
		return genotype[i];
	}
		
	public double getFenotype()
	{
		return fenotype;		
	}
}
