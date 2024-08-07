package com.shubhamdeshmukh.attendencemanagementsystem.frontend.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shubhamdeshmukh.attendencemanagementsystem.R;
import com.shubhamdeshmukh.attendencemanagementsystem.backend.entities.Category;
import com.shubhamdeshmukh.attendencemanagementsystem.backend.entities.Teacher;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CategorySelectionRecylerAdapter extends RecyclerView.Adapter<CategorySelectionRecylerAdapter.ViewHolder> {

    Context context;
    ArrayList<Category>categoryarrayList;



    CategorySelectionRecylerAdapter(Context context , ArrayList<Category> categoryarrayList){

        this.categoryarrayList = categoryarrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v =  LayoutInflater.from(context).inflate(R.layout.layout_category_recycler,parent,false);
       ViewHolder viewHolder = new ViewHolder(v);
       return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categoryName.setText(categoryarrayList.get(position).getName());

        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(new ClassSelectionRecyclerAdapter(context,categoryarrayList.get(position).getClassList()));
        holder.categoryCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (holder.innerclassLayout.getVisibility() == View.GONE)
                    holder.innerclassLayout.setVisibility(View.VISIBLE);
                else
                    holder.innerclassLayout.setVisibility(View.GONE);
            }
        });

    }



    @Override
    public int getItemCount() {
        return categoryarrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;
        CardView categoryCard;
        LinearLayout innerclassLayout;
        RecyclerView recyclerView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.category);
            categoryCard = itemView.findViewById(R.id.categorycard);
            innerclassLayout = itemView.findViewById(R.id.class_list);
            recyclerView = itemView.findViewById(R.id.class_list_recycler);

        }
    }

}
