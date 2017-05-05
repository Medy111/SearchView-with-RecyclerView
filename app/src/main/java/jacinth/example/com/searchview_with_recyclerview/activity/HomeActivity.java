package jacinth.example.com.searchview_with_recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jacinth.example.com.searchview_with_recyclerview.R;
import jacinth.example.com.searchview_with_recyclerview.adapter.BrandNameAdapter;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.search_view_brand)
    SearchView searchViewBrand;
    @BindView(R.id.recycler_view_brand)
    RecyclerView recyclerViewBrand;

    private BrandNameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        getResourceAsList();
        setAdapter();
    }

    /*Method to get string array from resources as ArrayList*/
    @NonNull
    private List<String> getResourceAsList() {
        return Arrays.asList(getResources().getStringArray(R.array.car_brands));
    }

    private void setAdapter() {
        adapter = new BrandNameAdapter(getResourceAsList());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);

        recyclerViewBrand.setLayoutManager(layoutManager);

        recyclerViewBrand.setAdapter(adapter);
    }
}
