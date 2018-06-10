package sembarang.belajarspinner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import sembarang.belajarspinner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://test.com";

    // memakai butterknife
    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // memakai butterknife
        // setContentView(R.layout.activity_main);
        // ButterKnife.bind(this);
        // spinner.setAdapter(getAdapter());

        forceClose();

        String url = BASE_URL + "/123";

        Toast.makeText(this, url, Toast.LENGTH_LONG).show();

        // memakai data binding
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(
                        this,
                        R.layout.activity_main
                );
        activityMainBinding.spinner.setAdapter(getAdapter());

        // cara biasa
        // Spinner spinner = findViewById(R.id.spinner);

        // TODO set spinner propinsi, kabupaten, kecamatan, dsb
        // secara dinamis dari request API(request om Reno)
    }

    private void forceClose() {
        String text = getStringFromAPI();
        TextView textView = null;
        textView.setText(text);
        setContentView(textView);
    }

    private String getStringFromAPI() {
        return null;
    }

    // Mendapatkan adapter yang akan diset ke spinner
    private ArrayAdapter getAdapter() {
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(
                        this,
                        // android.R.layout.simple_spinner_dropdown_item
                        R.layout.item_spinner
                );
        spinnerAdapter.addAll(getData());
        return spinnerAdapter;
    }

    // Mendapatkan data yang akan ditampilkan di spinner
    private List<String> getData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(
                    String.format(
                            Locale.US,
                            "Item %d",
                            i
                    )
            );
        }
        return data;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
