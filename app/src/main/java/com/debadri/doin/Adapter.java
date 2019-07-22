package com.debadri.doin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    RealmResults<Todo> realmResults;
    Context mContext;
    public Adapter(RealmResults<Todo> todos, Context context){
        realmResults = todos;
        mContext = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Todo todo = realmResults.get(position);

        assert todo != null;
        holder.todo.setText(todo.getTodoItem());
        holder.details.setText(todo.getDetails());
        holder.due.setText(todo.getDuedate());
        holder.color.setText(todo.getColor());
//        holder.gender.setText(person.getGender()==1?"Female":"Male");
//        String d= person.getDept();
//        if(d.equalsIgnoreCase("cse"))
//            holder.card.setBackgroundColor(Color.parseColor("#f44336"));
//        else if(d.equalsIgnoreCase("it"))
//            holder.card.setBackgroundColor(Color.parseColor("#3F51B5"));
//        else if(d.equalsIgnoreCase("ece"))
//            holder.card.setBackgroundColor(Color.parseColor("#4CAF50"));
//        else
//            holder.card.setBackgroundColor(Color.parseColor("#FF9800"));
    }


    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView todo;
        private TextView details;
        private TextView due;
        private TextView color;
        private ConstraintLayout card;

        public MyViewHolder(@NonNull View view) {
            super(view);
            todo = view.findViewById(R.id.todo_tv);
            details = view.findViewById(R.id.details_tv);
            due = view.findViewById(R.id.due_tv);
            color = view.findViewById(R.id.color_tv);
            card=view.findViewById(R.id.rootView);
        }
    }
}
