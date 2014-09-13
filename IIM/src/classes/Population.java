package classes;

import java.util.Arrays;
import java.util.Random;

import org.vu.contest.ContestEvaluation;

import classes.Individual;

public class Population 
{
	private int populationSize ;
	private Individual[] individuals;
	private ContestEvaluation evaluation_;
	private int evaluations;
	private int evaluations_limit_;
	
	public Population(int populationSize, ContestEvaluation evaluation, int evaluationsLimit)
	{
		this.populationSize = populationSize;
		evaluation_ = evaluation;
		evaluations_limit_ = evaluationsLimit;
		evaluations = 0;
		
		individuals = new Individual[this.populationSize];
		Arrays.fill(individuals, new Individual(evaluation_));
	}
	
	public void evaluateIndividuals()
	{
		for (int i=0; i < individuals.length && evaluations < evaluations_limit_; i++)
		{
			individuals[i].evaluate();
			evaluations ++;
		}
	}
	
	public void selectParents()
	{
		UniformCrossover UC = new UniformCrossover(individuals, evaluation_);
		individuals = UC.createParents();
		
	}
	
	
	public int getEvaluations()
	{
		return evaluations;
	}
}
