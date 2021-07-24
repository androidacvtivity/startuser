package com.alinasoft.startuser.Helpers;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.alinasoft.startuser.R;
import com.alinasoft.startuser.Retrofit.Scientist;
import com.alinasoft.startuser.Views.DetailActivity;

/**
 * This is our adapter class. It has the following roles;
 * 1. Inflate our model layout into a view then subsequently recycle that view.
 * 2. Bind data to that view for all rows, making our recyclerview.
 * 3. Show name initials in icons with random icon bg color applied.
 * 4. Listen to click events of recyclerview item and pass the clicked item to recyclerview
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final Context c;
    private final int mBackground;
    private final int[] mMaterialColors;
    private final List<Scientist> scientists;
    public String searchString = "";

    /**
     * Our ViewHolder class. It's responsibilities include:
     * 1. Hold all the widgets which will be recycled and reference them.
     * 2. Implement click event.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements
     View.OnClickListener {
        private final TextView nameTxt;
        private final TextView starTxt;
        private final TextView galaxyTxt;
        private final TextView departTxt;
        private final TextView sectiaTxt;
        private final TextView serviciuTxt;
        private final TextView phoneTxt;
        private final TextView descriptionTxt;
        private final TextView formnameTxt;
        private final TextView phonemobileTxt;
        private final TextView emailTxt;
        private final TextView statutTxt;
        private final TextView created_dateTxt;
        private final TextView remove_dateTxt;
        private final TextView date_updatedTxt;
        private final TextView recoverydataTxt;

        private final MaterialLetterIcon mIcon;
        private ItemClickListener itemClickListener;

        /**
         * We reference our widgets
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon);

            nameTxt = itemView.findViewById(R.id.mNameTxt);
            starTxt = itemView.findViewById(R.id.mstarTxt);
            galaxyTxt = itemView.findViewById(R.id.mGalaxyTxt);
            departTxt = itemView.findViewById(R.id.mdepartTxt);
            sectiaTxt =  itemView.findViewById(R.id.msectiaTxt);
            serviciuTxt = itemView.findViewById(R.id.mserviciuTxt);
            phoneTxt = itemView.findViewById(R.id.mphoneTxt);
            descriptionTxt = itemView.findViewById(R.id.mdescriptionTxt);
            formnameTxt = itemView.findViewById(R.id.mformnameTxt);
            phonemobileTxt = itemView.findViewById(R.id.mphonemobileTxt);
            emailTxt=itemView.findViewById(R.id.emailTxt);
            statutTxt=itemView.findViewById(R.id.mstatutTxt);
            created_dateTxt= itemView.findViewById(R.id.mcreated_dateTxt);
            remove_dateTxt = itemView.findViewById(R.id.mremove_dateTxt);
            date_updatedTxt = itemView.findViewById(R.id.mdate_updatedTxt);
            recoverydataTxt = itemView.findViewById(R.id.mrecoverydataTxt);


            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

     /**
     * Our MyAdapter's costructor
     */
    public MyAdapter(Context mContext, ArrayList<Scientist> scientists) {
        this.c = mContext;
        this.scientists = scientists;
        TypedValue mTypedValue = new TypedValue();
        c.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mMaterialColors = c.getResources().getIntArray(R.array.colors);
        mBackground = mTypedValue.resourceId;
    }
    /**
     * We override the onCreateViewHolder. Here is where we inflate our model.xml
     * layout into a view object and set it's background color
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.model, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }
    /**
     * Our onBindViewHolder method
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        //get current scientist
        final Scientist s = scientists.get(position);

        //bind data to widgets
        holder.nameTxt.setText(s.getName());
        holder.starTxt.setText(s.getStar());
        holder.galaxyTxt.setText(s.getGalaxy());
        holder.departTxt.setText(s.getDepart());
        holder.sectiaTxt.setText(s.getSectia());
        holder.serviciuTxt.setText(s.getServiciu());
        holder.phoneTxt.setText(s.getPhone());
        holder.descriptionTxt.setText(s.getDescription());
        holder.formnameTxt.setText(s.getFormname());
        holder.phonemobileTxt.setText(s.getPhonemobil());
        holder.emailTxt.setText(s.getEmail());
        holder.statutTxt.setText(s.getStatut());
        holder.created_dateTxt.setText(s.getCreated_date());
        holder.remove_dateTxt.setText(s.getRemove_date());
        holder.date_updatedTxt.setText(s.getDate_updated());
        holder.recoverydataTxt.setText(s.getRecoverydata());


        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(2);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
            mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getName());

        //get name and galaxy
        String name = s.getName().toLowerCase(Locale.getDefault());
        String galaxy = s.getGalaxy().toLowerCase(Locale.getDefault());
        String star = s.getStar().toLowerCase(Locale.getDefault());
        String depart = s.getDepart().toLowerCase(Locale.getDefault());
        String sectia = s.getSectia().toLowerCase(Locale.getDefault());
        String serviciu = s.getServiciu().toLowerCase(Locale.getDefault());
        String phone = s.getPhone().toLowerCase(Locale.getDefault());
        String description = s.getDescription().toLowerCase(Locale.getDefault());
        String formname = s.getFormname().toLowerCase(Locale.getDefault());
        String phonemobile = s.getPhonemobil().toLowerCase(Locale.getDefault());


        //highlight name text while searching
        if (name.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = name.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
            newSpannable(holder.nameTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.nameTxt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh galaxy text while searching
        if (galaxy.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = galaxy.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
            newSpannable(holder.galaxyTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.galaxyTxt.setText(spanString);
        }

        else {
         //   Utils.show(ctx, "Search string empty");
        }
//highligh star text while searching
        if (star.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = star.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.starTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.starTxt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh star text while searching
        if (depart.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = depart.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.departTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.departTxt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh sectia text while searching
        if (sectia.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = sectia.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.sectiaTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.sectiaTxt.setText(spanString);
        }


        else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh serviciu text while searching
        if (serviciu.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = serviciu.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.serviciuTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.serviciuTxt.setText(spanString);
        }


        else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh serviciu text while searching
        if (phone.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = phone.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.phoneTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.phoneTxt.setText(spanString);
        }

        else {
            //Utils.show(ctx, "Search string empty");
        }

        //highligh description text while searching
        if (description.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = description.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.descriptionTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.descriptionTxt.setText(spanString);
        }



        else {
            //Utils.show(ctx, "Search string empty");
        }


        //highligh description text while searching
        if (formname.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = formname.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.formnameTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.formnameTxt.setText(spanString);
        }

        //highligh description text while searching
        if (phonemobile.contains(searchString) && !(searchString.isEmpty())) {

            int startPos = phonemobile.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.phonemobileTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.BLUE), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.phonemobileTxt.setText(spanString);
        }



        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendScientistToActivity(c, s,
         DetailActivity.class));
    }
    @Override
    public int getItemCount() {
        return scientists.size();
    }
    interface ItemClickListener {
        void onItemClick(int pos);
    }
}
//end
