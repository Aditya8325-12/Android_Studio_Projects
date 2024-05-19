import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.creatingautopiechart.creatlayout;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class creatlayout {

    ArrayList<EditText> arrayLists=new ArrayList<>();

    String[] strings=new String[arrayLists.size()];
    static creatlayout myobj=new creatlayout();

    private creatlayout()
    {

    }

    public static creatlayout getInstance()
    {
        if (myobj== null)
            myobj = new creatlayout();
        return myobj;
    }


    public View CreateEditTextViews(EditText editText, int id)
    {
        editText.setLayoutParams(new LinearLayout.LayoutParams(800,LinearLayout.LayoutParams.WRAP_CONTENT));
        editText.setHint("enter no "+id);
        editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        editText.setId(100+id);
        arrayLists.add(editText);
        return editText;
    }



    public View CreateButtonView(Button button)
    {
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        int id=100;
        button.setId(100+id);
        button.setText("Enter");
        return button;
    }


    public void getvalues()
    {
        int size=arrayLists.size();
        for(int i=1;i<=size;i++)
        {
            arrayLists.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    strings[i]=arrayLists.get(i).getText().toString();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    public View CreatePieChart(PieChart pieChart)
    {
        pieChart.setLayoutParams(new LinearLayout.LayoutParams(800,800));
        ArrayList<PieEntry> pieEntries=new ArrayList<>();
        int size=arrayLists.size();

        for(int i=1;i<=size;i++)
        {
            pieEntries.add(new PieEntry(i,strings[i]));
        }
        PieDataSet pieDataSet=new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setData(new PieData(pieDataSet));
        return pieChart;
    }

}
