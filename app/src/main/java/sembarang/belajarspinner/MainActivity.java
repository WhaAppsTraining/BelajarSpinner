package sembarang.belajarspinner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import sembarang.belajarspinner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

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

    // Mendapatkan adapter yang akan diset ke spinner
    private ArrayAdapter getAdapter() {
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(
                        this,
                        // android.R.layout.simple_spinner_dropdown_item
                        R.layout.item_spinner // Custom layout
                        // Kalau mau lebih kompleks lagi bisa extends ArrayAdapter atau BaseAdapter langsung
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
}
