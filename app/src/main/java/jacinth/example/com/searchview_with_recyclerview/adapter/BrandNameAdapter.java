package jacinth.example.com.searchview_with_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import jacinth.example.com.searchview_with_recyclerview.R;

/**
 * Created by Navjacinth Mathew on 5/4/2017.
 */

public class BrandNameAdapter extends RecyclerView.Adapter<BrandNameAdapter.CityViewHolder> implements Filterable {

    private ArrayList<String> dataList;
    private ArrayList<String> parentList;

    public BrandNameAdapter(ArrayList<String> dataList) {
        this.dataList = dataList;
        if (!dataList.isEmpty()) {
            parentList = new ArrayList<>(dataList);
        }
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_list_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.txtCityname.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public Filter getFilter() {
        return new CityFilter(this, parentList);
    }


    class CityViewHolder extends RecyclerView.ViewHolder {

        TextView txtCityname;

        CityViewHolder(View itemView) {
            super(itemView);
            txtCityname = (TextView) itemView.findViewById(R.id.txt_brand_name);
        }
    }

    private static class CityFilter extends Filter {

        private final BrandNameAdapter adapter;

        private final ArrayList<String> originalList;

        private final ArrayList<String> filteredList;

        private CityFilter(BrandNameAdapter adapter, ArrayList<String> originalList) {
            super();
            this.adapter = adapter;
            this.originalList = new ArrayList<>(originalList);
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if (constraint.length() == 0) {
                filteredList.addAll(originalList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for (final String city : originalList) {

                    if ((city.toLowerCase()).contains(filterPattern)) {
                        filteredList.add(city);
                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            adapter.dataList.clear();
            adapter.dataList.addAll((ArrayList<String>) filterResults.values);
            adapter.notifyDataSetChanged();
        }
    }
}
