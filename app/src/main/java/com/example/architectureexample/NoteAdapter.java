package com.example.architectureexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();
    private onItemClicked listener;

    public interface onItemClicked {

        void itemClicked(Note note);

    }

    public void setOnItemClickListener(onItemClicked listener) {
        this.listener = listener;
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvDesctiption, tvPriority;

        public NoteHolder(@NonNull final View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.text_view_title);
            tvDesctiption = itemView.findViewById(R.id.text_view_description);
            tvPriority = itemView.findViewById(R.id.text_view_priority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (listener != null && pos != RecyclerView.NO_POSITION) {
                        listener.itemClicked(notes.get(pos));
                    }
                }
            });
        }
    }

    @NonNull
    @Override

    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.note_item, parent, false
        );

        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNode = notes.get(position);
        holder.tvTitle.setText(currentNode.getTitle());
        holder.tvDesctiption.setText(currentNode.getDescrption());
        holder.tvPriority.setText((String.valueOf(currentNode.getPriority())));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public Note getNodeAt(int position) {
        return notes.get(position);
    }
}
