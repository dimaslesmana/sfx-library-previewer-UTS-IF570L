package id.ac.umn.dimas.uts_41281;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SfxAdapter extends RecyclerView.Adapter<SfxAdapter.ViewHolder> {
    private ArrayList<Sfx> listSfx;
    private OnItemClickCallback onItemClickCallback;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_sfx, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sfx sfx = listSfx.get(position);

        holder.tvSfxName.setText(sfx.getName());
        holder.tvSfxCategory.setText(sfx.getCategory());
        holder.btnSfxDelete.setOnClickListener(v -> {
            Toast.makeText(holder.itemView.getContext(), "DELETE " + listSfx.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            //listSfx.remove(position);
        });
        holder.itemView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(listSfx.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return listSfx.size();
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
}
