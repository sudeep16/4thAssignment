package com.sudeep.assignment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sudeep.assignment.ContactsActivity;
import com.sudeep.assignment.R;
import com.sudeep.assignment.model.PersonDetail;

import java.util.List;

public class PersonDetailAdapter extends RecyclerView.Adapter<PersonDetailAdapter.UserDetailViewHolder> {
    Context context;
    List<PersonDetail> personDetailList;


    public PersonDetailAdapter(Context context, List<PersonDetail> personDetailList) {
        this.context = context;
        this.personDetailList = personDetailList;
    }

    @NonNull
    @Override
    public PersonDetailAdapter.UserDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.persondetail, parent, false);
        return new UserDetailViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull PersonDetailAdapter.UserDetailViewHolder holder, int position) {
        final PersonDetail personDetail = personDetailList.get(position);



        int image_id = personDetail.getImageId();
        int age = personDetail.getAge();

        holder.dispImage.setImageResource(image_id);
        holder.dispName.setText(personDetail.getName().toString());
        holder.dispAge.setText(String.valueOf(age));
        holder.dispGender.setText(personDetail.getGender().toString());
        //holder.ivImage.setImageResource(2131099747);
        holder.dispImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ContactsActivity.class);
                final int agee = personDetail.getAge();
                intent.putExtra("name",personDetail.getName());
                intent.putExtra("image",personDetail.getImageId());
                intent.putExtra("age",String.valueOf(agee));
                intent.putExtra("gender",personDetail.getGender());


                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return personDetailList.size();
    }


    public  class UserDetailViewHolder extends RecyclerView.ViewHolder {

        ImageView dispImage;
        TextView dispName, dispGender, dispAge;



        public UserDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            dispImage = itemView.findViewById(R.id.imgProfile);
            dispName = itemView.findViewById(R.id.dispName);
            dispAge = itemView.findViewById(R.id.dispAge);
            dispGender = itemView.findViewById(R.id.dispGender);

        }



    }

}



