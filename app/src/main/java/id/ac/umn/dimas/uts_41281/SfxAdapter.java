package id.ac.umn.dimas.uts_41281;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SfxAdapter extends RecyclerView.Adapter<SfxAdapter.ViewHolder> {
    private ArrayList<Sfx> listSfx;
    private OnItemClickCallback onItemClickCallback;
    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_SFX = 1;

    public SfxAdapter(ArrayList<Sfx> list) {
        this.listSfx = list;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Sfx data);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        ViewHolder viewHolder;

        if (viewType == VIEW_TYPE_SFX) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_sfx, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_empty, parent, false);
        }

        viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == VIEW_TYPE_SFX) {
            Sfx sfx = listSfx.get(position);

            holder.tvSfxName.setText(sfx.getName());
            holder.tvSfxCategory.setText(sfx.getCategory());
            holder.btnSfxDelete.setOnClickListener(v -> {
                removeSfx(holder.getAdapterPosition());
            });
            holder.itemView.setOnClickListener(v -> {
                onItemClickCallback.onItemClicked(listSfx.get(holder.getAdapterPosition()));
            });
        }
    }

    @Override
    public int getItemCount() {
        if (listSfx.size() == 0){
            return 1;
        } else {
            return listSfx.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listSfx.size() == 0) {
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_SFX;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSfxName;
        TextView tvSfxCategory;
        ImageButton btnSfxDelete;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSfxName = itemView.findViewById(R.id.tv_item_sfx_name);
            tvSfxCategory = itemView.findViewById(R.id.tv_item_sfx_category);
            btnSfxDelete = itemView.findViewById(R.id.button_item_sfx_delete);
        }
    }

    private void removeSfx(int position) {
        listSfx.remove(position);
        notifyDataSetChanged();
    }
}
