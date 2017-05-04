package jacinth.example.com.searchview_with_recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import jacinth.example.com.searchview_with_recyclerview.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getResourceAsList();
    }

    /*Method to get string array from resources as ArrayList*/
    @NonNull
    private List<String> getResourceAsList() {
        return Arrays.asList(getResources().getStringArray(R.array.car_brands));
    }
}
