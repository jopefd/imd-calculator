package ufrn.imd.academiccalculator;

public final class ApprovalChecker {

    private static Float semesterAverage(final SemesterGrades grades) {
        return (grades.firstUnitGrade() + grades.secondUnitGrade() + grades.thirdUnitGrade()) / 3;
    }

    private static void validate(final SemesterGrades grades) {
        if (SemesterGradesValidator.hasSomeNullGrade(grades))
            throw new IllegalArgumentException("cannot check approval with some null grade");
    }

    public static Boolean isApprovedByAverage(final SemesterGrades grades) {
        validate(grades);
        return semesterAverage(grades) >= 7F;
    }

    public static Boolean isApprovedByGrade(final SemesterGrades grades) {
        validate(grades);
        return semesterAverage(grades) >= 5F;
    }

}
