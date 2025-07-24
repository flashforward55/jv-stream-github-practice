package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && livedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForTenYears(String period) {
        try {
            String[] years = period.split("-");
            int start = Integer.parseInt(years[0]);
            int end = Integer.parseInt(years[1]);
            return (end - start) >= 10;
        } catch (Exception e) {
            throw new RuntimeException("Invalid period format: " + period);
        }
    }
}
