





<!DOCTYPE html>
<html lang="en" data-color-mode="auto" data-light-theme="light" data-dark-theme="dark">
  <head>
    <meta charset="utf-8">
  <link rel="dns-prefetch" href="https://github.githubassets.com">
  <link rel="dns-prefetch" href="https://avatars.githubusercontent.com">
  <link rel="dns-prefetch" href="https://github-cloud.s3.amazonaws.com">
  <link rel="dns-prefetch" href="https://user-images.githubusercontent.com/">
  <link rel="preconnect" href="https://github.githubassets.com" crossorigin>
  <link rel="preconnect" href="https://avatars.githubusercontent.com">


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_result);

        // or do: for(int i =0, int j = 2; i < 5; i++, j=j+3)

        int[] textviewids = {(R.id.textView2), (R.id.textView3), (R.id.textView4), (R.id.textView5), (R.id.textView6),
                (R.id.textView7), (R.id.textView8), (R.id.textView9), (R.id.textView10), (R.id.textView11),
                        (R.id.textView12), (R.id.textView13), (R.id.textView14), (R.id.textView15), (R.id.textView16),
                (R.id.textView17), (R.id.textView18), (R.id.textView19), (R.id.textView20), (R.id.textView21),
                        (R.id.textView22), (R.id.textView23), (R.id.textView24), (R.id.textView25), (R.id.textView26),
                (R.id.textView27), (R.id.textView28), (R.id.textView29), (R.id.textView30), (R.id.textView31)};

        int i = 0;

        ArrayList<TextView> textviewarray = new ArrayList<TextView>();

        for(; i <= 31; i++){
            textviewarray.add((TextView)findViewById(textviewids[i]));
        }

        for(int j = 2; j <= 29; j = j+3){
            textviewarray.get(j).setMovementMethod(LinkMovementMethod.getInstance());
        }

        Bundle extras = getIntent().getExtras();
        ArrayList<searchResult> SR = null;
        if (extras != null) {
            SR = (ArrayList<searchResult>) getIntent().getSerializableExtra("key");
        }

        for(int j = 0; j < SR.size(); j++){
            textviewarray.get(j*3).setText(SR.get(j).title);
            textviewarray.get(j*3+1).setText(SR.get(j).URL);
            textviewarray.get(j*3+2).setText(SR.get(j).Snippet);
        }

    }

}
