package ufrn.imd.imdcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ufrn.imd.academiccalculator.ApprovalChecker;
import ufrn.imd.academiccalculator.ApprovalRemainingGradesCalculator;
import ufrn.imd.academiccalculator.SemesterGrades;
import ufrn.imd.academiccalculator.SemesterGradesValidator;

public class AcademicCalculatorFragment extends Fragment {

    public AcademicCalculatorFragment() {
    }

    public static AcademicCalculatorFragment newInstance(String param1, String param2) {
        return new AcademicCalculatorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void checkApproval(final SemesterGrades grades) {
        if (ApprovalChecker.isApprovedByAverage(grades)) {
            System.out.println("Aprovado");
            Toast.makeText(getContext(), "Aprovado", Toast.LENGTH_SHORT).show();
        } else if (ApprovalChecker.isApprovedByGrade(grades)) {
            System.out.println("Aprovado por nota");
            Toast.makeText(getContext(), "Aprovado por nota", Toast.LENGTH_SHORT).show();
        } else {
            System.out.println("Reprovado");
            Toast.makeText(getContext(), "Reprovado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        var view = inflater.inflate(R.layout.fragment_academic_calculator, container, false);

        EditText grade1 = view.findViewById(R.id.grade1);
        EditText grade2 = view.findViewById(R.id.grade2);
        EditText grade3 = view.findViewById(R.id.grade3);
        final Button buttonCalculate = view.findViewById(R.id.buttonCalculate);
        final TextView situationScreen = view.findViewById(R.id.situationScreen);

        buttonCalculate.setOnClickListener(v -> {
            var builder = new SemesterGrades.Builder();
            if (!grade1.getText().toString().isEmpty())
                builder.firstUnitGrade(Float.valueOf(grade1.getText().toString()));
            if (!grade2.getText().toString().isEmpty())
                builder.secondUnitGrade(Float.valueOf(grade2.getText().toString()));
            if (!grade3.getText().toString().isEmpty())
                builder.thirdUnitGrade(Float.valueOf(grade3.getText().toString()));
            final var grades = builder.build();

            if (SemesterGradesValidator.hasAllNonNullUnitGrade(grades)) {
                checkApproval(grades);
            } else {
                final var byAverage = ApprovalRemainingGradesCalculator.calculateByAverage(grades);
                final var byGrade = ApprovalRemainingGradesCalculator.calculateByGrade(grades);
                if (grades.secondUnitGrade() == null) {
                    situationScreen.setText(
                        String.format(
                            "%s para aprovação por média ou %s para aprovação por nota na 2a e 3a unidades",
                            byAverage,
                            byGrade
                        )
                    );
                } else {
                    situationScreen.setText(
                        String.format(
                            "%s para aprovação por média ou %s para aprovação por nota na 3a unidade",
                            byAverage,
                            byGrade
                        )
                    );
                }
            }
        });

        return view;
    }

}