import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



/**
 * Taylor Huntington
 * Modified from  https://github.com/tpeng/logistic-regression/blob/master/src/Logistic.java
 */
public class LogisticRegressionModel {

	/** the learning rate */
	private double rate;

	/** the weight to learn */
	public double[] weights;

	/** the number of iterations */
	private int ITERATIONS = 3000;

	public LogisticRegressionModel(int n) {
		this.rate = 0.0001;

		weights = new double[n];

	}

	private static double sigmoid(double z) {
		return 1.0 / (1.0 + Math.exp(-z));
	}

	public void train(ArrayList<Pokemon> instances) {
		for (int n=0; n<ITERATIONS; n++) {
			//for each iteration
			for (int i=0; i<instances.size(); i++) {

				double label = 0.0

				Pokemon tester = instances.get(i);
		
				if(tester.isSquirtle()){
					label = 1.0
				}

				double[] predictions = predict();

				double predicted = classify(instances);

				//weights[0] represents the squirtle weight for audubon
				if(tester.inAud()){
					//prevents negative ratios
					if(predictions[0] < 0.001 && label == 0.0){
						weights[0] = weights[0];	
					}
					else{
						weights[0] = weights[0] + rate *(label - predictions[1]);
					}


					weights[0] = weights[0] + rate *(label - predictions[0]);
				}

				//weights[1] represents the squirtle weight for non-audubon
				else{
					//prevents negative ratios
					if(predictions[1] < 0.001 && label == 0.0){
						weights[1] = weights[1];	
					}
					else{
						weights[1] = weights[1] + rate *(label - predictions[1]);
					}
				}			

				}
		}
	}

	//answer[0] is the audubon ratio of squirtles, answer[1] is the non audubon ratio of squirtles
	public double[] predict(){
		double[] answer = new double[2];

		answer[0] = weights[0];
		answer[1] = weights[1];

		return answer;
	}

/*
	private double classify(int[] x) {

		double logit = 0.0;

		double differencepredict = 

		for (int i=0; i<weights.length;i++)  {
			logit = logit + weights[0] * x[i].isAudSquirtle();
		}
		return sigmoid(logit);
	}
	*/

	public double[] arrayClassify(ArrayList<Pokemon> pokeList) {

		double logit[] = {0.0, 0.0};

		listSize = pokeList.size();

		for (int i=0; i<listSize; i++) {

			double label = 0.0

			Pokemon tester = pokeList.get(i);
		
			if(tester.isSquirtle()){
				label = 1.0
			}

			double[] predictions = predict();

			double impactweight = 1 / listSize;

			//logit[0] represents the squirtle weight for audubon
			if(tester.inAud()){
				//prevents negative ratios
				if(predictions[0] < 0.001 && label == 0.0){
					logit[0] = logit[0];	
				}
				else{
					logit[0] = logit[0] + (impactweight*label);
				}
			}
				//weights[1] represents the squirtle weight for non-audubon
			else{
				//prevents negative ratios
				if(predictions[1] < 0.001 && label == 0.0){
					logit[1] = logit[1];	
				}
				else{
					logit[1] = logit[1] + (impactweight*label); 
				}
			}
		}

		logit[0] = sigmoid(logit[0]);
		logit[1] = sigmoid(logit[1]);

		return logit;
	}

	public void asString(){
		double audratio = weights[0];

		double nonratio = weights[1];

		System.out.println("The model predicts that " + (audratio*100) + "% of Audubon spawns will be squirtles.");
		System.out.println("The model predicts that " + (nonratio*100) + "% of Non-Audubon spawns will be squirtles.");
	}

	public static class Instance {
		public int label;
		public int[] asarray;

		public int id;
		public int hour;
		public int intAud;

		public Instance(int label, int[] x) {
			this.label = x[0];
			this.asarray = x;
			this.id = x[0];
			this.hour = x[1];
			this.intAud = x[2];
		}
	}


    Public ArrayList<Pokemon> readPokemon(String input) {

        //ArrayList<Pokemon> audList = new ArrayList<Pokemon>();
        //ArrayList<Pokemon> nonList = new ArrayList<Pokemon>();
        ArrayList<Pokemon> combinedList = new ArrayList<Pokemon>();

        Path pathToFile = Paths.get(input);

        // create an instance of BufferedReader

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String header = br.readLine();

            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                int[] spawns = line.split(",");
                int spawnlength = spawns.length();

                for(int i=1 ; i<=spawnlength ; i++ ) {

                    //If a Pokemon is spawned at point
                    if(spawns[i] > 0) {

                        if( i > 5) {
                            Pokemon nonaud = new Pokemon(spawns[i], spawns[0], False);
                            combinedList.add(nonaud);
                        }
                        else {
                            Pokemon inaud = new Pokemon(spawns[i], spawns[0], True);
                            combinedList.add(inaud);
                        }
                    }
                }

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return myList;
    }
}



	public static void main(String... args) throws FileNotFoundException {

		ArrayList<Pokemon> trainingList = readPokemon("pokeinputfriday.csv");

		LogisticRegressionModel logistic = new LogisticRegressionModel(2);

		logistic.train(trainingList);

		//Prints predictions of squirtle spawns in audubon and nonaudubon squirtle ratios
		logistic.asString();

		double[] modelpredictions = logistic.predict();

		ArrayList<Pokemon> testList = readPokemon("pokeinputsunday.csv")

		double[] testresults = logistic.arrayClassify(testList);

		double auddiff = modelpredictions[0] - testresults[0];
		double nondiff = modelpredictions[1] - testresults[1];

		System.out.println("Our test results found " + (testresults[0] * 100) + "of Audubon spawns to be squirtles.");
		System.out.println("This is a " + (auddiff*100) + "% difference from what we predicted for audubon spawns.");

		System.out.println("Our test results found " + (testresults[1] * 100) + "of Non-Audubon spawns to be squirtles");
		System.out.println("This is a " + (nondiff*100) + "% difference from what we predicted for non-audubon spawns..");

		double audubonEffect = testresults[0] - testresults[1];

		System.out.println("Our test results found" + (audubonEffect*100) + "% correlation to Squirtles to Audubon Park over all other areas."


	}

 public class Pokemon {

    private int id;
    private String day
    private int hour
    private boolean inAud


    public Pokemon(int sid, int shour, boolean sinAud) {

        this.id = sid;
        this.day = sday;
        this.hour = shour;
        this.inAud = sinAud;

    }

    public int getID(){
        return int (id);
    }

    public int getHour(){
        return hour;
    }

    public boolean inAud(){
        return inAud;
    }

    //Returns 1 if in Audubon, 0 if outside of Audubon
    public int intAud(){
        int answer = 0;
        if(inAud){
            answer = 1;
        }
        return answer;
    }

    public double doubleAud(){
        double answer = 0.0;
        if(inAud){
            answer = 1.0;
        }
        return answer;
    }

    public double isAudSquirtle(){
        double answer = 0.0
        if(inAud){
            if(getID() == 1){
                answer = 1.0;
            }
        }
        return answer;
    }


    //Returns an Array of integers where [0] = ID, [1] = spawn hour, and [2] = 1 if in audubon 0 if not
    public int[] asArray(){
        int[] array = new int[3]
        array[0] = getID();
        array[1] = getHour();
        array[2] = intAud();
    }

    public boolean isSame(Pokemon p){
        boolean answer = True;
        if(p.getID() == this.getID()){
            if(p.getHour() == this.getHour(){
                if(p.inAud(){
                    answer = False;
                })
            }
        }
        return answer;
    }
}
