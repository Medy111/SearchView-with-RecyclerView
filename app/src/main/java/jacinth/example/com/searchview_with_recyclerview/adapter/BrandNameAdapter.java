package jacinth.example.com.searchview_with_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jacinth.example.com.searchview_with_recyclerview.R;

/**
 * Created by Navjacinth Mathew on 5/5/2017.
 */

public class BrandNameAdapter extends RecyclerView.Adapter<BrandNameAdapter.BrandViewHolder> {

    private List<String> dataList;

    public BrandNameAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_list_item, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandViewHolder holder, int position) {
        holder.txtCityname.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class BrandViewHolder extends RecyclerView.ViewHolder {

        TextView txtCityname;

        BrandViewHolder(View itemView) {
            super(itemView);
            txtCityname = (TextView) itemView.findViewById(R.id.txt_brand_name);
        }
    }
}