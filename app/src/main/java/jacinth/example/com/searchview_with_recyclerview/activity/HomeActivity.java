package jacinth.example.com.searchview_with_recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

import jacinth.example.com.searchview_with_recyclerview.R;
import jacinth.example.com.searchview_with_recyclerview.adapter.BrandNameAdapter;

public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchViewBrand;
    private RecyclerView recyclerViewBrand;

    private BrandNameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        getDataAsList();
        setAdapter();
    }

    private void initViews() {
        searchViewBrand = (SearchView) findViewById(R.id.search_view_brand);
        recyclerViewBrand = (RecyclerView) findViewById(R.id.recycler_view_brand);

        searchViewBrand.setOnQueryTextListener(this);
    }

    /*Method to get string array from resources as ArrayList*/
    @NonNull
    private ArrayList<String> getDataAsList() {
        ArrayList<String> dataList = new ArrayList<>();
        dataList.add("Alfa Romeo");
        dataList.add("Aston Martin");
        dataList.add("Audi");
        dataList.add("Bentley");
        dataList.add("Benz");
        dataList.add("BMW");
        dataList.add("Bugatti");
        dataList.add("Cadillac");
        dataList.add("Chevrolet");
        dataList.add("Chrysler");
        dataList.add("Citroen");
        dataList.add("Corvette");
        dataList.add("Dacia");
        dataList.add("Datsun");
        dataList.add("Dodge");
        dataList.add("Ferrari");
        dataList.add("Fiat");
        dataList.add("Ford");
        dataList.add("Honda");
        dataList.add("Hummer");
        dataList.add("Hyundai");
        dataList.add("Jaguar");
        dataList.add("Jeep");
        dataList.add("Lamborghini");
        dataList.add("Land Rover");
        dataList.add("Lexus");
        dataList.add("Lincoln");
        dataList.add("Lotus");
        dataList.add("Martini");
        dataList.add("Maserati");
        dataList.add("Mazda");
        dataList.add("McLaren");
        dataList.add("Mercedes");
        dataList.add("Mercedes Benz");
        dataList.add("Mini");
        dataList.add("Mitsubishi");
        dataList.add("Nissan");
        dataList.add("Opel");
        dataList.add("Pontiac");
        dataList.add("Porsche");
        dataList.add("Renault");
        dataList.add("Rolls Royce");
        dataList.add("Rover");
        dataList.add("Skoda");
        dataList.add("Spyker");
        dataList.add("Subaru");
        dataList.add("Suzuki");
        dataList.add("Toyota");
        dataList.add("Volkswagen");
        dataList.add("Volvo");
        return dataList;
    }

    /*Method to initialise and set the adapter*/
    private void setAdapter() {
        adapter = new BrandNameAdapter(getDataAsList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        recyclerViewBrand.setLayoutManager(layoutManager);
        recyclerViewBrand.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}
