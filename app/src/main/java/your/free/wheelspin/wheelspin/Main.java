package your.free.wheelspin.wheelspin;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class Main extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener  {

    CursorWheelLayout wheelLayout;
    List<SpinItem> spinItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheelLayout = (CursorWheelLayout)findViewById(R.id.wheel_text);
        loadData();
        wheelLayout.setOnMenuSelectedListener(this);
    }

    public void onSpin(View v)  {  }

    private void loadData() {
        spinItems = new ArrayList<>();
        spinItems.add((new SpinItem("hh")));
        spinItems.add((new SpinItem("hh2")));
        spinItems.add((new SpinItem("hh3")));
        spinItems.add((new SpinItem("hh4")));
        spinItems.add((new SpinItem("hh5")));
        spinItems.add((new SpinItem("hh6")));
        spinItems.add((new SpinItem("hh7")));
        spinItems.add((new SpinItem("hh8")));
        spinItems.add((new SpinItem("hh9")));
        spinItems.add((new SpinItem("off")));
        WheelAdapter adapter = new WheelAdapter(getBaseContext(), spinItems);
        wheelLayout.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        keepSpinning(pos);
    }

    public void keepSpinning(int pos){
        if (pos==9) {
            wheelLayout.setSelection(0);
        } else {
            wheelLayout.setSelection(pos+1);
        }
    }
}
