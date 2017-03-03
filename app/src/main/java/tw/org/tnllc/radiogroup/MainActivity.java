package tw.org.tnllc.radiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton femaleButton, maleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);

        RadioGroupListener radioGroupListener = new RadioGroupListener();
        radioGroup.setOnCheckedChangeListener(radioGroupListener);

        femaleButton = (RadioButton) findViewById(R.id.femaleButtonId);
        RadioButtonListener radioButtonListener = new RadioButtonListener();
        femaleButton.setOnCheckedChangeListener(radioButtonListener);

    }

    class RadioButtonListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.femaleButtonId) {
                Log.i("女: ", String.valueOf(isChecked));
            }
        }
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.femaleButtonId) {
                Log.i("姓別: ", "女");
            } else Log.i("姓別: ", "男");
        }
    }
}
