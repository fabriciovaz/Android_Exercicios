package testerecyclerviewgrid.com.testerecyclerviewgrid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Book> mdata ;

    public RecyclerViewAdapter(Context mContext, List<Book> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);

        //busca la no xml cardview_item_book
        view = mInflater.inflate(R.layout.cardview_item_book,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mdata.get(position).getTittle());
        holder.img_book_thumbnail.setImageResource(mdata.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,Book_Activity.class);

                //passando dados para a atividade do livro activity
                intent.putExtra("Titulo",mdata.get(position).getTittle());
                intent.putExtra("Descrição",mdata.get(position).getDescription());
                intent.putExtra("miniatura",mdata.get(position).getThumbnail());

                //iniciando atividade activity
                mContext.startActivity(intent);



            }
        });





    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView)itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView)itemView.findViewById(R.id.book_img_id);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);

        }
    }
}
