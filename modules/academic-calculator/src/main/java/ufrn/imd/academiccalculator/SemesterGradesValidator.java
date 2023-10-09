package ufrn.imd.academiccalculator;

public final class SemesterGradesValidator {

    public static Boolean hasNullFirstUnitGrade(final SemesterGrades grades) {
        return grades.firstUnitGrade() == null;
    }

    public static Boolean hasAllNonNullUnitGrade(final SemesterGrades grades) {
        return grades.thirdUnitGrade() != null;
    }

    public static Boolean hasSomeNullGrade(final SemesterGrades grades) {
        if (grades.firstUnitGrade() == null) {
            return true;
        } else if (grades.secondUnitGrade() == null) {
            return true;
        } else {
            return grades.thirdUnitGrade() == null;
        }
    }

}
