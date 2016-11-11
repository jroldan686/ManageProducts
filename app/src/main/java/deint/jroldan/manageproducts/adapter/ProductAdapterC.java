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


// Totally efficient.
public class ProductAdapterC extends ArrayAdapter<Product> {
    //private Context context;

    public ProductAdapterC(Context context) {
        super(context, R.layout.item_list_products,
                ((ManageProducts_Application)context.getApplicationContext()).getProducts());
        //this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ProductHolder productHolder;

        if(item==null) {
            //1. Create Inflater object and initialise it from the Context casted to LayoutInflater.
            //LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //2. Inflate the view. Create into system memory the View object which contains the widgets defined in XML file.
            item = inflater.inflate(R.layout.item_list_products, null);
            productHolder = new ProductHolder();

            //3. Set variables to widget with findViewById() method.
            productHolder.imvPhoto = (ImageView) item.findViewById(R.id.imvPhoto);
            productHolder.txvName = (TextView) item.findViewById(R.id.txvName);
            productHolder.txvStock = (TextView) item.findViewById(R.id.txvStock);
            productHolder.txvPrice = (TextView) item.findViewById(R.id.txvPrice);
            item.setTag(productHolder);
        } else
            productHolder = (ProductHolder) item.getTag();

        //4. Assign data to Adapter.
        productHolder.imvPhoto.setImageResource(getItem(position).getmImage());
        productHolder.txvName.setText(getItem(position).getmName());
        productHolder.txvStock.setText(getItem(position).getFormattedUnitsInStock());
        productHolder.txvPrice.setText(getItem(position).getFormattedPrice());

        //5. Set different colour for odd positions
        if(position % 2 != 0) {
            item.setBackgroundResource(R.color.colorPrimary);
        } else {
            item.setBackgroundResource(R.color.colorWhite);
        }

        return item;
    }

    // Internal class that contains the XML file Widgets
    class ProductHolder {
        ImageView imvPhoto;
        TextView txvName;
        TextView txvStock;
        TextView txvPrice;
    }
}
