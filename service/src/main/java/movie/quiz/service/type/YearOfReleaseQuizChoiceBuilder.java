package movie.quiz.service.type;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class YearOfReleaseQuizChoiceBuilder {

	private Random rand = new Random();
	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	private final int numberOfChoices;
	private final int increment;
	
	public YearOfReleaseQuizChoiceBuilder(int numberOfChoices, int increment) {
		this.numberOfChoices = numberOfChoices;
		this.increment = increment;
	}
	
	public List<Integer> build(int year) {
		int choice = createRandomPositionIndex(year);
		return addChoices(year, choice);
	}

	private int createRandomPositionIndex(int year) {
		if(year>CURRENT_YEAR-(numberOfChoices-1)*increment) {
			return handleRecentYear(year);
		} else {
			return rand.nextInt(numberOfChoices) + 1;
		}
	}

	private int handleRecentYear(int year) {
		if (year > CURRENT_YEAR - increment) {
			return numberOfChoices;
		} else {
			for(int i = 1 ; i<numberOfChoices; i++) {
				if(year > CURRENT_YEAR - i*increment) {
					return (rand.nextInt(i)+1) + (numberOfChoices-i);
				}
			}
			String msg = String.format("Unexpected case for context [year = %s]", year);
			throw new IllegalStateException(msg);
		}
	}

	private List<Integer> addChoices(int year, int choice) {
		List<Integer> choices =new ArrayList<>();
		int startYear = year - increment*(choice-1);
		for(int i = 0; i<numberOfChoices; i++) {
			choices.add(startYear+increment*i);
		}
		return choices;
	}
}
