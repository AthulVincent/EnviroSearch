package com.example.envirosearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;

import java.util.*;

public class displayResult extends AppCompatActivity {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_result);

        int[] textviewids = {(R.id.textView2), (R.id.textView3), (R.id.textView4), (R.id.textView5), (R.id.textView6),
                (R.id.textView7), (R.id.textView8), (R.id.textView9), (R.id.textView10), (R.id.textView11),
                        (R.id.textView12), (R.id.textView13), (R.id.textView14), (R.id.textView15), (R.id.textView16),
                R.id.textView17, (R.id.textView18), (R.id.textView19), (R.id.textView20), (R.id.textView21),
                        (R.id.textView22), (R.id.textView23), (R.id.textView24), (R.id.textView25), (R.id.textView26),
                (R.id.textView27), (R.id.textView28), (R.id.textView29), (R.id.textView30), (R.id.textView31)};
        Log.d("DisplayResult:", textviewids.toString());
        int i = 0;

        ArrayList<TextView> textviewarray = new ArrayList<TextView>();

        for(; i < 30; i++){
            textviewarray.add((TextView)findViewById(textviewids[i]));
        }

        Bundle extras = getIntent().getExtras();
        ArrayList<searchResult> SR = null;
        if (extras != null) {
            SR = (ArrayList<searchResult>) getIntent().getSerializableExtra("key");
        }

        for(int j = 0; j < SR.size(); j++){
            //textviewarray.get(j*3).setText(SR.get(j).title);
            textviewarray.get(j*3+1).setText(SR.get(j).URL);
            textviewarray.get(j*3+2).setText(SR.get(j).Snippet);
            textviewarray.get(j*3).setVisibility(View.VISIBLE);
            textviewarray.get(j*3 + 1).setVisibility(View.VISIBLE);
            textviewarray.get(j*3 + 2).setVisibility(View.VISIBLE);
            //textviewarray.get(j*3 + 1).setMovementMethod(LinkMovementMethod.getInstance());
            //textviewarray.get(j*3).setLinksClickable(true);
            textviewarray.get(j*3).setClickable(true);
            //textviewarray.get(j*3).setText(Html.fromHtml(SR.get(j).URL));
            //textviewarray.get(j*3).setText(Html.fromHtml("<a href=SR.get(j).URL>${SR.get(j).title}</a>"));

        }

    }

}
