package ufrn.imd.imdcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SimpleCalculatorFragment simpleCalculatorFragment;
    private AcademicCalculatorFragment academicCalculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        academicCalculatorFragment = new AcademicCalculatorFragment();
        simpleCalculatorFragment = new SimpleCalculatorFragment();
    }

    public void onCalculatorButtonClick(View view) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frameLayout, simpleCalculatorFragment)
            .commit();
    }

    public void onAcademicCalculatorButtonClick(View view) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frameLayout, academicCalculatorFragment)
            .commit();
    }

}