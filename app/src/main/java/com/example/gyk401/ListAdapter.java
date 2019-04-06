package com.example.gyk401;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter { //BaseAdapter classını extend ediyorum ve Override etmem gereken fonksiyonlar geliyor

    ArrayList<Food> list;
    Context c;

    public ListAdapter(ArrayList<Food> list, Context c) { //obje oluşurken gerekli olan arraylist ve contextin alınması
        this.list = list;
        this.c = c;
    }

    @Override
    public int getCount() {
        return list.size();
    } //listedeki eleman sayısını döndürür

    @Override
    public Object getItem(int position) {
        return list.get(position);
    } //listede "position" parametresine göre o indexteki elemanı döndürür

    @Override
    public long getItemId(int position) {
        return list.get(position).hashCode();
    } //position indexindeki elemanın idsini döndürür

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //itemview xmline obje bilgilerini yerleştirir.


        View row = null; //başta satırın xml referansı null olarak tanımlanır
        LayoutInflater inflater = (LayoutInflater) c //inflater tanımlanır
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) { //eğer convertView null ise itemimiz için oluşturduğumuz xmli refereans alırız
            row = inflater.inflate(R.layout.list_item_view, parent,
                    false);
        } else { //değilse convertView adındaki View değişkenini atarız.
            row = convertView;
        }

        TextView name = row.findViewById(R.id.foodNames); //rowdaki elemanların tanımlanması ve atanması
        TextView calori = row.findViewById(R.id.Calori);
        ImageView img = row.findViewById(R.id.imgFood);
        name.setText(list.get(position).getFoodName()); //itemin isminin yazılması
        calori.setText(list.get(position).getCalori().toString()+"C"); //itemin kalorisinin yazılması
        img.setBackgroundResource(list.get(position).getImageID()); //fotoğrafın objedeki imageIDye göre set edilmesi

        return row;
    }
}
