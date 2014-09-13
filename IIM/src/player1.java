import org.vu.contest.ContestSubmission;
import org.vu.contest.ContestEvaluation;

import java.util.Random;
import java.util.Properties;
import java.lang.Exception;

import classes.Individual;
import classes.Population;

public class player1
{
	private Random rnd_;
	private ContestEvaluation evaluation_;
	private int evaluations_limit_;
	private Population population;
	private int j;
	
	public player1()
	{
		rnd_ = new Random();
	}
	
	public void setSeed(long seed)
	{
		// Set seed of algortihms random process
		rnd_.setSeed(seed);
	}

	public void setEvaluation(ContestEvaluation evaluation)
	{
		// Set evaluation problem used in the run
		evaluation_ = evaluation;
		
		// Get evaluation properties
		Properties props = evaluation.getProperties();
		evaluations_limit_ = Integer.parseInt(props.getProperty("Evaluations"));
		boolean isMultimodal = Boolean.parseBoolean(props.getProperty("Multimodal"));
		boolean hasStructure = Boolean.parseBoolean(props.getProperty("GlobalStructure"));
		boolean isSeparable = Boolean.parseBoolean(props.getProperty("Separable"));
		// Property keys depend on specific evaluation
		// E.g. double param = Double.parseDouble(props.getProperty("property_name"));

		// Do sth with property values, e.g. specify relevant settings of your algorithm
	}
	
	public void run()
	{
		int size;
		
		try
		{
			if (null == evaluation_)
			{
				throw new IllegalArgumentException ("The evaluation is null.");
			}
			
			size = 10;
			population = new Population(size, evaluation_, evaluations_limit_);\
			population.evaluateIndividuals();
			
			while(population.getEvaluations() < evaluations_limit_)
			{
				population.selectParents();
				population.evaluateIndividuals();
				//population.getFittest();
			}
			// Run your algorithm here
	
			// Getting data from evaluation problem (depends on the specific evaluation implementation)
			// E.g. getting a vector of numbers
			// Vector<Double> data = (Vector<Doulbe>)evaluation_.getData("trainingset1");
	
			// Evaluating your results
			// E.g. evaluating a series of true/false predictions
			// boolean pred[] = ...
			// Double score = (Double)evaluation_.evaluate(pred);
		}
		catch(IllegalArgumentException ex) 
		{
			ex.printStackTrace();
		}
	}
}
