package ufrn.imd.academiccalculator;

public final class SemesterGrades {

    private Float firstUnitGrade;
    private Float secondUnitGrade;
    private Float thirdUnitGrade;

    @Override
    public String toString() {
        return "SemesterGrades{" +
            "firstUnitGrade=" + firstUnitGrade +
            ", secondUnitGrade=" + secondUnitGrade +
            ", thirdUnitGrade=" + thirdUnitGrade +
            '}';
    }

    public SemesterGrades() { }

    public Float firstUnitGrade() { return firstUnitGrade; }

    public Float secondUnitGrade() { return secondUnitGrade; }

    public Float thirdUnitGrade() { return thirdUnitGrade; }

    public static class Builder {
        private Float firstUnitGrade;
        private Float secondUnitGrade;
        private Float thirdUnitGrade;

        public Builder() {
        }

        public Builder firstUnitGrade(final Float grade) {
            this.firstUnitGrade = grade;
            return this;
        }

        public Builder secondUnitGrade(final Float grade) {
            this.secondUnitGrade = grade;
            return this;
        }

        public Builder thirdUnitGrade(final Float grade) {
            this.thirdUnitGrade = grade;
            return this;
        }

        public SemesterGrades build() {
            var grades = new SemesterGrades();
            grades.firstUnitGrade = this.firstUnitGrade;
            grades.secondUnitGrade = this.secondUnitGrade;
            grades.thirdUnitGrade = this.thirdUnitGrade;
            return grades;
        }
    }

}
