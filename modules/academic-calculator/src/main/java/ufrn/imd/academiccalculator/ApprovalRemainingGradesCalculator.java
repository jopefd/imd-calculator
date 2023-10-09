package ufrn.imd.academiccalculator;

public final class ApprovalRemainingGradesCalculator {

    private static void validate(final SemesterGrades grades) {
        if (SemesterGradesValidator.hasNullFirstUnitGrade(grades)) {
            throw new IllegalArgumentException(
                "cannot calculate approval remaining grades with null first unit grade"
            );
        } else if (SemesterGradesValidator.hasAllNonNullUnitGrade(grades)) {
            throw new IllegalArgumentException(
                "cannot calculate approval remaining grades with all nonnull unit grade"
            );
        }
    }

    public static Float calculateByAverage(final SemesterGrades grades) {
        validate(grades);
        if (grades.secondUnitGrade() == null) {
            return (21F - grades.firstUnitGrade()) / 2;
        } else {
            return 21F - grades.firstUnitGrade() - grades.secondUnitGrade();
        }
    }

    public static Float calculateByGrade(final SemesterGrades grades) {
        validate(grades);
        if (grades.secondUnitGrade() == null) {
            return (15F - grades.firstUnitGrade()) / 2;
        } else {
            return 15F - grades.firstUnitGrade() - grades.secondUnitGrade();
        }
    }

}
