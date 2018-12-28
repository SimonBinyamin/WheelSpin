package your.free.wheelspin.wheelspin;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.List;
import github.hellocsl.cursorwheel.CursorWheelLayout;


public class WheelAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private Context context;
    private List<SpinItem> spinItems;
    private LayoutInflater layoutInflater;
    private int iGravity;


    public WheelAdapter(Context context, List<SpinItem> spinItems) {
        this.context = context;
        this.spinItems = spinItems;
        iGravity = Gravity.CENTER;
        layoutInflater = LayoutInflater.from(context);
    }


    public WheelAdapter(Context context, List<SpinItem> spinItems, int iGravity) {
        this.context = context;
        this.spinItems = spinItems;
        this.iGravity = iGravity;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return spinItems.size();
    }

    @Override
    public View getView(View parent, int index) {
        SpinItem spinItem = getItem(index);
        View view = layoutInflater.inflate(R.layout.wheel_layout, null, false);
        TextView textView = (TextView)view.findViewById(R.id.menu_item);
        textView.setVisibility(View.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setText(spinItem.mName);
        if(textView.getLayoutParams() instanceof FrameLayout.LayoutParams)
            ((FrameLayout.LayoutParams)textView.getLayoutParams()).gravity = iGravity;
        return  view;
    }

    @Override
    public SpinItem getItem(int index) {
        return spinItems.get(index);
    }



}
