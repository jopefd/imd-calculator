package ufrn.imd.imdcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ufrn.imd.simplecalculator.SimpleCalculator;

public class SimpleCalculatorFragment extends Fragment {

    public SimpleCalculatorFragment() {
    }

    public static SimpleCalculatorFragment newInstance(String param1, String param2) {
        return new SimpleCalculatorFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private String calculate(final CharSequence expression) {
        String result = "";
        try {
            result = SimpleCalculator.calculate(expression.toString()).toString();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Operação não permitida!", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    @Override
    public View onCreateView(
        LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        var view = inflater.inflate(R.layout.fragment_simple_calculator, container, false);

        final Button button1 = view.findViewById(R.id.button1);
        final Button button2 = view.findViewById(R.id.button2);
        final Button button3 = view.findViewById(R.id.button3);
        final Button button4 = view.findViewById(R.id.button4);
        final Button button5 = view.findViewById(R.id.button5);
        final Button button6 = view.findViewById(R.id.button6);
        final Button button7 = view.findViewById(R.id.button7);
        final Button button8 = view.findViewById(R.id.button8);
        final Button button9 = view.findViewById(R.id.button9);
        final Button button0 = view.findViewById(R.id.button0);
        final Button buttonPlus = view.findViewById(R.id.buttonPlus);
        final Button buttonMinus = view.findViewById(R.id.buttonMinus);
        final Button buttonTimes = view.findViewById(R.id.buttonTimes);
        final Button buttonDivide = view.findViewById(R.id.buttonDivide);
        final Button buttonEquals = view.findViewById(R.id.buttonEquals);
        final Button buttonDelete = view.findViewById(R.id.buttonDelete);

        final TextView screen = view.findViewById(R.id.screen);

        button1.setOnClickListener(v -> screen.append(button1.getText()));
        button2.setOnClickListener(v -> screen.append(button2.getText()));
        button3.setOnClickListener(v -> screen.append(button3.getText()));
        button4.setOnClickListener(v -> screen.append(button4.getText()));
        button5.setOnClickListener(v -> screen.append(button5.getText()));
        button6.setOnClickListener(v -> screen.append(button6.getText()));
        button7.setOnClickListener(v -> screen.append(button7.getText()));
        button8.setOnClickListener(v -> screen.append(button8.getText()));
        button9.setOnClickListener(v -> screen.append(button9.getText()));
        button0.setOnClickListener(v -> screen.append(button0.getText()));
        buttonPlus.setOnClickListener(v -> screen.append(" " + buttonPlus.getText() + " "));
        buttonMinus.setOnClickListener(v -> screen.append(" " + buttonMinus.getText() + " "));
        buttonTimes.setOnClickListener(v -> screen.append(" " + buttonTimes.getText() + " "));
        buttonDivide.setOnClickListener(v -> screen.append(" " + buttonDivide.getText() + " "));

        final TextView resultViewer = view.findViewById(R.id.resultViewer);

        buttonEquals.setOnClickListener(
            v -> {
                resultViewer.setText(calculate(screen.getText()));
                screen.setText("");
            }
        );
        buttonDelete.setOnClickListener(v -> {
            screen.setText("");
            resultViewer.setText("");
        });

        return view;
    }
}