package deint.jroldan.manageproducts;

import android.app.ListActivity;
import android.os.Bundle;

import deint.jroldan.manageproducts.adapter.ProductAdapterA;
import deint.jroldan.manageproducts.adapter.ProductAdapterB;
import deint.jroldan.manageproducts.adapter.ProductAdapterC;

/**
 * As we extend from ListActivity, we don't need to create a class member for the listView
 */
public class ListProducts_Activity extends ListActivity {

    //private ListView lsvProduct;
    //private ArrayAdapter<Product> adapter;
    //private ProductAdapterA adapter;
    //private ProductAdapterB adapter;
    private ProductAdapterC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        //lsvProduct=(ListView)findViewById(R.id.lsvProduct);
        //CASO 1: Unpersonalised Adapter
        /*
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,
                ((ManageProducts_Application)getApplication()).getProducts());
        */
        /*
        adapter = new ProductAdapterA(this);
        getListView().setAdapter(adapter);
        */
        /*
        adapter = new ProductAdapterB(this);
        getListView().setAdapter(adapter);
        */
        adapter = new ProductAdapterC(this);
        getListView().setAdapter(adapter);
    }
}
