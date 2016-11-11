package deint.jroldan.manageproducts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import deint.jroldan.manageproducts.ManageProducts_Application;
import deint.jroldan.manageproducts.R;
import deint.jroldan.manageproducts.model.Product;

/**
 * Created by usuario on 21/10/16.
 */


// Adapter more efficient than ProductAdapterA
public class ProductAdapterB extends ArrayAdapter<Product> {
    //private Context context;

    public ProductAdapterB(Context context) {
        super(context, R.layout.item_list_products,
                ((ManageProducts_Application)context.getApplicationContext()).getProducts());
        //this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ImageView imvPhoto;
        TextView txvName;
        TextView txvStock;
        TextView txvPrice;

        if(item==null) {
            //1. Create Inflater object and initialise it from the Context casted to LayoutInflater.
            //LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //2. Inflate the view. Create into system memory the View object which contains the widgets defined in XML file.
            item = inflater.inflate(R.layout.item_list_products, null);
        }

        //3. Set variables to widget with findViewById() method.
        imvPhoto=(ImageView)item.findViewById(R.id.imvPhoto);
        txvName=(TextView)item.findViewById(R.id.txvName);
        txvStock=(TextView)item.findViewById(R.id.txvStock);
        txvPrice=(TextView)item.findViewById(R.id.txvPrice);

        //4. Assign data to Adapter.
        imvPhoto.setImageResource(getItem(position).getmImage());
        txvName.setText(getItem(position).getmName());
        txvStock.setText(getItem(position).getFormattedUnitsInStock());
        txvPrice.setText(getItem(position).getFormattedPrice());
        return item;
    }
}
