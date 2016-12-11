import java.util.*
/**
 * 
 * 
 * Taylor Huntington
 *
 */

public class PokeLearner {

	ArrayList<Pokemon> myList;
	ArrayList<Pokemon> audList;
	ArrayList<Pokemon> nonList;

	int ntotal;

	int nsquirtle;
	int nbulbasaur;
	int neevee;
	int npidgey;
	int nother;

	public PokeLearner(ArrayList<Pokemon> inputList){

		myList = inputList;

		ntotal = myList.length();

		int nsquirtle = 0;
		int nbulbasaur = 0;
		int neevee = 0;
		int npidgey = 0;
		int nother = 0;

		for(Pokemon poke : myList){
			if(poke.inAud()){
				audList.add(poke);
			}
			else{
				nonList.add(poke);
			}
		}

		for(Pokemon poketemp : myList){
			if(poketemp.getID() == 1){
				nsquirtle = nsquirtle + 1;
			}
			if(poketemp.getID() == 2){
				nbulbasaur = nbulbsaur + 1;
			}
			if(poketemp.getID() == 3){
				neevee = neevee + 1;
			}
			if(poketemp.getID() == 4){
				npidgey = npidgey + 1;
			}
			if(poketemp.getID() == 5){
				nother = nother + 1;
			}
		}


	}

	public boolean pokeInList(Pokemon cpoke){
		boolean answer = False;
		for(Pokemon apoke : myList){
			if(apoke.isSame(cpoke)){
				answer = True;
			}
		}
		return answer;
	}

	public boolean pokeInTest(Pokemon poketest, ArrayList<Pokemon> testerList){
		boolean answer = False;
		for(Pokemon listPoke : testerList){
			if(listPoke.isSame(poketest)){
				answer = True;
			}
		}
		return answer;
	}

	public ArrayList<Pokemon> spawnsNotInTest(ArrayList<Pokemon> testList){

		ArrayList<Pokemon> listToReturn = new ArrayList<Pokemon>;

		for(Pokemon testpoke : myList){
			if(pokeinTest(testpoke, testList)){
				//do nothing
			}
			else{
				listToReturn.add(testpoke);
			}
		}
		return listToReturn;
	}

	public ArrayList<Pokemon> missingSpawns(ArrayList<Pokemon> tester){

		ArrayList<Pokemon> returnList = new ArrayList<Pokemon>;

		for(Pokemon testp : tester){
			if(pokeInList(testp)){
				//do nothing	
			}
			else{
				returnlist.add(testp);
			}
		}
		return returnList;
	}

	public double testPerformance(ArrayList<Pokemon> testList){

		double integrity = 1.00
		double percentoff = (100 / ntotal)

		for(Pokemon p : testList){
			if(pokeInList(p){
				//do nothing and go to the next pokemon
			}
			else{
				integrity = integrity - percentoff;
			}
		}
		return integrity;
	}

	public void runTestData(ArrayList<Pokemon> testdata){

		double percentalike = testPerformance(testdata);
		
		System.out.println("Overall we managed to capture" + (percentalike*100) "% of the test spawns with our training data. ")
		}

		ArrayList<Pokemon> spawnsmissed = missingSpawns(testdata);
		ArrayList<Pokemon> spawnsmissedtest = spawnsNotInTest(testdata);

		if(spawnsmissed.size() > 0) {
			System.out.println("The following spawns were found in the test data but not in our training data");
			testList(spawnsmissed);
		}

		if(spawnsmissedtest.size() > 0) {
			System.out.println("The following spawns were found in our training data, but not the test data");
			testList(spawnsmissedtest);
		}

		System.out.println("The five Audubon Park spawn points for today have the following characteristics");
		testList(audList);

		System.out.println("The five Non-Audubon spawn points for today have the following characteristics");
		testList(nonList);

		System.out.println("Together, the ten spawn points for today have the following characteristics");
		testList(myList);

		}

	public void testList(ArrayList<Pokemon> listTest){

		int listSquirtles = 0;
		int listBulbasaurs = 0;
		int listEevees = 0;
		int listPidgeys = 0;
		int listOthers = 0;

		int listSize = listTest.length();

		for(Pokemon pt : listTest){
			if(pt.getID() == 1){
				listSquirtles = listSquirtles + 1;
			}
			if(pt.getID() == 2){
				listBulbasaurs = listBulbasaurs + 1;
			}
			if(pt.getID() == 3){
				listEevees = listEevees + 1;
			}
			if(pt.getID() == 4){
				listPidgeys = listPidgeys + 1;
			}
			if(pt.getID() == 5){
				listOthers = listOthers + 1;
			}
		}

		double ratiosquirtle = (listSquirtles / listSize);
		double ratiobulbasaur = (listBulbasaurs / listSize);
		double ratioeevee = (listEevees / listSize);
		double ratiopidgey = (listPidgeys / listSize);
		double ratioother = (listOthers / listSize);

		System.out.println("For this group there was a total of" + listSize + "spawns")
		System.out.println("Squirtles represent " + (ratiosquirtle*100) + "% of the group with" + listSquirtles + "spawns.");
		System.out.println("Bulbasaurs represent " + (ratiobulbasaur*100) + "% of the group with" + listBulbasaurs + "spawns.");
		System.out.println("Eevees represent " + (ratioeevee*100) + "% of the group with" + listEevees + "spawns.");
		System.out.println("Pidgeys represent " + (ratiopidgey*100) + "% of the group with" + listPidgeys + "spawns.");
		System.out.println("Other spawns represent " + (ratioother*100) + "% of the group with" + listOthers + "spawns.");


	}



	}



